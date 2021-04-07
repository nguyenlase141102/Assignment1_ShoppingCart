/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ANH NGUYEN
 */
public class Valid {
    
    public static boolean checkEmpty(String var){
        
        if(var.equals("")){
            return false;
        }
        return true;
    }
    
    public static boolean checkSpecialCharac(String var){
       if(!var.matches("^[a-zA-Z0-9 ]{0,300}$")){
            return false;
        }
        return true;
    }
    public static boolean checkPrice(String price){
        if(!price.matches("^\\d++[.][0-9]+$")){
            return false;
        }
        return true;
    }
    public static boolean checkInteger(String price){
        if(!price.matches("^\\d[0-9]+$")){
            return false;
        }
        return true;
    }
    public static boolean checkDate (String date){
        try {
            DateFormat  df = new SimpleDateFormat("yyyy-mm-dd");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
