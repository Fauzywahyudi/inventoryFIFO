/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author nanda
 */
public class pembelian extends javax.swing.JFrame {
private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private DefaultTableModel dtm;
    private String sql;
    private Date tgpsn;
    /**
     * Creates new form pembelian
     */
    public pembelian() {
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
        cigap();
        tengok();
       tgl();
       auto();
    }
    private void auto(){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:pklpelet","","");
            sql="select * from pembelian order by no_faktur desc";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           if(rs.next()){
               String kd = rs.getString("no_faktur").substring(1);
               String n_u = ""+(Integer.parseInt(kd)+1);
               String No1 = "";
               if(n_u.length()==1){No1 ="0000";}
               else if(n_u.length()==2){No1 ="000";} 
               else if(n_u.length()==3){No1 ="00";} 
               else if(n_u.length()==4){No1 ="0";} 
               else if(n_u.length()==5){No1 ="";} 
               
               jTextField1.setText(No1+n_u);
           }
           else{jTextField1.setText("00001");}                   
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Query Salah"+e.getMessage());
        }   
    }         


private void tgl()
    {
        Date ys=new Date ();
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
        jTextField2.setText(s.format(ys));
    }
     private void bersih() {
//        throw new UnsupportedOperationException("Not yet implemented");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
               
     }
          
     private  void cigap(){
        try {
            Object[] rows={"KODE BARANG"," NAMA BARANG","SATUAN","HARGA BELI","STOK"};
            dtm=new DefaultTableModel(null,rows);
            jTable1.setModel(dtm);
            jTable1.setBorder(null);
            jScrollPane3.setVisible(true);
            jScrollPane3.setViewportView(jTable1);
             String kd_barang="",nm_barang="",satuan="",harga_beli="",stock="";
            try{
                sql="select * from barang";
                st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    kd_barang=rs.getString("kd_barang");
                    nm_barang=rs.getString("nm_barang");
                    satuan=rs.getString("satuan");  
                    harga_beli=rs.getString("harga_beli");
                    stock=rs.getString("stock");
                    String [] tampil={kd_barang,nm_barang,satuan,harga_beli,stock};
                    dtm.addRow(tampil);
                }
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Query Salah"+e.getMessage());
        }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
     private  void cibuak(){
        try {
            Object[] rows={"NO FAKTUR"," TANGGAL","KODE SUPLIER","NAMA SUPLIER","KODE BARANG","NAMA BARANG","SATUAN","HARGA","JUMLAH BELI"," STOK","TOTAL HARGA","BAYAR","KEMBALI"};
            dtm=new DefaultTableModel(null,rows);
            jTable2.setModel(dtm);
            jTable2.setBorder(null);
            jScrollPane1.setVisible(true);
            jScrollPane1.setViewportView(jTable2);
            String no_faktur="",tanggal="",kd_suplier="",nm_suplier="",kd_barang="",nm_barang="",satuan="",harga_beli="",jumlah="",stok_baru="",total_hrg="",bayar="",sisa="";
            try{
                sql="select * from pembelian";
                st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    no_faktur=rs.getString("no_faktur");
                    tanggal=rs.getString("tanggal");
                    kd_suplier=rs.getString("kd_suplier");
                    nm_suplier=rs.getString("nm_suplier");
                    kd_barang=rs.getString("kd_barang");
                    nm_barang=rs.getString("nm_barang");
                    satuan=rs.getString("satuan");
                    harga_beli=rs.getString("harga_beli");
                    jumlah=rs.getString("jumlah");
                    stok_baru=rs.getString("stok_baru");
                    total_hrg=rs.getString("total_hrg");
                    bayar=rs.getString("bayar");
                    sisa=rs.getString("sisa");       
                    String [] tampil={no_faktur,tanggal,kd_suplier,nm_suplier,kd_barang,nm_barang,satuan,harga_beli,jumlah,stok_baru,total_hrg,bayar,sisa};
                    dtm.addRow(tampil);
                }
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Query Salah"+e.getMessage());
        }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
     private  void tengok(){
        try {
            Object[] rows={"KODE"," NAMA","ALAMAT","NO TLP"};
            dtm=new DefaultTableModel(null,rows);
            jTable3.setModel(dtm);
            jTable3.setBorder(null);
            jScrollPane2.setVisible(true);
            jScrollPane2.setViewportView(jTable3);
             String kd_suplier="", nm_suplier="",alamat="", telp="";
            try{
                sql="select * from suplier";
                st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    kd_suplier=rs.getString("kd_suplier");
                    nm_suplier=rs.getString("nm_suplier");
                    alamat=rs.getString("alamat");
                    telp=rs.getString("telp");
                    String [] tampil={kd_suplier,nm_suplier,alamat,telp};
                    dtm.addRow(tampil);
                }
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Query Salah"+e.getMessage());
        }
        }
        catch(Exception e){
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField12 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Kode Suplier");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 90, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Kode Barang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Satuan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 80, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Tanggal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Harga");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 70, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Stok");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 60, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Jumlah Beli");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 80, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("No Faktur");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, 30));

        jLabel10.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel10.setText("TRANSAKSI PEMBELIAN");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 290, 30));

        jLabel12.setFont(new java.awt.Font("Angsana New", 1, 36)); // NOI18N
        jLabel12.setText("TOKO RONI KOMPUTER");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 290, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Kembalian");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 80, 40));

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 30));

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 140, 30));

        jTextField3.setText("jTextField3");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 140, 30));

        jTextField4.setText("jTextField4");
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 140, 30));

        jTextField5.setText("jTextField5");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 140, 30));

        jTextField6.setText("jTextField6");
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 140, 30));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 160, 30));

        jTextField8.setText("jTextField8");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 140, 30));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 160, 30));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 160, 30));
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 160, 30));

        jButton1.setBackground(new java.awt.Color(102, 102, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 120, 50));

        jButton2.setBackground(new java.awt.Color(102, 102, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 120, 50));

        jButton3.setBackground(new java.awt.Color(102, 102, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 430, -1, 50));

        jButton4.setBackground(new java.awt.Color(102, 102, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 120, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 590, 110));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 1170, 150));
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 160, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Nama Suplier");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Nama Barang");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Stok Baru");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 70, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Total Harga");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 80, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Bayar");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 80, 30));

        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 160, 30));
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 160, 30));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 590, 120));

        jButton5.setBackground(new java.awt.Color(102, 102, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("TAMBAH STOCK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 180, 50));

        jButton6.setBackground(new java.awt.Color(102, 102, 0));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("NEW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 120, 50));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tabel Barang");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 100, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Tabel Suplier");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 100, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 1230, -1));

        jLabel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 20, 3220, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
              
            sql="insert into pembelian values('"+jTextField1.getText()
                                              +"','"+jTextField2.getText()                                           
                                              +"','"+jTextField3.getText()    
                                              +"','"+jTextField4.getText()                                            
                                              +"','"+jTextField5.getText()                                           
                                              +"','"+jTextField6.getText()                                                
                                              +"','"+jTextField8.getText()
                                              +"','"+jTextField7.getText()
                                              +"','"+jTextField9.getText()                                           
                                              +"','"+jTextField10.getText()    
                                              +"','"+jTextField11.getText()
                                              +"','"+jTextField12.getText()
                                              +"','"+jTextField13.getText()
                                              +"','"+jTextField14.getText()
                                              +"')";
            st=con.createStatement();
            st.executeUpdate(sql);
             
             cibuak();
             auto();
            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");
                                                       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "GAGAL TERSIMPAN"+e);            
        }     
             
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
        Double n1 ;
        Double n2 ;
        Double n3 ;      
        Double proses ;
        Double prosess ;
        n1 = Double.valueOf(jTextField9.getText());
        n2 = Double.valueOf(jTextField10.getText());
        n3 = Double.valueOf(jTextField7.getText());
       
        
            proses = n1 + n2;
            prosess = n3 * n1;
            jTextField11.setText(""+proses);
            jTextField12.setText(""+prosess);
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         jTextField5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
         jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
         jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
         jTextField7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
         jTextField10.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
         jTextField3.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
         jTextField4.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:
        Double nn ;
        Double nm ;       
        Double proses ;
       
        nn = Double.valueOf(jTextField13.getText());
        nm = Double.valueOf(jTextField12.getText());       
            proses = nn - nm;        
            jTextField14.setText(""+proses);
           
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try
    {
        
        sql="update barang set nm_barang='"+jTextField6.getText()+                          
                              "',stock='"+jTextField11.getText()+
                              "' where kd_barang='"+jTextField5.getText()+"'";
                      st=con.createStatement();
                      st.execute(sql);
                      JOptionPane.showMessageDialog(null,"Stock Ditambahkan"+sql);
                      auto();
                      cigap();
                
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try
    {
        
        sql="update pembelian set tanggal='"+jTextField2.getText()+
                                "',kd_suplier='"+jTextField3.getText()+
                                "',nm_suplier='"+jTextField4.getText()+
                                "',kd_barang='"+jTextField5.getText()+
                                "',nm_barang='"+jTextField6.getText()+
                                "',satuan='"+jTextField8.getText()+
                                "',harga_beli='"+jTextField7.getText()+
                                "',jumlah='"+jTextField9.getText()+
                                "',stock='"+jTextField10.getText()+
                                "',stok_baru='"+jTextField11.getText()+
                                "',total_hrg='"+jTextField12.getText()+
                                "',bayar='"+jTextField13.getText()+
                                "',sisa='"+jTextField14.getText()+               
                                
                                "' where no_faktur='"+jTextField1.getText()+"'";
                      st=con.createStatement();
                      st.execute(sql);
                      JOptionPane.showMessageDialog(null,"Data Berhasil Di EDIT");
                      bersih();
                      cibuak();
                      auto();
                     
                      
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
         try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con = DriverManager.getConnection("jdbc:odbc:pklpelet","","");
         st = con.createStatement();
        String sql = "select * from pembelian where no_faktur like '"+jTextField1.getText()+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            jTextField1.setText(rs.getString(1));
            jTextField2.setText(rs.getString(2));         
            jTextField3.setText(rs.getString(3));
            jTextField4.setText(rs.getString(4));
            jTextField5.setText(rs.getString(5));
            jTextField6.setText(rs.getString(6));
            jTextField8.setText(rs.getString(7));         
            jTextField7.setText(rs.getString(8));
            jTextField9.setText(rs.getString(9));
            jTextField10.setText(rs.getString(10));
            jTextField11.setText(rs.getString(11));
            jTextField12.setText(rs.getString(12));         
            jTextField13.setText(rs.getString(13));
            jTextField14.setText(rs.getString(14));
            
        }
        else{          
            JOptionPane.showMessageDialog(null,"Tidak ada data");
           
        }
        st.close();
        con.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error"+e.getMessage()); 
       }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            
            sql="DELETE from pembelian where no_faktur='"+jTextField1.getText()+"'";
            st=con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null,"Data Telah Dihapus!!");
            bersih();
            cibuak();
            auto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
          try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con = DriverManager.getConnection("jdbc:odbc:pklpelet","","");
         st = con.createStatement();
        String sql = "select * from suplier where kd_suplier like '"+jTextField3.getText()+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            jTextField3.setText(rs.getString(1));
            jTextField4.setText(rs.getString(2));
        }
        else{          
            JOptionPane.showMessageDialog(null,"Tidak ada data");
           
        }
        st.close();
        con.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error"+e.getMessage()); 
       }
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
