/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tblfood;

import dbHelper.Dbutil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ANH NGUYEN
 */
public class FoodDAO implements Serializable {

    public static FoodDTO getFoodByIDs(String id) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "select id,name,image,category,status,quantity,price,createDate  from foodTBL where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                  String idFood = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                     String category = rs.getString(4);
                    String status = rs.getString(5);
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(idFood, name, image,date,category, status, quantity, price);
                    return getFood;
                }

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
        public static FoodDTO getAllFood(String id) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "select id,name,image,category,status,quantity,price,createDate  from foodTBL where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                  String idFood = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                     String category = rs.getString(4);
                    String status = rs.getString(5);
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(idFood, name, image,date,category, status, quantity, price);
                    return getFood;
                }

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

    public static FoodDTO getFoodUpdate(String id) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "select image,category,status,quantity,price,createDate,descrip from foodTBL where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String image = rs.getString(1);
                    String category = rs.getString(2);
                    String status = rs.getString(3);

                    int quantity = rs.getInt(4);
                    float price = rs.getFloat(5);
                    String date = rs.getString(6);
                    String description = rs.getString(7);
                    FoodDTO getFood = new FoodDTO(image, description, date, category, status, quantity, price);
                    return getFood;
                }

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

    public static int getQuantityFoodByID(String id) throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select quantity  from foodTBL where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }

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
        return 0;
    }

    public static boolean reduceQuantity(int quantity, int quantityCart, String id) throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Update foodTBL set quantity = ?-? where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, quantity);
                ps.setInt(2, quantityCart);
                ps.setString(3, id);
                int row = ps.executeUpdate();
                while (row > 0) {
                    return true;
                }

            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }

        }
        return false;
    }

    public static int countFood(String nameSearch, String active, float from, float to, String category) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select count(*) from foodTBL where name like ? and status = ? and price between ? and ? and category = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + nameSearch + "%");
                ps.setString(2, active);
                ps.setFloat(3, from);
                ps.setFloat(4, to);
                ps.setString(5, category);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
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
        return 0;
    }

    public static int countHomePage() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select count(*) from foodTBL";
                ps = con.prepareStatement(sql);
             
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
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
        return 0;
    }
    
       public static int countHomePageUser(String status) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select count(*) from foodTBL where status = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,status);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
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
        return 0;
    }

    public static int countCategory(String nameSearch, float from, float to, String active) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select count(*) from foodTBL where category = ? and price between ? and ? and status = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, nameSearch);
                ps.setFloat(2, from);
                ps.setFloat(3, to);
                ps.setString(4, active);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
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
        return 0;
    }

    public static int countOnlyCategory(String category, String active) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select count(*) from foodTBL where category = ? and status = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, category);
                ps.setString(2, active);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
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
        return 0;
    }

    public static int countNotPrice(String category, String nameSearch, String active) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select count(*) from foodTBL where category = ? and name like ? and status = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, category);
                ps.setString(2, "%" + nameSearch + "%");
                ps.setString(3, active);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
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
        return 0;
    }

    public static boolean addFood(FoodDTO d) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Insert into foodTBL values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, d.getIdFood());
                ps.setString(2, d.getNameFood());
                ps.setString(3, d.getImageFood());
                ps.setString(4, d.getDescriptionFood());
                ps.setFloat(5, d.getPriceFood());
                ps.setString(6, d.getCreateDateFood());
                ps.setString(7, d.getCategoryFood());
                ps.setString(8, d.getStatusFood());
                ps.setInt(9, d.getQuantityFood());
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }

        }
        return false;
    }

    public static List<FoodDTO> searchFood(String nameSearch, int index, String cate, float from, float to, String active) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "with x as (select ROW_NUMBER() over(order by createDate desc) as r, * from foodTBL where name like ? and category = ? and price between ? and ? and status = ?)\n"
                        + "select id,name,image,category,status,quantity,price,createDate  from x where r between ?*8-7 and ?*8";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + nameSearch + "%");
                ps.setString(2, cate);
                ps.setFloat(3, from);
                ps.setFloat(4, to);
                ps.setString(5, active);
                ps.setInt(6, index);
                ps.setInt(7, index);

                rs = ps.executeQuery();
                while (rs.next()) {
                   String id = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                     String category = rs.getString(4);
                    String status = rs.getString(5);
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(id, name, image,date,category, status, quantity, price);
                    list.add(getFood);
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

    public static List<FoodDTO> searchByCategory(String nameSearch, int index, float from, float to, String active) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "with x as (select ROW_NUMBER() over(order by createDate desc) as r, * from foodTBL where category = ? and price between ? and ? and status = ? )\n"
                        + "select id,name,image,category,status,quantity,price,createDate  from x where r between ?*8-7 and ?*8";
                ps = con.prepareStatement(sql);
                ps.setString(1, nameSearch);
                ps.setFloat(2, from);
                ps.setFloat(3, to);
                ps.setString(4, active);
                ps.setInt(5, index);
                ps.setInt(6, index);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                     String category = rs.getString(4);
                    String status = rs.getString(5);
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(id, name, image,date,category, status, quantity, price);
                    list.add(getFood);
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

    public static List<FoodDTO> searchOnlyCategory(String category2, String active, int index) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "with x as (select ROW_NUMBER() over(order by createDate desc) as r, * from foodTBL where category = ? and status = ? )\n"
                        + "select id,name,image,category,status,quantity,price,createDate  from x where r between ?*8-7 and ?*8";
                ps = con.prepareStatement(sql);
                ps.setString(1, category2);
                ps.setString(2, active);
                ps.setInt(3, index);
                ps.setInt(4, index);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                    String category = rs.getString(4);
                    String status = rs.getString(5);
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(id, name, image, date, category, status, quantity, price);
                    list.add(getFood);
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

    public static List<FoodDTO> searchNotPrice(String category2, String nameSearch, String active, int index) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "with x as (select ROW_NUMBER() over(order by createDate desc) as r, * from foodTBL where category = ? and name like ? and status = ? )\n"
                        + "select id,name,image,category,status,quantity,price,createDate  from x where r between ?*8-7 and ?*8";
                ps = con.prepareStatement(sql);
                ps.setString(1, category2);
                ps.setString(2, "%" + nameSearch + "%");
                ps.setString(3, active);
                ps.setInt(4, index);
                ps.setInt(5, index);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                    String category = rs.getString(4);
                    String status = rs.getString(5);
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(id, name, image, date, category, status, quantity, price);
                    list.add(getFood);
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

    public static List<FoodDTO> pageFood(int index) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "with x as (select ROW_NUMBER() over(order by createDate desc) as r, * from foodTBL)\n"
                        + "select id,name,image,category,status,quantity,price,createDate from x where r between ?*8-7 and ?*8";
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, index);
                ps.setInt(2, index);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                    String category = rs.getString(4);
                    String status = rs.getString(5).trim();
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(id, name, image, date, category, status, quantity, price);
                    list.add(getFood);
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
    public static List<FoodDTO> pageUser(int index,String statusFood) throws SQLException, NamingException {
        List<FoodDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "with x as (select ROW_NUMBER() over(order by createDate desc) as r, * from foodTBL where status = ?)\n"
                        + "select id,name,image,category,status,quantity,price,createDate from x where r between ?*8-7 and ?*8";
                ps = con.prepareStatement(sql);
                ps.setString(1,statusFood);
                ps.setInt(2, index);
                ps.setInt(3, index);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String image = rs.getString(3);
                    String category = rs.getString(4);
                    String status = rs.getString(5).trim();
                    int quantity = rs.getInt(6);
                    float price = rs.getFloat(7);
                    String date = rs.getString(8);
                    FoodDTO getFood = new FoodDTO(id, name, image, date, category, status, quantity, price);
                    list.add(getFood);
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
    public static boolean deleteFood(String status, String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Update foodTBL set status = ? where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, status);
                ps.setString(2, id);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return false;
    }

    public static boolean updateFood(FoodDTO f) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Update foodTBL set name = ?,image = ?,descrip = ?,price = ?,createDate = ?,category = ?,status = ?,quantity = ? where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, f.getNameFood());
                ps.setString(2, f.getImageFood());
                ps.setString(3, f.getDescriptionFood());
                ps.setFloat(4, f.getPriceFood());
                ps.setString(5, f.getCreateDateFood());
                ps.setString(6, f.getCategoryFood());
                ps.setString(7, f.getStatusFood());
                ps.setInt(8, f.getQuantityFood());
                ps.setString(9, f.getIdFood());
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }

            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
