package Login;

import Auction_Management.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author icydeath
 */
public class Login extends javax.swing.JFrame {
    BufferedReader inFormUser;
    Socket clientSocket;
    String username;

    
    String localhost = "192.168.179.47";
    
    
//    File file = new File(System.getProperty("user.home")+"save.txt");
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        connectServer();
        this.localhost = localhost;
//        UPDATE();
//        jButtonLogin.addMouseListener(new MouseAdapter(){
//           public void mouseReleased(MouseEvent m){
//
//               if(jCheckBoxRemember.isSelected()){
//                  SAVE(); //Save This UserName and his PassWord     
//               }
//
//           }//end of mouseReleased
//       });
    }
    public boolean check1 = false;
    public void connectServer(){
        try {
            inFormUser = new BufferedReader(new InputStreamReader(System.in));// Tao input stream
            clientSocket = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server     
            System.out.println(clientSocket);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Can not connect with server");
//            LoginAgain login = new LoginAgain();
//            login.setVisible(true);
//            if(check1){
//                System.out.println("true");
//                connectServer();
//                
//            }else{
//                System.out.println("false");
//            }
            
            
        }
    }
    
    
//    public void SAVE(){      //Save the UserName and Password (for one user)
//
//
//
//        try {
//            if(!file.exists()) file.createNewFile();  //if the file !exist create a new one
//
//            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
//            bw.write(jTextFieldUsername.getText()); //write the name
//            bw.newLine(); //leave a new Line
//            bw.write(jPasswordFieldPassword.getPassword()); //write the password
//            bw.close(); //close the BufferdWriter
//
//        } catch (IOException e) { e.printStackTrace(); }        
//
// }//End Of Save
//
//
//
//
//  public void UPDATE(){ //UPDATE ON OPENING THE APPLICATION
//
//        try {
//          if(file.exists()){    //if this file exists
//
//            Scanner scan = new Scanner(file);   //Use Scanner to read the File
//
//            jTextFieldUsername.setText(scan.nextLine());  //append the text to name field
//            jPasswordFieldPassword.setText(scan.nextLine()); //append the text to password field
//            scan.close();
//          }
//
//        } catch (FileNotFoundException e) {         
//            e.printStackTrace();
//        }                
//
//   }//End OF UPDATE


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButtonCancel = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jCheckBoxRemember = new javax.swing.JCheckBox();
        jTextFieldUsername = new javax.swing.JTextField();
        jCheckBoxShowPassword = new javax.swing.JCheckBox();
        jButtonForget = new javax.swing.JButton();
        jLabelAvatar = new javax.swing.JLabel(){
            ImageIcon icon = new ImageIcon("src/images/user.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jButtonRegister = new javax.swing.JButton();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabelTitle = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jCheckBoxRemember.setText("Remember login");

        jCheckBoxShowPassword.setText("Show password");
        jCheckBoxShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowPasswordActionPerformed(evt);
            }
        });

        jButtonForget.setText("Forget password");
        jButtonForget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForgetActionPerformed(evt);
            }
        });

        jLabelAvatar.setBorder(new javax.swing.border.MatteBorder(null));

        jButtonRegister.setText("Register account");
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        jLabelPassword.setText("password");

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTitle.setText("LOGIN AUCTION");

        jLabelUsername.setText("username");

        jDesktopPane1.setLayer(jButtonCancel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCheckBoxRemember, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCheckBoxShowPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonForget, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelAvatar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonRegister, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPasswordFieldPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap(107, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jButtonLogin)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))))
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButtonForget, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRegister))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsername)
                            .addComponent(jLabelPassword)
                            .addComponent(jCheckBoxRemember))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jCheckBoxShowPassword)))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelUsername))
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelPassword))
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxRemember)
                    .addComponent(jCheckBoxShowPassword))
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegister)
                    .addComponent(jButtonForget))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonLogin))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:

        
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:

        if(!clientSocket.isConnected()){
            JOptionPane.showMessageDialog(this, "Can not connect with server");

            connectServer();
        }else{
            LoginForm login = new LoginForm();
            DataOutputStream sendToServer = null;
            boolean checkDuplicated = false;
            try {
                sendToServer = new DataOutputStream(clientSocket.getOutputStream()); // Tao output stream ket noi toi socket
                sendToServer.writeBytes("select##person\n");// gui toi server
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while (true) {

                    String ketQua = inFromServer.readLine();// Nhan lai tu server
                    if (ketQua.equals("quit")) {
                        break;
                    }
                    String[] s = ketQua.split("##");
                    if(login.loginAction(jPasswordFieldPassword.getText(), jTextFieldUsername.getText(), s)){
                        if(s[8].equals("online")){
                            sendToServer.writeBytes("update##statement##person##"+jTextFieldUsername.getText().trim()+"##offline\n");// gui toi server
                            JOptionPane.showMessageDialog(this, "Account is signing in at another device");
                            System.exit(0);
                        }else{
                            sendToServer.writeBytes("update##statement##person##"+jTextFieldUsername.getText().trim()+"##online\n");// gui toi server
                            checkDuplicated = true;

                            //                        JOptionPane.showMessageDialog(null,"Login successful");
                            username = jTextFieldUsername.getText();
                            User user = new User(username,clientSocket,ketQua, localhost);
                            user.setVisible(true);
                            this.setVisible(false);
                            break;
                        }
                        
                    }

                }
                
            } catch (IOException ex) {
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(checkDuplicated == false){
                JOptionPane.showMessageDialog(null,"Invalid username or wrong password");
            }
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jCheckBoxShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxShowPasswordActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxShowPassword.isSelected()){
            jPasswordFieldPassword.setEchoChar((char)0);
        }else{
            jPasswordFieldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxShowPasswordActionPerformed
ForgetPassword forgetPassword;
    private void jButtonForgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForgetActionPerformed
        // TODO add your handling code here:
        if(forgetPassword == null){
            forgetPassword = new ForgetPassword(clientSocket, username, localhost);
            forgetPassword.setVisible(true);
        }else if(!forgetPassword.isVisible()){
            forgetPassword.setVisible(true);
        }
    }//GEN-LAST:event_jButtonForgetActionPerformed
RegisterUser register;
    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        // TODO add your handling code here:

        if(register == null ){
            register = new RegisterUser(clientSocket, localhost);
            register.setVisible(true);
        }else if(!register.isVisible()){
            register.setVisible(true);
        }
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonForget;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JCheckBox jCheckBoxRemember;
    private javax.swing.JCheckBox jCheckBoxShowPassword;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}