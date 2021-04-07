/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tbluser;

import java.io.Serializable;

/**
 *
 * @author ANH NGUYEN
 */
public class UserDTO implements Serializable{
    private String userID,userPassword,userName;
    private boolean isSex,isAdmin;

    public UserDTO() {
    }

    public UserDTO(String userID, String userPassword, String userName, boolean isSex, boolean isAdmin) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.isSex = isSex;
        this.isAdmin = isAdmin;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isIsSex() {
        return isSex;
    }

    public void setIsSex(boolean isSex) {
        this.isSex = isSex;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    

  

    

    
        
    
}
