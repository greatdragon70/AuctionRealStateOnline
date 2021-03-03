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
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

public class SendImage extends Thread{
    boolean stopped = false;
    boolean disconnected = false;
    Socket socket = null;
    Connection conn = null;
    
    public SendImage(Socket socket) {
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
            OutputStream outputStream = socket.getOutputStream();
            while (true) {
                
                
                String sentence = fromClient.readLine();// Chuỗi nhận được từ Client
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM UserManagement");
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    if(rs.getString("username").equals(sentence)){
                        if(!sentence.equals(rs.getString("imageURL"))){
                            sentence = "user";
                        }
                        
                        break;
                    }
                            
                }
                BufferedImage image = ImageIO.read(new File("..\\Server_Auction\\src\\images\\"+sentence+".jpg"));

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", byteArrayOutputStream);

                byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
                
                outputStream.write(size);
                
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.flush();

            }

        } catch (Exception e) {
            System.out.println("section "+this.getName() +" had finish");
            this.disconnected = true;
            e.printStackTrace();
        }
    }
   
}
