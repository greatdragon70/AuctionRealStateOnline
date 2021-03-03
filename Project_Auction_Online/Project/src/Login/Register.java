package Login;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Bao Long
 */
public class Register {
    //Change the first Character to UpperCase and delete the space ;
    public String editSpaceOrUpperCase(String name) {
        name = name.trim();
        name = name.replaceAll("\\s+"," ");
        
        String []t = name.split(" ");
        name = "";
        for (int i = 0; i < t.length; i++) {
            name += String.valueOf(t[i].charAt(0)).toUpperCase() + t[i].substring(1);
         if (i < t.length - 1) 
            name += " ";
        }
        return name;
    }
    
    //Check if sth is empty
    public boolean checkIsEmpty(String empty){
        return empty.equals("");
    }
    
    //Check name or address,nationality valid
    public boolean checkIsString(String name){
        return name.matches("[a-zA-Z\\s]{0,50}");
    }
    
    public boolean checkIsAddress(String address){
        return address.matches("[a-zA-Z0-9\\s]{0,50}");
    }
    
    //check age valid
    public boolean checkIsAge(String age){
        return age.matches("[0-9]{0,2}");
    } 
 
    //check phone number valid
    public boolean checkIsPhoneNumber(String phoneNumber){
        return phoneNumber.matches("[0-9]{0,11}");
    }
    
    //check gmail valid
    public boolean checkIsMail(String mail){
        return mail.matches("^[A-Za-z0-9]+@(.+\\.+.+)");
    }
    
    //check Nickname valid
    public boolean checkIsNickName(String password){
        return password.matches("[A-Za-z0-9!@#$%^&*+=_-]{0,50}");
    }
    
    //check username
    public boolean checkIsUser(String user){
        return user.matches("[a-zA-Z0-9]{5,50}");
    }
    
    //check password
    public boolean checkIsPassWord(String password){
        return password.matches("[a-zA-Z0-9]{6,50}");
    }
    
    //check special symbol valid
    public boolean checkIsSpecialSymbol(String name){
        return name.matches("[!@#$%^&*+=_-]");
    }
    
    public static String createCaptchaValue(){
        Random random = new Random();        
        StringBuilder captchaBuilder = new StringBuilder();
        int length = 4; //the length of captcha(Change this if you want)
        for(int i=0; i< length;i++){
            int numberRandom = random.nextInt(100);            
            int captchaString = 0;
            if(numberRandom <= 50){
                captchaString = random.nextInt(25) + 65;// UpperCase Character
            } 
//          else if(numberRandom <=75){
//              captchaString = random.nextInt(25) + 97;  //LowerCase Character 
//          }
            else {
                captchaString = random.nextInt(10) + 48;    //Number Character 
            }
            captchaBuilder.append((char) captchaString);
        }
        return captchaBuilder.toString();
    }
}



