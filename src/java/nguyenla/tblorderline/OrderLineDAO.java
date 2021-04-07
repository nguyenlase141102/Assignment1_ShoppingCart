/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tblorderline;

import dbHelper.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ANH NGUYEN
 */
public class OrderLineDAO {

    public static boolean addOrderLine(int OrderID, String foodID, int quantity, float price) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Insert into orderLineTBL values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, OrderID);
                ps.setString(2, foodID);
                ps.setInt(3, quantity);
                ps.setFloat(4, price);
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
}
