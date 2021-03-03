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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

public class ReceiveImage extends Thread{
    boolean stopped = false;
    boolean disconnected = false;
    Socket socket = null;
    Connection conn = null;
    
    public ReceiveImage(Socket socket) {
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
            InputStream inputStream = socket.getInputStream();
            while (true) {
                String sentence = fromClient.readLine();// Chuỗi nhận được từ Client
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM UserManagement");
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    if(rs.getString("username").equals(sentence)){
                        ps = conn.prepareStatement("UPDATE UserManagement SET imageURL = '"+sentence+"' WHERE username = '"+sentence+"';");
                        ps.executeUpdate();
                        break;
                    }
                            
                }
                byte[] sizeAr = new byte[4];
                inputStream.read(sizeAr);
                
                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                byte[] imageAr = new byte[size];
                
                inputStream.read(imageAr);

                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
                ImageIO.write(image, "jpg", new File("..\\Server_Auction\\src\\images\\"+sentence+".jpg"));
            }   
        } catch (Exception e) {
            System.out.println("section "+this.getName() +" had finish");
            this.disconnected = true;
            e.printStackTrace();
        }
    }
   
}
