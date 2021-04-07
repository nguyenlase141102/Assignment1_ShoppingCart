package nguyenla.tbluserhistory;


import dbHelper.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANH NGUYEN
 */
public class UserHistoryDAO {
        public static boolean addUserHistory(String name,int quantity,Float price,String date,int OrderID,String nameUser) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Dbutil.openConnect();
            if(con != null){
                String sql = "Insert into userHistoryTBL values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1,name);
                ps.setInt(2, quantity);
                ps.setFloat(3,price);
                ps.setString(4,date);
                ps.setInt(5, OrderID);
                ps.setString(6,nameUser);
                int row = ps.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
         
        }finally{
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        return false;
    }
    
        public static List<UserHistoryDTO> getUserHistory(String nameUser) throws SQLException, NamingException {
        List<UserHistoryDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select nameFood,quantityFood,priceFood,currentDate from userHistoryTBL where nameUser = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,nameUser);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String nameHistory = rs.getString(1);
                    int quantityHistory = rs.getInt(2);
                    float priceHistory = rs.getFloat(3);
                    String dateHistory = rs.getString(4);
                    UserHistoryDTO h = new UserHistoryDTO(nameHistory, dateHistory, quantityHistory, priceHistory);
                    list.add(h);
                }
                return list;
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
        public static List<UserHistoryDTO> searchUserHistory(String date,String nameFood) throws SQLException, NamingException {
        List<UserHistoryDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select nameFood,quantityFood,priceFood,currentDate from userHistoryTBL where nameFood like ? and currentDate like ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1,"%"+nameFood+"%");
                ps.setString(2,"%"+date+"%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String nameHistory = rs.getString(1);
                    int quantityHistory = rs.getInt(2);
                    float priceHistory = rs.getFloat(3);
                    String dateHistory = rs.getString(4);
                    UserHistoryDTO h = new UserHistoryDTO(nameHistory, dateHistory, quantityHistory, priceHistory);
                    list.add(h);
                }
                return list;
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
