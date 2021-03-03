/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auction_Management;

/**
 *
 * @author asus
 */
public class AuctionUserCheck {
    public boolean checkIsEmpty(String empty){
        return empty.equals("");
    }
    public boolean checkIsString(String name){
        checkIsEmpty(name);
        return name.matches("[a-zA-Z\\s]{0,50}");
    }
    public boolean checkIsPrice(String price){
        checkIsEmpty(price);
        return price.matches("[0-9]{0,11}");
    }
    
}
