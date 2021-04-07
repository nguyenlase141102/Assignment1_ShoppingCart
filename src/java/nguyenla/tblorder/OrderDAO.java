/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tblorder;

import dbHelper.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ANH NGUYEN
 */
public class OrderDAO {

    public static boolean addOrder(int OrderID, String userID, String payment, String date) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Insert into orderTBL values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, OrderID);
                ps.setString(2, userID);
                ps.setString(3, payment);
                ps.setString(4, date);
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
