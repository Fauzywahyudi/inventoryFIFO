/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fauzy Wahyudi
 */
public class PembelianNew extends javax.swing.JFrame {

    String tgl;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private DefaultTableModel dtm;
    private String sql;
    private Date tgpsn;

    public PembelianNew() throws SQLException {
        initComponents();
        Koneksi koneksi = new Koneksi();
        con = koneksi.getKoneksi();
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        txNoFaktur.setEditable(false);
        txSisaBayar.setEditable(false);
        txSisaStock.setEditable(false);
        txNamaBarang.setEditable(false);
        txNamaPelanggan.setEditable(false);
        txHarga.setEditable(false);
        txKodeBarang.setEditable(false);
        txKodePelanggan.setEditable(false);
        txJumlahBayar.setEditable(false);
        bersih();
        faktur();
        tgl();
        showBarang();
        showSuplier();
        showTransaksi();
    }

    private void faktur() throws SQLException {
        sql = "select no_fak_beli from transaksibeli order by no_fak_beli desc LIMIT 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            String kd = rs.getString("no_fak_beli");
            int no = Integer.parseInt(kd) + 1;
//            String No1 = "";
//            if (no < 10) {
//                No1 = "00000";
//            } else if (no < 100) {
//                No1 = "0000";
//            } else if (no < 1000) {
//                No1 = "000";
//            } else if (no < 10000) {
//                No1 = "00";
//            } else if (no < 100000) {
//                No1 = "0";
//            } else {
//                No1 = "";
//            }

            txNoFaktur.setText("" + no);
        } else {
            txNoFaktur.setText("1");
        }
    }

    private void tgl() {
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        txTglJual.setDate(ys);
    }

    private void bersih() throws SQLException {
//        throw new UnsupportedOperationException("Not yet implemented");


        txKodePelanggan.setText("");
        txNamaPelanggan.setText("");
        txKodeBarang.setText("");
        txNamaBarang.setText("");
        txHarga.setText("");
        txStock.setText("");
        txJumlahBeli.setText("");
        txJumlahBayar.setText("");
        txBayar.setText("");
        txSisaBayar.setText("");
        txSisaStock.setText("");
        faktur();
        showBarang();

    }

    private void showBarang() {
        try {
            Object[] rows = {"KODE BARANG", " NAMA BARANG", "SATUAN", "HARGA BELI", "STOK"};
            dtm = new DefaultTableModel(null, rows);
            tabelBarang.setModel(dtm);
            tabelBarang.setBorder(null);
            jScrollPane2.setVisible(true);
            jScrollPane2.setViewportView(tabelBarang);
            String kd_barang = "", nm_barang = "", satuan = "", harga_jual = "", stock = "";
            try {
                sql = "select * from barang ORDER BY kd_barang ASC";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    kd_barang = rs.getString("kd_barang");
                    nm_barang = rs.getString("nm_barang");
                    satuan = rs.getString("satuan");
                    harga_jual = rs.getString("harga_beli");
                    stock = rs.getString("stock");
                    String[] tampil = {kd_barang, nm_barang, satuan, harga_jual, stock};
                    dtm.addRow(tampil);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Salah" + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSuplier() {
        try {
            Object[] rows = {"KODE", " NAMA", "ALAMAT", "NO TLP"};
            dtm = new DefaultTableModel(null, rows);
            tabelSuplier.setModel(dtm);
            tabelSuplier.setBorder(null);
            jScrollPane3.setVisible(true);
            jScrollPane3.setViewportView(tabelSuplier);
            String kd_costumer = "", nm_costumer = "", alamat = "", tlp = "";
            try {
                sql = "select * from suplier ORDER BY kd_sup ASC";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    kd_costumer = rs.getString("kd_sup");
                    nm_costumer = rs.getString("nm_sup");
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

    private void updateStok(String kd_barang, String jumlah, String tipe, String tgl) throws SQLException {
        if (tipe.equals("kurang")) {
            String sql = "UPDATE `barang` SET `stock`=stock - " + jumlah + " WHERE kd_barang='" + kd_barang + "'";
            st = con.createStatement();
            st.executeUpdate(sql);
        } else {
            String sql = "UPDATE `barang` SET `stock`=stock + " + jumlah + ", tgl_beli = '"+tgl+"' WHERE kd_barang='" + kd_barang + "'";
            st = con.createStatement();
            st.executeUpdate(sql);
        }
    }

    private void showTransaksi() {
        try {
            Object[] rows = {"NO FAKTUR", " TANGGAL", "KODE CUSTOMER", "NAMA CUSTOMER", "KODE BARANG", "NAMA BARANG","STOCK", "HARGA BELI", "JUMLAH BELI", "JUMLAH BAYAR", "SISA STOK"};
            dtm = new DefaultTableModel(null, rows);
            tabelTransaksi.setModel(dtm);
            tabelTransaksi.setBorder(null);
            jScrollPane1.setVisible(true);
            jScrollPane1.setViewportView(tabelTransaksi);
            String no_faktur = "", tanggal = "", kd_costomer = "", nm_costumer = "", kd_barang = "", nm_barang = "", harga_jual = "", stock = "", jumlah = "", totalharga = "", bayar = "", sisa = "", stock_akhir = "";
            try {
                sql = "select * from transaksibeli INNER JOIN suplier ON transaksibeli.kd_sup=suplier.kd_sup INNER JOIN barang ON transaksibeli.kd_barang=barang.kd_barang ORDER BY transaksibeli.no_fak_beli ASC";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    no_faktur = rs.getString("no_fak_beli");
                    tanggal = rs.getString("tgl_beli");
                    kd_costomer = rs.getString("kd_sup");
                    nm_costumer = rs.getString("nm_sup");
                    kd_barang = rs.getString("kd_barang");
                    nm_barang = rs.getString("nm_barang");

                    stock = rs.getString("stok");
                    harga_jual = rs.getString("harga_beli");
                    jumlah = rs.getString("jumlah");
                    totalharga = rs.getString("total");
                    stock_akhir = rs.getString("stok_sisa");
                    String[] tampil = {no_faktur, tanggal, kd_costomer, nm_costumer, kd_barang, nm_barang, stock, harga_jual, jumlah, totalharga, stock_akhir};
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txNoFaktur = new javax.swing.JTextField();
        txKodePelanggan = new javax.swing.JTextField();
        txNamaPelanggan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txKodeBarang = new javax.swing.JTextField();
        txNamaBarang = new javax.swing.JTextField();
        txHarga = new javax.swing.JTextField();
        txStock = new javax.swing.JTextField();
        txJumlahBeli = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txJumlahBayar = new javax.swing.JTextField();
        txBayar = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelSuplier = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txSisaBayar = new javax.swing.JTextField();
        txSisaStock = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        txTglJual = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI PEMBELIAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1280, 30));

        jLabel2.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOKO DAYA FAMILY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1280, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Kode Suplier");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Tanggal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 80, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Nama Suplier");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Stock");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 80, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("No Faktur");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 20));

        txNoFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNoFakturActionPerformed(evt);
            }
        });
        jPanel1.add(txNoFaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 150, 30));

        txKodePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKodePelangganActionPerformed(evt);
            }
        });
        jPanel1.add(txKodePelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 150, 30));

        txNamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNamaPelangganActionPerformed(evt);
            }
        });
        jPanel1.add(txNamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 150, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Kode Barang");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Jumlah Beli ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Harga           Rp");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 20));

        txKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKodeBarangActionPerformed(evt);
            }
        });
        jPanel1.add(txKodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 150, 30));
        jPanel1.add(txNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 150, 30));

        txHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHargaActionPerformed(evt);
            }
        });
        jPanel1.add(txHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 150, 30));
        jPanel1.add(txStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 150, 30));

        txJumlahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJumlahBeliActionPerformed(evt);
            }
        });
        txJumlahBeli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txJumlahBeliFocusGained(evt);
            }
        });
        txJumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txJumlahBeliKeyReleased(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txJumlahBeliKeyPressed(evt);
            }
        });
        jPanel1.add(txJumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Bayar               Rp");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 120, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Sisa Stock");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 80, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Jumah Bayar   Rp");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 120, 20));

        txJumlahBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJumlahBayarActionPerformed(evt);
            }
        });
        jPanel1.add(txJumlahBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 150, 30));

        txBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBayarActionPerformed(evt);
            }
        });
        txBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txBayarKeyReleased(evt);
            }
        });
        jPanel1.add(txBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 150, 30));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(51, 51, 51));
        btnSave.setText("TAMBAH");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 50));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(51, 51, 51));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 130, 50));

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(51, 51, 51));
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 120, 50));

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
        tabelBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelBarangKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 550, 120));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelTransaksi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 1170, 150));

        tabelSuplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSuplierMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelSuplier);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 550, 120));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Nama Barang");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Sisa Bayar        Rp");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 120, 20));

        txSisaBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSisaBayarActionPerformed(evt);
            }
        });
        jPanel1.add(txSisaBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 150, 30));
        jPanel1.add(txSisaStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 150, 30));

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNew.setForeground(new java.awt.Color(51, 51, 51));
        btnNew.setText("RESET");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 120, 50));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Tabel Barang");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 100, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Tabel Suplier");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 100, -1));

        jButton7.setBackground(new java.awt.Color(102, 102, 0));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("EXIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 120, 50));
        jPanel1.add(txTglJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 150, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoNew.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txNoFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNoFakturActionPerformed
        // TODO add your handling code here:
        //         try{
        //        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        //         con = DriverManager.getConnection("jdbc:odbc:pklpelet","","");
        //         st = con.createStatement();
        //        String sql = "select * from penjualan where no_faktur like '"+jTextField1.getText()+"'";
        //        ResultSet rs = st.executeQuery(sql);
        //        if(rs.next()){
        //            jTextField1.setText(rs.getString(1));
        //            vtgl.setText(rs.getString(2));
        //            jTextField3.setText(rs.getString(3));
        //            jTextField4.setText(rs.getString(4));
        //            jTextField5.setText(rs.getString(5));
        //            jTextField6.setText(rs.getString(6));
        //            jTextField7.setText(rs.getString(7));
        //            jTextField8.setText(rs.getString(8));
        //            jTextField9.setText(rs.getString(9));
        //            jTextField10.setText(rs.getString(10));
        //
        //            jTextField12.setText(rs.getString(11));
        //            jTextField13.setText(rs.getString(12));
        //            jTextField14.setText(rs.getString(13));
        //
        //        }
        //        else{
        //            JOptionPane.showMessageDialog(null,"Tidak ada data");
        //
        //        }
        //        st.close();
        //        con.close();
        //       }
        //       catch(Exception e){
        //           JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
        //       }
    }//GEN-LAST:event_txNoFakturActionPerformed

    private void txKodePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKodePelangganActionPerformed
        // TODO add your handling code here:
//        try {
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            con = DriverManager.getConnection("jdbc:odbc:pklpelet", "", "");
//            st = con.createStatement();
//            String sql = "select * from costumer where kd_costumer like '" + txKodePelanggan.getText() + "'";
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//                txKodePelanggan.setText(rs.getString(1));
//                txNamaPelanggan.setText(rs.getString(2));
//            } else {
//                JOptionPane.showMessageDialog(null, "Tidak ada data");
//
//            }
//            st.close();
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
//        }
    }//GEN-LAST:event_txKodePelangganActionPerformed

    private void txNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNamaPelangganActionPerformed

    private void txKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKodeBarangActionPerformed
        // TODO add your handling code here:
//        try {
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            con = DriverManager.getConnection("jdbc:odbc:pklpelet", "", "");
//            st = con.createStatement();
//            String sql = "select * from barang where kd_barang like '" + txKodeBarang.getText() + "'";
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//                txKodeBarang.setText(rs.getString(1));
//                txNamaBarang.setText(rs.getString(2));
//                txHarga.setText(rs.getString(5));
//                txStock.setText(rs.getString(6));
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Tidak ada data");
//
//            }
//            st.close();
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
//        }
    }//GEN-LAST:event_txKodeBarangActionPerformed

    private void txHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHargaActionPerformed

    private void txJumlahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJumlahBeliActionPerformed
        // TODO add your handling code here:
        // double bayar=Double.parseDouble(jTextField10.getText());
        //int jmb=Integer.parseInt(jTextField9.getText());
        //double harga=Double.parseDouble(jTextField7.getText());
        //int stok=Integer.parseInt(jTextField8.getText());
        //int sisa=Integer.parseInt(jTextField14.getText());
        //bayar=jmb*harga;
        //sisa= stok-jmb;
        //jTextField10.setText(Double.toString(bayar));
        //jTextField14.setText(Integer.toString(sisa));
//        Double n1;
//        Double n2;
//        Double n3;
//        Double proses;
//        Double prosess;
//        n1 = Double.valueOf(txJumlahBeli.getText());
//        n2 = Double.valueOf(txStock.getText());
//        n3 = Double.valueOf(txHarga.getText());
//
//        proses = n2 - n1;
//        prosess = n3 * n1;
//        txSisaStock.setText("" + proses);
//        txJumlahBayar.setText("" + prosess);
    }//GEN-LAST:event_txJumlahBeliActionPerformed

    private void txJumlahBeliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txJumlahBeliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txJumlahBeliFocusGained

    private void txJumlahBeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txJumlahBeliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txJumlahBeliKeyPressed

    private void txJumlahBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txJumlahBeliKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txJumlahBeliKeyReleased

    private void txJumlahBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJumlahBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txJumlahBayarActionPerformed

    private void txBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBayarActionPerformed

    private void txBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBayarKeyReleased
        // TODO add your handling code here:
        int nn;
        int nm;
        int proses;

        nn = Integer.valueOf(txJumlahBayar.getText());
        nm = Integer.valueOf(txBayar.getText());
        proses = nm - nn;
        txSisaBayar.setText("" + proses);
    }//GEN-LAST:event_txBayarKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (!txKodePelanggan.getText().equals("") && !txKodePelanggan.getText().equals("")) {
            int total = Integer.parseInt(txJumlahBayar.getText());
            int dibayar = Integer.parseInt(txBayar.getText());
            if (dibayar >= total) {
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String tgl = formater.format(txTglJual.getDate());
                try {
                    sql = "insert into transaksibeli values('" + txNoFaktur.getText()
                            + "','" + tgl
                            + "','" + txKodePelanggan.getText()
                            + "','" + txKodeBarang.getText()
                            + "','" + txJumlahBeli.getText()
                            + "','" + txHarga.getText()
                            + "','" + txJumlahBayar.getText()
                            + "','" + txStock.getText()
                            + "','" + txSisaStock.getText()
                            + "')";
                    st = con.createStatement();
                    st.executeUpdate(sql);
                    updateStok(txKodeBarang.getText(), txJumlahBeli.getText(), "tambah", tgl);
                    showBarang();
                    showSuplier();
                    showTransaksi();
                    bersih();
                    JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "GAGAL TERSIMPAN" + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Uang Kurang");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Barang atau Pelanggan");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int stok = 0;
            String noFaktur = tabelTransaksi.getValueAt(tabelTransaksi.getSelectedRow(), 0).toString();
            String kodeBarang = tabelTransaksi.getValueAt(tabelTransaksi.getSelectedRow(), 4).toString();
            String jumlah = tabelTransaksi.getValueAt(tabelTransaksi.getSelectedRow(), 8).toString();
            String sqlGet = "SELECT * from transaksibeli WHERE no_fak_beli='" + noFaktur + "'";
            st = con.createStatement();
            rs = st.executeQuery(sqlGet);
            while (rs.next()) {
                stok = Integer.valueOf(rs.getString("jumlah"));
            }
            int jumBeli = Integer.valueOf(jumlah);
            sql = "DELETE from transaksibeli where no_fak_beli='" + noFaktur + "'";
            st = con.createStatement();
            st.execute(sql);
            sql = "UPDATE barang set stock=stock - "+jumBeli+"  where kd_barang='"+kodeBarang+"'";
            st = con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Telah Dihapus!!");
            bersih();
            showTransaksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        txKodeBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 0).toString());
        txNamaBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 1).toString());
        txHarga.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 3).toString());
        txStock.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void tabelBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelBarangKeyPressed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        try {
            // TODO add your handling code here:
            bersih();
        } catch (SQLException ex) {
            Logger.getLogger(penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
//        txNoFaktur.setText(tabelTransaksi.getValueAt(tabelTransaksi.getSelectedRow(), 0).toString());
//        
//        txJumlahBeli.setText(tabelTransaksi.getValueAt(tabelTransaksi.getSelectedRow(), 8).toString());
//        txKodeBarang.setText(tabelTransaksi.getValueAt(tabelTransaksi.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void tabelSuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSuplierMouseClicked
        // TODO add your handling code here:
        txKodePelanggan.setText(tabelSuplier.getValueAt(tabelSuplier.getSelectedRow(), 0).toString());
        txNamaPelanggan.setText(tabelSuplier.getValueAt(tabelSuplier.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tabelSuplierMouseClicked

    private void txSisaBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSisaBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSisaBayarActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            // TODO add your handling code here:
            bersih();
        } catch (SQLException ex) {
            Logger.getLogger(penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(PembelianNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PembelianNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PembelianNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PembelianNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PembelianNew().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PembelianNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelSuplier;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField txBayar;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txJumlahBayar;
    private javax.swing.JTextField txJumlahBeli;
    private javax.swing.JTextField txKodeBarang;
    private javax.swing.JTextField txKodePelanggan;
    private javax.swing.JTextField txNamaBarang;
    private javax.swing.JTextField txNamaPelanggan;
    private javax.swing.JTextField txNoFaktur;
    private javax.swing.JTextField txSisaBayar;
    private javax.swing.JTextField txSisaStock;
    private javax.swing.JTextField txStock;
    private com.toedter.calendar.JDateChooser txTglJual;
    // End of variables declaration//GEN-END:variables
}
