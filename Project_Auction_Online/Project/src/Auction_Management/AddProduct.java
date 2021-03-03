/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auction_Management;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author asus
 */
public class AddProduct extends javax.swing.JFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    
     DefaultTableModel model;
     String localhost;
//     Socket clientSocket;
     String username;
//     DataOutputStream sendToServer;
    public AddProduct(String username, Socket clientSocket,String localhost) {
       initComponents();
       this.localhost = localhost;
        st(jTable1, jTextFieldSearch);
        
         
        this.username = username;
        new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                    Socket clientSocket = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server   
                    DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());// Tao output stream ket noi toi socket
                    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                String s = "SELECT##product";
                ArrayList<String> arr;
                while(true){
                try {
                    Thread.sleep(1000);
                    String ketQua;//Cau duoc server xu ly va tra lai la in hoa
                    
                    sendToServer.writeBytes(s+'\n');// gui toi server
                    boolean checkAdd = true;
                    boolean checkExist = true;
                    arr = new ArrayList<String>();
                    while (true) {
                        
                        ketQua = inFromServer.readLine();// Nhan lai tu server
                        if (ketQua.equals("quit")) {
                            break;
                        }
                        String[] ss = ketQua.split("##");
                        arr.add(ss[0]);
                        if(username.equals(ss[6])){
                            for(int i = 0; i<model.getRowCount();i++){
                                if(ss[0].equals(model.getValueAt(i, 0))){
                                    

                                        model.setValueAt(ss[9], i, 3);

                                    
                                        model.setValueAt(ss[10], i, 5);
                                    
                                    
                                    
                                    checkAdd = false;
                                    break;
                                }
                            }
                            if(checkAdd){
                                model.addRow(new String[]{ss[0],ss[2],ss[4],ss[11],ss[7],ss[10]});
                            }else{
                                checkAdd = true;
                            }
                            
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
                    //            clientSocket.close();//Dong ket noi
                } catch (IOException e) {
                    System.out.println("Exception Client: " + e.getMessage());
                } catch (InterruptedException ex) {
                   Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
               }
           }} catch (IOException ex) {
                    Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
                }}
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Audition Price", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("ADD PRODUCT");

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

        jLabel1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(254, 254, 254))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonDelete)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel)))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDelete)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
AuctionUser auc;
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if(auc == null || !auc.isVisible()){
            auc = new AuctionUser(username, localhost);
            auc.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    public void st(JTable searchTable, JTextField searchText){
    
        
        
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
    
    
    
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable1.getModel();
        int r = jTable1.getSelectedRow();
        if (r < 0) {
            JOptionPane.showMessageDialog(this, "please select a record");
        } else {
            
           
        try {
            String ketQua;//Cau duoc server xu ly va tra lai la in hoa
            Socket clientSocket = new Socket(localhost, 9999);// Tao clinent socket de ket noi toi server   
                    DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());// Tao output stream ket noi toi socket
            
            
            sendToServer.writeBytes("DELETE##product##"+model.getValueAt(r, 0)+'\n');// gui toi server
            
                model.removeRow(r);
                
                JOptionPane.showMessageDialog(this, "Successfull");
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
