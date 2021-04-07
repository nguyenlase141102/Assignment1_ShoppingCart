/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tbluser;

import dbHelper.Dbutil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nguyenla.tblfood.FoodDTO;

/**
 *
 * @author ANH NGUYEN
 */
public class UserDAO implements Serializable {

    
        public static String getNameAdmin(String userName,String passwords) throws SQLException,NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Dbutil.openConnect();
            if(con!=null){
                String sql = "Select userName  from adminTBL where userName = ? and passwordAdmin = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,userName);
                ps.setString(2,passwords);
                rs = ps.executeQuery();
                while(rs.next()){
                    String name = rs.getString(1);
                    return name;
                }
            }
        }finally{
             if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return "";
    }
        public static String checkLogin(String userName, String passwords) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select userID from userTBL where userID = ? and passwords = ? ";
                pre = con.prepareStatement(sql);
                pre.setString(1, userName);
                pre.setString(2, passwords);
                rs = pre.executeQuery();
                while (rs.next()) {
                    String name = rs.getString(1);
                    return name;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return "";
    }
        public static boolean addAccountGoogle(UserDTO u) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Insert into userTBL values(?,?,?,?,?)";
                pre = con.prepareStatement(sql);
                pre.setString(1, u.getUserID());
                pre.setString(2, u.getUserPassword());
                pre.setString(3,u.getUserName());
                pre.setBoolean(4,u.isIsSex());
                pre.setBoolean(5,u.isIsAdmin());
                int row = pre.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (pre != null) {
                pre.close();
            }
           
        }
        return false;
    }
            public static List<FoodDTO> getFoodFavourite(String nameUser) throws SQLException, NamingException {
                List<FoodDTO> listFood = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "select f.id,count(f.id) as times , f.name ,f.price,f.image\n" +
"from orderTBL as o,orderLineTBL as ol,foodTBL as f  where o.OrderId = ol.OrderId and f.id = ol.id\n" +
"and o.userID = ? \n" +
"group by f.id,f.name,f.price,f.image\n" +
"Order by count(f.id) DESC\n" +
"OFFSET 0 ROWS FETCH NEXT 2 ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setString(1,nameUser);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(3);
                    Float price = rs.getFloat(4);
                    String image = rs.getString(5);
                    FoodDTO food = new FoodDTO(id, name, image,price);
                    listFood.add(food);
                }
                return listFood;
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }
}
