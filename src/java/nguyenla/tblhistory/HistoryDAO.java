    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tblhistory;

import dbHelper.Dbutil;
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
public class HistoryDAO {

    public static boolean addHistory(String id,String name,String action,String date2,String status,String foodID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Insert into historyTBL values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, action);
                ps.setString(4,date2);
                ps.setString(5,status);
                ps.setString(6,foodID);
                int r = ps.executeUpdate();
                if (r > 0) {
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

    public static List<HistoryDTO> getHistory() throws SQLException, NamingException {
        List<HistoryDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Dbutil.openConnect();
            if (con != null) {
                String sql = "Select foodID,name,action,date from historyTBL";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String action = rs.getString(3);
                    String date = rs.getString(4);
                    
                    HistoryDTO h = new HistoryDTO(id, name, action, date);
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
