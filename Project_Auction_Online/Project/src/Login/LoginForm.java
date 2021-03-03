package Login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class LoginForm {
    
  public static String cryptWithMD5(String pass){
         MessageDigest md;
    try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
//        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
      
    }
        return null;

}
  public static boolean checkLogin(String password,String userName, String password1,String userName1){
    
        
        password = cryptWithMD5(password);
        
        if(userName.equals(userName1)&&password.equals(password1)){
           return true;
        }  
                 return false;
        
  }           
  public static boolean loginAction(String password,String userName,String[] res){
          
         if(checkLogin(password, userName, cryptWithMD5(res[6]), res[5])) {
             return true;
         
      }
      return false;
  }
}
      
  
