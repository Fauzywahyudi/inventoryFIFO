/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nanda
 */
public class Pelanggan extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private DefaultTableModel dtm;
    private String sql;

    /**
     * Creates new form costumer
     */
    public Pelanggan() throws SQLException {
        initComponents();

        Koneksi koneksi = new Koneksi();
        con = koneksi.getKoneksi();
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        bersih();
        cibuak();
        
    }
    
    private int getKode() throws SQLException {
        sql = "select * from pelanggan ORDER BY kd_pel DESC";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        int lastKode = 0;
        int newKode = 0;
        if(rs.next()){
            lastKode = Integer.parseInt(rs.getString("kd_pel"));
            newKode = lastKode+1;
        }else{
            newKode = 1;
        }
        return newKode;
    }

    private void bersih() throws SQLException {
//        throw new UnsupportedOperationException("Not yet implemented");
        txKodePelanggan.setText(String.valueOf(getKode()));
        txNamaPelanggan.setText("");
        txNohp.setText("");
        txAlamat.setText("");
        txKodePelanggan.setEditable(false);
        txKodePelanggan.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();
        txKodePelanggan = new javax.swing.JTextField();
        txNamaPelanggan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txAlamat = new javax.swing.JTextArea();
        txNohp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel4.setText("INPUT DATA PELANGGAN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 470, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 110, 50));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 110, 50));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 130, 50));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, 120, 50));

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelPelanggan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 620, 210));

        txKodePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKodePelangganActionPerformed(evt);
            }
        });
        jPanel1.add(txKodePelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 170, 30));

        txNamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNamaPelangganActionPerformed(evt);
            }
        });
        jPanel1.add(txNamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 170, 30));

        txAlamat.setColumns(20);
        txAlamat.setRows(5);
        jScrollPane1.setViewportView(txAlamat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 170, 60));
        jPanel1.add(txNohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 170, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Kode Pelanggan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText(" Nama Pelanggan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 170, 140, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Alamat");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("No. HP");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 70, 20));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoNew.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 560));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoNew.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            sql = "insert into pelanggan values('" + txKodePelanggan.getText()
                    + "','" + txNamaPelanggan.getText()
                    + "','" + txAlamat.getText()
                    + "','" + txNohp.getText()
                    + "')";
            st = con.createStatement();
            st.executeUpdate(sql);
            bersih();
            cibuak();

            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GAGAL TERSIMPAN" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Menu().setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if (txKodePelanggan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu data pada tabel");
            } else {
                sql = "update pelanggan set nm_pel='" + txNamaPelanggan.getText()
                        + "',alamat='" + txAlamat.getText()
                        + "',no_hp='" + txNohp.getText()
                        + "' where kd_pel='" + txKodePelanggan.getText() + "'";
                st = con.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Di EDIT");
                bersih();
                cibuak();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txKodePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKodePelangganActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:pklpelet", "", "");
            st = con.createStatement();
            String sql = "select * from costumer where kd_costumer like '" + txKodePelanggan.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                txKodePelanggan.setText(rs.getString(1));
                txNamaPelanggan.setText(rs.getString(2));
                txAlamat.setText(rs.getString(3));
                txNohp.setText(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada data");

            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_txKodePelangganActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            if (txKodePelanggan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu data pada tabel");
            } else {
                sql = "DELETE from pelanggan where kd_pel='" + txKodePelanggan.getText() + "'";
                st = con.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Telah Dihapus!!");
                bersih();
                cibuak();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNamaPelangganActionPerformed

    private void tabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPelangganMouseClicked
        txKodePelanggan.setText(dtm.getValueAt(tabelPelanggan.getSelectedRow(), 0) + "");
        txNamaPelanggan.setText(dtm.getValueAt(tabelPelanggan.getSelectedRow(), 1) + "");
        txAlamat.setText(dtm.getValueAt(tabelPelanggan.getSelectedRow(), 2) + "");
        txNohp.setText(dtm.getValueAt(tabelPelanggan.getSelectedRow(), 3) + "");
        txKodePelanggan.setEditable(false);
    }//GEN-LAST:event_tabelPelangganMouseClicked

    private void cibuak() {
        try {
            Object[] rows = {"KODE", " NAMA", "ALAMAT", "NO HP"};
            dtm = new DefaultTableModel(null, rows);
            tabelPelanggan.setModel(dtm);
            tabelPelanggan.setBorder(null);
            jScrollPane3.setVisible(true);
            jScrollPane3.setViewportView(tabelPelanggan);
            String kd_costumer = "", nm_costumer = "", alamat = "", tlp = "";
            try {
                sql = "select * from pelanggan ORDER BY kd_pel ASC";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    kd_costumer = rs.getString("kd_pel");
                    nm_costumer = rs.getString("nm_pel");
                    alamat = rs.getString("alamat");
                    tlp = rs.getString("no_hp");
                    String[] tampil = {kd_costumer, nm_costumer, alamat, tlp};
                    dtm.addRow(tampil);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Salah" + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pelanggan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JTextArea txAlamat;
    private javax.swing.JTextField txKodePelanggan;
    private javax.swing.JTextField txNamaPelanggan;
    private javax.swing.JTextField txNohp;
    // End of variables declaration//GEN-END:variables
}
