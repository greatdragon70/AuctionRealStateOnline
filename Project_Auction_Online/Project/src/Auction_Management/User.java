/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auction_Management;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.Socket;
import javax.swing.ImageIcon;
import Login.*;
import info_Product.Product;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author icydeath
 */
public class User extends javax.swing.JFrame {
    String username;
    Socket clientSocket;
    DataOutputStream sendToServer;
    String localhost;
    /**
     * Creates new form User
     */
    public String getUsername() {
        return username;
    }

    
    BufferedReader inFromServer;
    String string;
    public User(String username, Socket clientSocket, String string,String localhost) {
        initComponents();
        this.string = string;
        this.username = username;
        this. localhost = localhost;
        this.clientSocket = clientSocket;
        st(jTable2, jTextFieldSearch);
        try {
            sendToServer = new DataOutputStream(clientSocket.getOutputStream()); // Tao output stream ket noi toi socket
            
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sendToServer.writeBytes("select##UserManagement\n");// gui toi server
            
            while (true) {

                        String ketQua = inFromServer.readLine();// Nhan lai tu server
                        if (ketQua.equals("quit")) {
                            break;
                        }
                        String[] ss = ketQua.split("##");
                        if(this.username.equals(ss[0])){
                            jLabelName.setText("Name: "+ss[8]);
                            jLabelMoney.setText("Money: "+ss[2]+"$");
                            jLabelRank.setText("Rank: "+ss[3]);
                            
                            jLabelPoint.setText("Points: "+ss[5]);
                            break;
                        }
                    }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                
                try {
                    Socket abc = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server    
                    DataOutputStream send = new DataOutputStream(abc.getOutputStream()); // Tao output stream ket noi toi socket
            
                    BufferedReader receive = new BufferedReader(new InputStreamReader(abc.getInputStream()));
                } catch (IOException ex) {
                    Logger.getLogger(RechargeUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                while (true) {
                        
                        Thread.sleep(1000);
                        sendToServer.writeBytes("select##person\n");
                        while(true){
                            String ketQua = inFromServer.readLine();// Nhan lai tu server
                            if (ketQua.equals("quit")) {
                                break;
                            }
                            String[] ss = ketQua.split("##");
                            
                            if(getUsername().equals(ss[5])){
                                
                                if(ss[8].equals("offline")){
                                    
                                    JOptionPane.showMessageDialog(jDesktopPane1, "Account is signing in at another device");
                                    System.exit(0);
                                }

                            }
                        }
                        
                    }
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelMoney = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelAvatar = new javax.swing.JLabel();
        jLabelPoint = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jButtonEdit = new javax.swing.JButton();
        jButtonChangePoint = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonAvatar = new javax.swing.JButton();
        jButtonRecharge = new javax.swing.JButton();
        jButtonBuy = new javax.swing.JButton();
        jSeparator = new javax.swing.JSeparator();
        jButtonAuction = new javax.swing.JButton();
        jLabelRank = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelMoney.setText("Money:");

        jButtonLogout.setText("Exit");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelAvatar.setText("          ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        jLabelPoint.setText("Point:");

        jLabelName.setText("Name:");

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonChangePoint.setText("Change point");
        jButtonChangePoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangePointActionPerformed(evt);
            }
        });

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Price", "Auction price", "Auctioneer", "Time", "seller"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Search");

        jButtonAvatar.setText("Avatar");
        jButtonAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvatarActionPerformed(evt);
            }
        });

        jButtonRecharge.setText("Recharge");
        jButtonRecharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechargeActionPerformed(evt);
            }
        });

        jButtonBuy.setText("History");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });

        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButtonAuction.setText("Auction");
        jButtonAuction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAuctionActionPerformed(evt);
            }
        });

        jLabelRank.setText("Rank:");

        jDesktopPane1.setLayer(jLabelMoney, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonLogout, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelPoint, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonEdit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonChangePoint, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonRefresh, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonAvatar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonRecharge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonBuy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonAuction, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelRank, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jButtonAvatar)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPoint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelRank, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonRecharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonChangePoint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jButtonBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jButtonRefresh)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)))
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAuction)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAvatar)
                    .addComponent(jButtonEdit))
                .addGap(12, 12, 12)
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabelMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelRank, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButtonRecharge)
                        .addGap(58, 58, 58)
                        .addComponent(jButtonChangePoint)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRefresh)
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogout)
                    .addComponent(jButtonBuy))
                .addGap(46, 46, 46))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAuction)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
        
        ImageIcon icon;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
            try {
                    Socket dce = new Socket(localhost, 6969);// Tao clinent socket de ket noi toi server    
                    DataOutputStream send = new DataOutputStream(dce.getOutputStream()); // Tao output stream ket noi toi socket
            
                    BufferedReader receive = new BufferedReader(new InputStreamReader(dce.getInputStream()));
                    InputStream inputStream = dce.getInputStream();
                    send.writeBytes(username+"\n");
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
                    Logger.getLogger(RechargeUser.class.getName()).log(Level.SEVERE, null, ex);
                }
        

        
        
       

        
        
        new Thread(new Runnable() {
           
            @Override
            public void run() {
                try {
                    Socket bcd = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server    
                    DataOutputStream send = new DataOutputStream(bcd.getOutputStream()); // Tao output stream ket noi toi socket
            
                    BufferedReader receive = new BufferedReader(new InputStreamReader(bcd.getInputStream()));
                
                ArrayList<String> arr;
                while(true){
                    
                try {
                    
                    Thread.sleep(1000);
                    DefaultTableModel model = new DefaultTableModel();
                    model = (DefaultTableModel) jTable2.getModel();
                    arr = new ArrayList<>();
                    String s = "SELECT##product";
                    try {
                        String ketQua;//Cau duoc server xu ly va tra lai la in hoa
                        boolean checkExist = true;
                        send.writeBytes(s+'\n');// gui toi server
                        while (true) {
                            boolean checkDuplicated = true;
                            ketQua = receive.readLine();// Nhan lai tu server
                            if (ketQua.equals("quit")) {
                                break;
                            }
                            String[] ss = ketQua.split("##");
                            arr.add(ss[0]);
                            for(int i = 0 ; i<model.getRowCount();i++){
                                if(ss[0].equals(model.getValueAt(i, 0))){
                                        model.setValueAt(ss[5], i, 4);

                                        model.setValueAt(ss[9], i, 3);

                                    
                                        model.setValueAt(ss[10], i, 5);
                                    
                                    checkDuplicated = false;
                                    break;
                                }
                            }
                            if(checkDuplicated){
                                model.addRow(new Object[]{ss[0],ss[2],ss[4],ss[9],ss[5],ss[10],ss[6]});
                            }else{
                                checkDuplicated = true;
                            }  
                        }
                        for(int i = 0;i<model.getRowCount();i++){
                            for(int j = 0 ; j<arr.size();j++){
                                if(model.getValueAt(i, 0).equals(arr.get(j))){
                                    checkExist = false;
                                    break;
                                }
                            }if(checkExist){
                                model.removeRow(i);
                            }else{
                                checkExist = true;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Exception Client: " + e.getMessage());
                    }
                } catch (Exception ex) {
                    
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }} catch (IOException ex) {
                    Logger.getLogger(RechargeUser.class.getName()).log(Level.SEVERE, null, ex);
                }}
        }).start();
    
    
    
    }//GEN-LAST:event_formWindowOpened
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if(!clientSocket.isConnected()){
            try {
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonLogoutActionPerformed
EditUser edit;
    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if(!clientSocket.isConnected()){

            JOptionPane.showMessageDialog(this, "Can not connect with server");
            System.exit(0);
        }else{
            
             try {
                  
                 
                     Socket ac = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server
                     DataOutputStream sendToServer = new DataOutputStream(ac.getOutputStream());// Tao output stream ket noi toi socket
                     BufferedReader inFromServer = new BufferedReader(new InputStreamReader(ac.getInputStream()));
                 
                 String ketQua;//Cau duoc server xu ly va tra lai la in hoa
                 
                 sendToServer.writeBytes("select##person\n");// gui toi server
                 while (true) {
                     
                     ketQua = inFromServer.readLine();// Nhan lai tu server
                     if (ketQua.equals("quit")) {
                         break;
                     }
                     String[] ss = ketQua.split("##");
                     if(username.equals(ss[5])){
                         string = ketQua;
                         break;
                     }
                     
                 }
                 ac.close();
                 } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                 if(edit == null || edit.isClosed()){
                     
                     String[] s = jLabelName.getText().split(":");
                     edit = new EditUser(clientSocket, username,string,s[1].trim());
                     edit.addInternalFrameListener(new InternalFrameListener() {
                         @Override
                         public void internalFrameOpened(InternalFrameEvent ife) {
                             
                         }
                         
                         @Override
                         public void internalFrameClosing(InternalFrameEvent ife) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                         }
                         
                         @Override
                         public void internalFrameClosed(InternalFrameEvent ife) {
                             String[] s = jLabelName.getText().split(":");
                             if(!s[1].trim().equals(edit.getjTextFieldName())){
                                 jLabelName.setText("Name: "+edit.getjTextFieldName());
                             }
                         }
                         
                         @Override
                         public void internalFrameIconified(InternalFrameEvent ife) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                         }
                         
                         @Override
                         public void internalFrameDeiconified(InternalFrameEvent ife) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                         }
                         
                         @Override
                         public void internalFrameActivated(InternalFrameEvent ife) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                         }
                         
                         @Override
                         public void internalFrameDeactivated(InternalFrameEvent ife) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                         }
                     });
                     jDesktopPane1.add(edit);
                     edit.setLocation(this.getWidth()/2 - edit.getWidth()/2, this.getHeight()/2 - edit.getHeight()/2);
                     edit.setVisible(true);
                 }
                 
                 
             
            

        }
    
    }//GEN-LAST:event_jButtonEditActionPerformed
ChangePoint changepoint ;
    private void jButtonChangePointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangePointActionPerformed
        // TODO add your handling code here:
        
        if(changepoint == null || changepoint.isClosed()){
            changepoint = new ChangePoint(clientSocket, username, localhost);
            changepoint.addInternalFrameListener(new InternalFrameListener() {
                @Override
                public void internalFrameOpened(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameClosed(InternalFrameEvent ife) {
                    
                    String money = "";
                    String[] ss = jLabelMoney.getText().split(":");
                    
                    for(int i = 0 ; i < ss[1].length() ; i++){
                        if(ss[1].charAt(i) != '$'){
                            money += ss[1].charAt(i);
                        }
                    }
                    int total1 = Integer.parseInt(money.trim()) + changepoint.getMoney();
                    jLabelMoney.setText("Money: "+total1+"$");
                    String[] s = jLabelPoint.getText().split(":");
                    int point = Integer.parseInt(s[1].trim());
                    int total = point - changepoint.getMoney()*10;
                    jLabelPoint.setText("Points: "+total);
                    
                    
                    
                }

                @Override
                public void internalFrameIconified(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameDeiconified(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameActivated(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameDeactivated(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            jDesktopPane1.add(changepoint);
            changepoint.setLocation(this.getWidth()/2 - changepoint.getWidth()/2, this.getHeight()/2 - changepoint.getHeight()/2);
            changepoint.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jButtonChangePointActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        try {
            Socket bc = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server
            DataOutputStream sendToServer = new DataOutputStream(bc.getOutputStream()); // Tao output stream ket noi toi socket
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(bc.getInputStream()));
            sendToServer.writeBytes("select##UserManagement\n");// gui toi server
            
            while (true) {

                        String ketQua = inFromServer.readLine();// Nhan lai tu server
                        if (ketQua.equals("quit")) {
                            break;
                        }
                        String[] ss = ketQua.split("##");
                        if(this.username.equals(ss[0])){
                            jLabelName.setText("Name: "+ss[8]);
                            jLabelMoney.setText("Money: "+ss[2]+"$");
                            jLabelRank.setText("Rank: "+ss[3]);
                            
                            jLabelPoint.setText("Points: "+ss[5]);
                            break;
                        }
                    }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefreshActionPerformed
AvatarUser avatar;
    private void jButtonAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvatarActionPerformed
        // TODO add your handling code here:
        if(avatar == null || avatar.isClosed()){
            avatar = new AvatarUser(clientSocket, username);
            avatar.addInternalFrameListener(new InternalFrameListener() {
                @Override
                public void internalFrameOpened(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameClosed(InternalFrameEvent ife) {
                    if(avatar.isCheck()){
                        ImageIcon icon = new ImageIcon(avatar.getImage().getScaledInstance(jPanel1.getWidth(),jPanel1.getHeight(), avatar.getImage().SCALE_SMOOTH));
                        jLabelAvatar.setIcon(icon);
                                try {
                                    Socket dce = new Socket(localhost, 9696);// Tao clinent socket de ket noi toi server    
                                    DataOutputStream send = new DataOutputStream(dce.getOutputStream()); // Tao output stream ket noi toi socket

                                    BufferedReader receive = new BufferedReader(new InputStreamReader(dce.getInputStream()));
                                    OutputStream outputStream = dce.getOutputStream();
                                    send.writeBytes(username+"\n");
                                    BufferedImage image = ImageIO.read(new File(avatar.getjLabelLinkImage()));

                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    ImageIO.write(image, "jpg", byteArrayOutputStream);

                                    byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
                                    
                                    outputStream.write(size);
                                    
                                    outputStream.write(byteArrayOutputStream.toByteArray());
                                    outputStream.flush();


                                    dce.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(RechargeUser.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                    }
                }

                @Override
                public void internalFrameIconified(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameDeiconified(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameActivated(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameDeactivated(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            jDesktopPane1.add(avatar);
            avatar.setLocation(this.getWidth()/2 - avatar.getWidth()/2, this.getHeight()/2 - avatar.getHeight()/2);
            avatar.setVisible(true);
        }
        
        
        
    }//GEN-LAST:event_jButtonAvatarActionPerformed
RechargeUser recharge;
    private void jButtonRechargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRechargeActionPerformed
        // TODO add your handling code here:
        if(recharge  == null || recharge.isClosed()){
            recharge = new RechargeUser(username, clientSocket, localhost);
            recharge.addInternalFrameListener(new InternalFrameListener() {
                @Override
                public void internalFrameOpened(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameClosed(InternalFrameEvent ife) {
                    String[] s = jLabelMoney.getText().split(":");
                    String money = "";
                    for(int i = 0 ; i < s[1].length() ; i++){
                        if(s[1].charAt(i) != '$'){
                            money += s[1].charAt(i);
                        }
                    }
                    
                    int total = Integer.parseInt(money.trim()) + recharge.getMoney();
                    jLabelMoney.setText("Money: "+total+"$");
                    
                }

                @Override
                public void internalFrameIconified(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameDeiconified(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameActivated(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void internalFrameDeactivated(InternalFrameEvent ife) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            jDesktopPane1.add(recharge);
            recharge.setLocation(this.getWidth()/2 - recharge.getWidth()/2, this.getHeight()/2 - recharge.getHeight()/2);
            recharge.setVisible(true);
        }     
    }//GEN-LAST:event_jButtonRechargeActionPerformed
History history;
    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        // TODO add your handling code here:
        if(!clientSocket.isConnected()){
            
            JOptionPane.showMessageDialog(this, "Can not connect with server");
            System.exit(0);

        }else{
            if(history == null || !history.isVisible()){
                history = new History(clientSocket,username, localhost);
                history.setVisible(true);
            }
            
            
        }
    }//GEN-LAST:event_jButtonBuyActionPerformed
AddProduct add;
    private void jButtonAuctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAuctionActionPerformed
        // TODO add your handling code here:
        
        if(add == null || !add.isVisible()){
            add = new AddProduct(username, clientSocket, localhost);
            add.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAuctionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            sendToServer.writeBytes("update##statement##person##"+username+"##offline\n");
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing
    Product pro;
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:        
        if(evt.getClickCount() == 2){
            if(pro == null || !pro.isVisible()){                 
                pro = new Product(username, jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString(),localhost);
                pro.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked
    
public static void st(JTable searchTable, JTextField searchText){
        
        
        TableRowSorter<TableModel> Sorter = new TableRowSorter<>(searchTable.getModel());
        searchTable.setRowSorter(Sorter);
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchText.getText();
                if(text.length()==0){
                    Sorter.setRowFilter(null);
                } else {
                    Sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchText.getText();

                if (text.length() == 0) {
                    Sorter.setRowFilter(null);
                } else {
                    Sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAuction;
    private javax.swing.JButton jButtonAvatar;
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonChangePoint;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonRecharge;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelMoney;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPoint;
    private javax.swing.JLabel jLabelRank;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
