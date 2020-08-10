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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Barang extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private DefaultTableModel defaultTableModel;
    private String sql;

    /**
     * Creates new form barang
     */
    public Barang() throws SQLException {
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

//    private int getKode() throws SQLException {
//        sql = "select * from barang ORDER BY kd_barang DESC";
//        st = con.createStatement();
//        rs = st.executeQuery(sql);
//        int lastKode = 0;
//        int newKode = 0;
//        if(rs.next()){
//            lastKode = Integer.parseInt(rs.getString("kd_barang"));
//            newKode = lastKode+1;
//        }else{
//            newKode = 1;
//        }
//        return newKode;
//    }
    
    private void getKode() throws SQLException {
        sql = "select * from barang ORDER BY kd_barang DESC LIMIT 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            String kd = rs.getString("kd_barang").substring(1);
            int no = Integer.parseInt(kd) + 1;
            String No1 = "";
            if (no < 10) {
                No1 = "00000";
            } else if (no < 100) {
                No1 = "0000";
            } else if (no < 1000) {
                No1 = "000";
            } else if (no < 10000) {
                No1 = "00";
            } else if (no < 100000) {
                No1 = "0";
            } else {
                No1 = "";
            }

            txKodeBarang.setText("B"+No1 + no);
        } else {
            txKodeBarang.setText("B000001");
        }
    }

    private void bersih() throws SQLException {
//        throw new UnsupportedOperationException("Not yet implemented");
        
        txNamaBarang.setText("");
        txHargaJual.setText("");
        txHargaBeli.setText("");
        txStock.setText("");
        cbSatuan.setSelectedIndex(0);
        txExpired.setDate(null);
        txTglBeli.setDate(null);
        txKodeBarang.setEditable(false);
        getKode();
        
    }

    private void cibuak() {
        try {
            Object[] rows = {"KODE BARANG", " NAMA BARANG", "SATUAN", "HARGA BELI", "HARGA JUAL", "STOK", "EXPIRED", "TANGGAL BELI"};
            defaultTableModel = new DefaultTableModel(null, rows);
            tabelBarang.setModel(defaultTableModel);
            tabelBarang.setBorder(null);
            jScrollPane2.setVisible(true);
            jScrollPane2.setViewportView(tabelBarang);
            String col1, col2, col3, col4, col5, col6, col7, col8;
            try {
                sql = "select * from barang ORDER BY kd_barang ASC";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    col1 = rs.getString("kd_barang");
                    col2 = rs.getString("nm_barang");
                    col3 = rs.getString("satuan");
                    col8 = rs.getString("harga_beli");
                    col4 = rs.getString("harga_jual");
                    col5 = rs.getString("stock");
                    col6 = rs.getString("expired");
                    col7 = rs.getString("tgl_beli");
                    String[] tampil = {col1, col2, col3, col8, col4, col5, col6, col7};
                    defaultTableModel.addRow(tampil);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Salah" + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txNamaBarang = new javax.swing.JTextField();
        cbSatuan = new javax.swing.JComboBox();
        txStock = new javax.swing.JTextField();
        txHargaJual = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txTglBeli = new com.toedter.calendar.JDateChooser();
        txExpired = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txHargaBeli = new javax.swing.JTextField();
        btnDelete1 = new javax.swing.JButton();
        txKodeBarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(51, 51, 51));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 110, 50));

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(51, 51, 51));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 110, 50));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(51, 51, 51));
        btnDelete.setText("RESET");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 130, 50));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, 120, 50));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 670, 110));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Kode Barang");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Satuan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Harga Jual");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Tanggal Beli");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 100, 30));
        jPanel2.add(txNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 30));

        cbSatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Pcs", "Pack", "Dus", "Lusin", "Kodi", "Liter", "Kotak", " " }));
        cbSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSatuanActionPerformed(evt);
            }
        });
        jPanel2.add(cbSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 160, 30));
        jPanel2.add(txStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 160, 30));

        txHargaJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHargaJualActionPerformed(evt);
            }
        });
        jPanel2.add(txHargaJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 30));

        jLabel3.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel3.setText("INPUT DATA BARANG");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 40));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -70, 2560, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Stock");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Expired");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 80, 30));
        jPanel2.add(txTglBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 160, 30));
        jPanel2.add(txExpired, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 160, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Harga Beli");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

        txHargaBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHargaBeliActionPerformed(evt);
            }
        });
        jPanel2.add(txHargaBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 160, 30));

        btnDelete1.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(51, 51, 51));
        btnDelete1.setText("DELETE");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 130, 50));

        txKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKodeBarangActionPerformed(evt);
            }
        });
        jPanel2.add(txKodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 160, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Nama Barang");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoNew.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String expired = formater.format(txExpired.getDate());
        String tglBeli = formater.format(txTglBeli.getDate());
        
        try {
            sql = "INSERT INTO `barang`(`kd_barang`, `nm_barang`, `satuan`, harga_beli,`harga_jual`, `stock`, `expired`, `tgl_beli`) "
                    + "VALUES ('"+txKodeBarang.getText()+"',"
                    + "'" + txNamaBarang.getText() + "',"
                    + "'" + cbSatuan.getSelectedItem() + "',"
                    + "'" + txHargaBeli.getText() + "',"
                    + "'" + txHargaJual.getText() + "',"
                    + "'" + txStock.getText() + "',"
                    + "'" + expired + "',"
                    + "'" + tglBeli + "')";
            st = con.createStatement();
            st.executeUpdate(sql);
            bersih();
            cibuak();

            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GAGAL TERSIMPAN" + e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: new Laporan_Suplier().setVisible(true);
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            bersih();
        } catch (SQLException ex) {
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
//        // TODO add your handling code here:
        try {
//            String kodeBarang = (String) defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 0);
//            if (kodeBarang.equals("")) {
            if (txKodeBarang.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu data pada tabel");
            } else {
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String expired = formater.format(txExpired.getDate());
                String tglBeli = formater.format(txTglBeli.getDate());

                sql = "UPDATE `barang` SET "
                        + "`nm_barang`='" + txNamaBarang.getText() + "',"
                        + "`satuan`='" + cbSatuan.getSelectedItem() + "',"
                        + "`harga_beli`='" + txHargaBeli.getText() + "',"
                        + "`harga_jual`='" + txHargaJual.getText() + "',"
                        + "`stock`='" + txStock.getText() + "',"
                        + "`expired`='" + expired + "',"
                        + "`tgl_beli`='" + tglBeli + "'"
                        + " WHERE kd_barang='" + txKodeBarang.getText() + "'";
                st = con.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Di EDIT");
                bersih();
                cibuak();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void cbSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSatuanActionPerformed

    private void txHargaJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHargaJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHargaJualActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date expired = new Date();
        Date tglBeli = new Date();
//        JOptionPane.showMessageDialog(null, defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 5));
        try {

            expired = new SimpleDateFormat("yyyy-MM-dd").parse(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 6) + "");
            tglBeli = new SimpleDateFormat("yyyy-MM-dd").parse(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 7) + "");
        } catch (ParseException ex) {
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
        txKodeBarang.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 0) + "");
        txNamaBarang.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 1) + "");
        txHargaBeli.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 3) + "");
        txHargaJual.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 4) + "");
        txStock.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 5) + "");
        txExpired.setDate(expired);
        txTglBeli.setDate(tglBeli);
        cbSatuan.setSelectedItem(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 2) + "");
        txKodeBarang.setEditable(false);

    }//GEN-LAST:event_tabelBarangMouseClicked

    private void txHargaBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHargaBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHargaBeliActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        try {
//            String kodeBarang = (String) defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 0);
//            if (kodeBarang.equals("")) {
                if (txKodeBarang.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu data pada tabel");
            } else {
                sql = "DELETE from barang where kd_barang='" + txKodeBarang.getText() + "'";
                st = con.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Telah Dihapus!!");
                bersih();
                cibuak();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void txKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txKodeBarangActionPerformed

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
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Barang().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbSatuan;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelBarang;
    private com.toedter.calendar.JDateChooser txExpired;
    private javax.swing.JTextField txHargaBeli;
    private javax.swing.JTextField txHargaJual;
    private javax.swing.JTextField txKodeBarang;
    private javax.swing.JTextField txNamaBarang;
    private javax.swing.JTextField txStock;
    private com.toedter.calendar.JDateChooser txTglBeli;
    // End of variables declaration//GEN-END:variables
}
