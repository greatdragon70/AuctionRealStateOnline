/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author asus
 */
public class fogotPass {
    
     public static boolean checkInfo(String userName,String gmail, String userName1,String gmail1){
    
        
        
        if(userName.equals(userName1)&&gmail.equals(gmail1)){
           return true;
        }  
                 return false;
        
  }           
     
    public static String createCapcha(){
        Random rd = new Random();
        StringBuilder capchaBuider = new StringBuilder();
        int length=4;
        for(int i=0;i<length;i++){
            int numberRandom = rd.nextInt(100);
            int capchaString=0;
            if(numberRandom<=50){
                capchaString = rd.nextInt(25)+65;
            }else{
                capchaString = rd.nextInt(10)+48;
            }
            capchaBuider.append((char) capchaString);
        }
        return capchaBuider.toString();
    } 
    public static String newPass(){
        Random rd = new Random();
        StringBuilder capchaBuider = new StringBuilder();
        int length=6;
        for(int i=0;i<length;i++){
            int numberRandom = rd.nextInt(100);
            int capchaString=0;
            if(numberRandom<=50){
                capchaString = rd.nextInt(25)+65;
            }else{
                capchaString = rd.nextInt(10)+48;
            }
            capchaBuider.append((char) capchaString);
        }
        return capchaBuider.toString();
    } 
  public static boolean infoAction(String userName,String gmail,String[] s) throws SQLException{
     
      
         if(checkInfo(userName, gmail, s[0], s[1])) {
             return true;
         
      }
      return false;
  }
}
