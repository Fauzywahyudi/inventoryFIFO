/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom;

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
public class barang extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private DefaultTableModel defaultTableModel;
    private String sql;

    /**
     * Creates new form barang
     */
    public barang() {
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

    private void bersih() {
//        throw new UnsupportedOperationException("Not yet implemented");
        txKodeBarang.setText("");
        txNamaBarang.setText("");
        txHarga.setText("");
        txStock.setText("");
        cbSatuan.setSelectedIndex(0);
        txExpired.setDate(null);
        txTglBeli.setDate(null);
        txKodeBarang.setEditable(true);
    }

    private void cibuak() {
        try {
            Object[] rows = {"KODE BARANG", " NAMA BARANG", "SATUAN", "HARGA", "STOK", "EXPIRED", "TANGGAL BELI"};
            defaultTableModel = new DefaultTableModel(null, rows);
            tabelBarang.setModel(defaultTableModel);
            tabelBarang.setBorder(null);
            jScrollPane2.setVisible(true);
            jScrollPane2.setViewportView(tabelBarang);
            String col1, col2, col3, col4, col5, col6, col7;
            try {
                sql = "select * from barang";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    col1 = rs.getString("kd_barang");
                    col2 = rs.getString("nm_barang");
                    col3 = rs.getString("satuan");
                    col4 = rs.getString("harga");
                    col5 = rs.getString("stock");
                    col6 = rs.getString("expired");
                    col7 = rs.getString("tgl_beli");
                    String[] tampil = {col1, col2, col3, col4, col5, col6, col7};
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
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txKodeBarang = new javax.swing.JTextField();
        txNamaBarang = new javax.swing.JTextField();
        cbSatuan = new javax.swing.JComboBox();
        txStock = new javax.swing.JTextField();
        txHarga = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txTglBeli = new com.toedter.calendar.JDateChooser();
        txExpired = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave.setBackground(new java.awt.Color(102, 102, 0));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(51, 51, 51));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 110, 50));

        btnEdit.setBackground(new java.awt.Color(102, 102, 0));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(51, 51, 51));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 110, 50));

        btnDelete.setBackground(new java.awt.Color(102, 102, 0));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(51, 51, 51));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 130, 50));

        jButton4.setBackground(new java.awt.Color(102, 102, 0));
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Kode Barang");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Nama Barang");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Satuan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Harga");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Tanggal Beli");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 100, 30));

        txKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKodeBarangActionPerformed(evt);
            }
        });
        jPanel2.add(txKodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 160, 30));
        jPanel2.add(txNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 30));

        cbSatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Pcs", "pack", "unit" }));
        cbSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSatuanActionPerformed(evt);
            }
        });
        jPanel2.add(cbSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 160, 30));
        jPanel2.add(txStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 30));

        txHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHargaActionPerformed(evt);
            }
        });
        jPanel2.add(txHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 160, 30));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(null);
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1030, -1));

        jLabel3.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel3.setText("INPUT DATA BARANG");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 40));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -70, 2560, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Stock");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 80, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Expired");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, 30));
        jPanel2.add(txTglBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 160, 30));
        jPanel2.add(txExpired, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 160, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String expired = formater.format(txExpired.getDate());
        String tglBeli = formater.format(txTglBeli.getDate());
        try {
            sql = "INSERT INTO `barang`(`kd_barang`, `nm_barang`, `satuan`, `harga`, `stock`, `expired`, `tgl_beli`) "
                    + "VALUES ('" + txKodeBarang.getText() + "',"
                    + "'" + txNamaBarang.getText() + "',"
                    + "'" + cbSatuan.getSelectedItem() + "',"
                    + "'" + txHarga.getText() + "',"
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
        // TODO add your handling code here:
        try {
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
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
//        // TODO add your handling code here:
        try {
            if (txKodeBarang.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu data pada tabel");
            } else {
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String expired = formater.format(txExpired.getDate());
                String tglBeli = formater.format(txTglBeli.getDate());

                sql = "UPDATE `barang` SET "
                        + "`nm_barang`='" + txNamaBarang.getText() + "',"
                        + "`satuan`='" + cbSatuan.getSelectedItem() + "',"
                        + "`harga`='" + txHarga.getText() + "',"
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

    private void txKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKodeBarangActionPerformed
        // TODO add your handling code here:
        try {

            st = con.createStatement();
            String sql = "select * from barang where kd_barang like '" + txKodeBarang.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                txKodeBarang.setText(rs.getString(1));
                txNamaBarang.setText(rs.getString(2));
                cbSatuan.setSelectedItem(rs.getString(3));
                txHarga.setText(rs.getString(4));
                txStock.setText(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada data");

            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_txKodeBarangActionPerformed

    private void cbSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSatuanActionPerformed

    private void txHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHargaActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date expired = new Date();
        Date tglBeli = new Date();
        try {
            expired = new SimpleDateFormat("yyyy-MM-dd").parse(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 5) + "");
            tglBeli = new SimpleDateFormat("yyyy-MM-dd").parse(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 6) + "");
        } catch (ParseException ex) {
            Logger.getLogger(barang.class.getName()).log(Level.SEVERE, null, ex);
        }

        txKodeBarang.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 0) + "");
        txNamaBarang.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 1) + "");
        txHarga.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 3) + "");
        txStock.setText(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 4) + "");
        txExpired.setDate(expired);
        txTglBeli.setDate(tglBeli);
        cbSatuan.setSelectedItem(defaultTableModel.getValueAt(tabelBarang.getSelectedRow(), 2) + "");

        txKodeBarang.setEditable(false);
    }//GEN-LAST:event_tabelBarangMouseClicked

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
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbSatuan;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelBarang;
    private com.toedter.calendar.JDateChooser txExpired;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txKodeBarang;
    private javax.swing.JTextField txNamaBarang;
    private javax.swing.JTextField txStock;
    private com.toedter.calendar.JDateChooser txTglBeli;
    // End of variables declaration//GEN-END:variables
}
