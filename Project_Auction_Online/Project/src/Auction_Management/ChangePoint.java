/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auction_Management;

import Login.*;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author icydeath
 */
public class ChangePoint extends javax.swing.JInternalFrame {
    String s = "update##UserManagement##";
    /**
     * Creates new form ChangePoint
     */
    String localhost;
    Socket clientSocket; String username;
    ChangingPoint cp = new ChangingPoint();
    public ChangePoint(Socket clientSocket, String username,String localhost) {
        initComponents();
        this.localhost = localhost;
        this.username = username;
        
    }
    int money22;

    public int getMoney() {
        return money22;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton10Points = new javax.swing.JRadioButton();
        jRadioButton50Points = new javax.swing.JRadioButton();
        jRadioButton100Points = new javax.swing.JRadioButton();
        jRadioButton200Points = new javax.swing.JRadioButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("10 points = 1$   ");

        jLabel2.setText("*Note:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Changing Point");

        buttonGroup1.add(jRadioButton10Points);
        jRadioButton10Points.setText("1$");

        buttonGroup1.add(jRadioButton50Points);
        jRadioButton50Points.setText("5$");

        buttonGroup1.add(jRadioButton100Points);
        jRadioButton100Points.setText("10$");

        buttonGroup1.add(jRadioButton200Points);
        jRadioButton200Points.setText("20$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioButton200Points)
                                    .addComponent(jRadioButton50Points)))
                            .addComponent(jRadioButton100Points)
                            .addComponent(jRadioButton10Points)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel3)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton10Points)
                    .addComponent(jRadioButton50Points))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton100Points)
                    .addComponent(jRadioButton200Points))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowClosed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        
            int money = 0;
            if(jRadioButton10Points.isSelected()){
                money = 1;
            }else if(jRadioButton50Points.isSelected()){
                money = 5;
            }else if(jRadioButton100Points.isSelected()){
                money = 10;
            }else if(jRadioButton200Points.isSelected()){
                money = 20;
            }
            money22 = money;
            try {
                this.clientSocket = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server    
                DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream()); // Tao output stream ket noi toi socket

                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                sendToServer.writeBytes("select##UserManagement\n");// gui toi server
                while (true) {

                    String ketQua = inFromServer.readLine();// Nhan lai tu server
                    
                    if (ketQua.equals("quit")) {
                        break;
                    }
                    String[] ss = ketQua.split("##");
                    if(this.username.equals(ss[0])){
                        int point = Integer.parseInt(ss[5]);
                        int dola = Integer.parseInt(ss[2]);
                        if(money != 0){
                            if(cp.checkPoint(money, point)){
                                point -= money*10;
                                dola += money;

                                s = s + ss[0] + "##" + ss[1] + "##" + dola + "##" + ss[3] + "##" + ss[4] + "##" + point + "##" + ss[6] + "##" + ss[7];
                                sendToServer.writeBytes(s+'\n');                                
                                JOptionPane.showMessageDialog(this, "Successfull");
                                this.dispose();
                                clientSocket.close();
                                break;

                            }
                            else JOptionPane.showMessageDialog(this, "You don't have enough point");
                        }
                        break;
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButtonOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton100Points;
    private javax.swing.JRadioButton jRadioButton10Points;
    private javax.swing.JRadioButton jRadioButton200Points;
    private javax.swing.JRadioButton jRadioButton50Points;
    // End of variables declaration//GEN-END:variables
}