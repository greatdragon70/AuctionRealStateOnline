package Server;

import GUI_Management.AdminManagement;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

public class ThreadSocket extends Thread{
    boolean stopped = false;
    boolean disconnected = false;
    Socket socket = null;
    Connection conn = null;
    
    public ThreadSocket(Socket socket) {
        this.socket = socket;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Auction;"
                    + "username=sa;password=sa");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    
    

    
    public void run() {
        try {
            DataOutputStream sendToClient = new DataOutputStream(socket.getOutputStream());// Tao output stream
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Tao input stream
            
            while (true) {
                
                
                String sentence = fromClient.readLine();// Chuỗi nhận được từ Client
//                System.out.println("FROM CLIENT: " + sentence);
                String[] string = sentence.split("##");
                if(stopped){
                    System.out.println("section "+this.getName() +"had finish");
                    disconnected = true;
                    break;
                }
                if (string[0].equalsIgnoreCase("select")) {
                    if(string[1].equalsIgnoreCase("person")){
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM person");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            sentence = rs.getString("fullname")+"##"+rs.getString("age")+"##"+rs.getString("gmail")+"##"+rs.getString("addressUser")+"##"+rs.getString("phone")+"##"+rs.getString("username")+"##"+rs.getString("passwordUser")+"##"+rs.getString("nationality")+"##"+rs.getString("statement");                            
                            sendToClient.writeBytes(sentence + '\n');
                            
                        }
                        sendToClient.writeBytes("quit\n");
                    }else if(string[1].equals("productBought")){
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM productBought");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            sentence = rs.getString("id")+"##"+rs.getString("imageURL")+"##"+rs.getString("nameProduct")+"##"+rs.getString("infoProduct")+"##"+rs.getString("price")+"##"+rs.getString("fullname")+"##"+rs.getString("username")+"##"+rs.getString("DateT");
                            sendToClient.writeBytes(sentence + '\n');
                        }
                        sendToClient.writeBytes("quit\n");
                    }else if(string[1].equals("UserManagement")){
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM UserManagement");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            sentence = rs.getString("username")+"##"+rs.getString("imageURL")+"##"+rs.getString("moneyUser")+"##"+rs.getString("rankUser")+"##"+rs.getString("topUser")+"##"+rs.getString("point")+"##"+rs.getString("totalmoney")+"##"+rs.getString("moneySpent")+"##"+rs.getString("fullname");
                            sendToClient.writeBytes(sentence + '\n');
                        }
                        sendToClient.writeBytes("quit\n");
                    }else if(string[1].equals("Recharge")){
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Recharge");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            sentence = rs.getString("series")+"##"+rs.getString("code")+"##"+rs.getString("money");
                            sendToClient.writeBytes(sentence + '\n');
                        }
                        sendToClient.writeBytes("quit\n");
                    }else if(string[1].equals("product")){
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM product");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            sentence = rs.getString("id")+"##"+rs.getString("imageURL")+"##"+rs.getString("nameProduct")+"##"+rs.getString("infoProduct")+"##"+rs.getString("price")+"##"+rs.getString("fullname")+"##"+rs.getString("username")+"##"+rs.getString("DateT")+"##"+rs.getString("Dtime")+"##"+rs.getString("newMoney")+"##"+rs.getString("clock")+"##"+rs.getString("audition_price")+"##"+rs.getString("numberOfAuction");
                            sendToClient.writeBytes(sentence + '\n');
                        }
                        sendToClient.writeBytes("quit\n");
                    }else if(string[1].equals("max")){
                        
                        int max1 = 0;
                        int max2 = 0;
                        int max;
                        Statement stmt = conn.createStatement();
                        String query = "select max(id) from product";
                        String query2 = "select max(id) from productBought";
                        ResultSet rs=stmt.executeQuery(query);          
                        //Extact result from ResultSet rs
                        while(rs.next()){
                            max1 = rs.getInt(1);      
                            
                        }rs.close();
                        rs=stmt.executeQuery(query2); 
                        while(rs.next()){
                            max2 = rs.getInt(1);      
                            
                        }rs.close();

                        if(max1 > max2) max = max1+1;
                        else max = max2+1;
                        sendToClient.writeBytes(""+max+"\n");
                }
                   
                }else if(string[0].equalsIgnoreCase("insert")){
                    if(string[1].equals("person")){
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO "+string[1]+" VALUES ("+string[2]+","+string[3]+","+string[4]+","+string[5]+","+string[6]+","+string[7]+","+string[8]+","+string[9]+");");
                        ps.executeUpdate();
                        
                        ps =  conn.prepareStatement("INSERT INTO UserManagement VALUES ("+string[7]+", '..Project\\src\\images\\user.png' , 0 , 'Copper', 1000, 0, 0, 0);");
                        ps.executeUpdate();
                    }else if(string[1].equals("product")){
                        Date date = new Date();                        
                        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                        String day = ft.format(date);
                        ft = new SimpleDateFormat ("hh:mm:ss");
                        String time = ft.format(date);
                        
                        
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES ("+string[7]+",'"+string[7]+"','"+string[2]+"','"+string[3]+"','"+string[4]+"',null,'"+string[6]+"','"+day+"','"+time+"',0,180,"+string[5]+",0);");
                        ps.executeUpdate();
                    }
                    
                    
                }else if(string[0].equalsIgnoreCase("update")){
                    if(string[1].equals("UserManagement")){
                        PreparedStatement ps = conn.prepareStatement("UPDATE "+string[1]+" SET moneyUser = "+string[4]+", rankUser = '"+string[5]+"', totalMoney = "+string[8]+", imageURL = '"+string[3]+"', topUser = "+string[6]+", point = "+string[7]+", moneySpent = "+string[9]+" where username = '"+string[2]+"';");
                        ps.executeUpdate();
                        
                    }else if(string[1].equals("person")){
                        PreparedStatement ps = conn.prepareStatement("UPDATE "+string[1]+" SET fullname = '"+string[2]+"', age = "+string[3]+", gmail = '"+string[4]+"', addressUser = '"+string[5]+"', phone = '"+string[6]+"', passwordUser = '"+string[7]+"', nationality = '"+string[8]+"' where username = '"+string[9]+"';");
                        ps.executeUpdate();
                    }else if(string[1].equals("statement")){
                        PreparedStatement ps = null;
                        if(string[4].equals("online")){
                            ps = conn.prepareStatement("UPDATE "+string[2]+" SET statement = 'online' where username = '"+string[3]+"';");
                        }else if(string[4].equals("offline")){
                            ps = conn.prepareStatement("UPDATE "+string[2]+" SET statement = 'offline' where username = '"+string[3]+"';");
                        }                       
                        ps.executeUpdate();
                    }else if(string[1].equals("name")){
                        PreparedStatement ps = conn.prepareStatement("UPDATE "+string[2]+" SET fullname = '"+string[3]+"' where username = '"+string[4]+"';");
                        ps.executeUpdate();
                    }
                }else if(string[0].equalsIgnoreCase("DELETE")){
                    if(string[1].equals("Recharge")){
                        PreparedStatement ps = conn.prepareStatement("DELETE FROM Recharge WHERE code = "+string[2]+";");
                        ps.executeUpdate();
                    }else if(string[1].equals("product")){
                        PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE id = "+string[2]+";");
                        ps.executeUpdate();
                    }
                        
                }else{
                    PreparedStatement ps = conn.prepareStatement(string[0]);
                    ps.executeUpdate();
                }

            }

        } catch (Exception e) {
            System.out.println("section "+this.getName() +" had finish");
            this.disconnected = true;
            e.printStackTrace();
        }
    }
   
}
