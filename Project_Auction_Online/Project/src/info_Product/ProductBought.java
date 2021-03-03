/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info_Product;

import Auction_Management.RechargeUser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author icydeath
 */
public class ProductBought extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    String value;
    DataOutputStream sendToServer;
    Socket clientSocket;
    String localhost;
    BufferedReader inFromServer;
            DataOutputStream send ;
            BufferedReader receive;
            InputStream inputStream  ;
            Socket dce ;
    public ProductBought(String value,String localhost) {
        initComponents();
        this.value = value;
        this.localhost = localhost;
        try {
            clientSocket = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server  
            sendToServer = new DataOutputStream(clientSocket.getOutputStream());// Tao output stream ket noi toi socket
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(RechargeUser.class.getName()).log(Level.SEVERE, null, ex);
        }    

        
                try {
                    dce = new Socket(localhost, 6969);// Tao clinent socket de ket noi toi server    
                    send = new DataOutputStream(dce.getOutputStream()); // Tao output stream ket noi toi socket
                    inputStream = dce.getInputStream();
                    receive = new BufferedReader(new InputStreamReader(dce.getInputStream()));
                    } catch (IOException ex) {
                    Logger.getLogger(RechargeUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
        try {
            send.writeBytes(value+"\n");
        
                    byte[] sizeAr = new byte[4];
                    inputStream.read(sizeAr);
                    
                    int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                    byte[] imageAr = new byte[size];
                    
                    inputStream.read(imageAr);

                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
                    icon= new ImageIcon(image.getScaledInstance(jPanel1.getWidth(),jPanel1.getHeight(), image.SCALE_SMOOTH)); 
                    jLabelAvatar.setIcon(icon);
                    

                    dce.close();
         } catch (IOException ex) {
            Logger.getLogger(ProductBought.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    ImageIcon icon;


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAvatar = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelAuctioner = new javax.swing.JLabel();
        jLabelPrice = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        jLabelName.setText("Name:");

        jLabelAuctioner.setText("seller:");

        jLabelPrice.setText("Price:");

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelInfo.setText("text");

        jLabel1.setText("Infomation:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jLabelAuctioner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 13, Short.MAX_VALUE))
                            .addComponent(jLabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAuctioner, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
            
        try {            
            sendToServer.writeBytes("select##productBought\n");// gui toi server
            String ketQua;//Cau duoc server xu ly va tra lai la in hoa
            while (true) {

                ketQua = inFromServer.readLine();// Nhan lai tu server
                if (ketQua.equals("quit")) {
                    break;
                }
                String[] ss = ketQua.split("##");
                if(value.equals(ss[0])){
                    jLabelName.setText("Name: "+ss[2]);
                    jLabelPrice.setText("Price: "+ss[4]);
                    
                    
                    
                    jLabelAuctioner.setText("Seller: "+ss[6]);
                    String text = "<html>";
                    for(int i = 0; i<ss[3].length();i++){
                        if(i == 60 || i == 120 || i == 180 || i == 240){
                            while(ss[3].charAt(i) != ' '){
                                text += ss[3].charAt(i);
                                i++;
                            }
                            if(ss[3].charAt(i) == ' '){
                                text += "<br>";
                            }
                        }else
                        text += ss[3].charAt(i);
                    }
                    text+="</html>";
                    jLabelInfo.setText(text);
                    break;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ProductBought.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAuctioner;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}