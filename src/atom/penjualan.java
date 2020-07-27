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
public class penjualan extends javax.swing.JFrame {
    String tgl;
private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private DefaultTableModel dtm;
    private String sql;
    private Date tgpsn;
    /**
     * Creates new form penjualan
     */
    public penjualan() {
        initComponents();
         
         Koneksi koneksi = new Koneksi();
        con = koneksi.getKoneksi();
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        bersih();
       tgl();
        cigap();
        tengok();
        cibuak();
    }
    private void tgl()
    {
        Date ys=new Date ();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        vtgl.setText(s.format(ys));
    }

private void bersih() {
//        throw new UnsupportedOperationException("Not yet implemented");
        jTextField1.setText("");
        
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");       
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        vtgl.setText("");
               
     }
private void auto(){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:pklpelet","","");
            sql="select * from penjualan order by no_faktur desc";
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

private  void cigap(){
        try {
            Object[] rows={"KODE BARANG"," NAMA BARANG","SATUAN","HARGA JUAL","STOK"};
            dtm=new DefaultTableModel(null,rows);
            jTable1.setModel(dtm);
            jTable1.setBorder(null);
            jScrollPane2.setVisible(true);
            jScrollPane2.setViewportView(jTable1);
             String kd_barang="",nm_barang="",satuan="",harga_jual="",stock="";
            try{
                sql="select * from barang";
                st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    kd_barang=rs.getString("kd_barang");
                    nm_barang=rs.getString("nm_barang");
                    satuan=rs.getString("satuan");  
                    harga_jual=rs.getString("harga_jual");
                    stock=rs.getString("stock");
                    String [] tampil={kd_barang,nm_barang,satuan,harga_jual,stock};
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
            jScrollPane3.setVisible(true);
            jScrollPane3.setViewportView(jTable3);
            String kd_costumer="", nm_costumer="",alamat="", tlp="";
            try{
                sql="select * from costumer";
                st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    kd_costumer=rs.getString("kd_costumer");
                    nm_costumer=rs.getString("nm_costumer");
                    alamat=rs.getString("alamat");
                    tlp=rs.getString("tlp");
                    String [] tampil={kd_costumer,nm_costumer,alamat,tlp};
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
            Object[] rows={"NO FAKTUR"," TANGGAL","KODE CUSTOMER","NAMA CUSTOMER","KODE BARANG","NAMA BARANG","HARGA","STOCK","JUMLAH BELI","JUMLAH BAYAR","BAYAR","SISA BAYAR","STOCK AKHIR"};
            dtm=new DefaultTableModel(null,rows);
            jTable2.setModel(dtm);
            jTable2.setBorder(null);
            jScrollPane1.setVisible(true);
            jScrollPane1.setViewportView(jTable2);
            String no_faktur="",tanggal="",kd_costomer="",nm_costumer="",kd_barang="",nm_barang="",harga_jual="",stock="",jumlah="",totalharga="",bayar="",sisa="",stock_akhir="";
            try{
                sql="select * from penjualan";
                st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    no_faktur=rs.getString("no_faktur");
                    tanggal=rs.getString("tanggal");
                    kd_costomer=rs.getString("kd_costomer");
                    nm_costumer=rs.getString("nm_costumer");
                    kd_barang=rs.getString("kd_barang");
                    nm_barang=rs.getString("nm_barang");          
                    
                    stock=rs.getString("stock");
                    harga_jual=rs.getString("harga_jual");
                    jumlah=rs.getString("jumlah");
                    totalharga=rs.getString("totalharga");
                    bayar=rs.getString("bayar");
                    sisa=rs.getString("sisa"); 
                    stock_akhir=rs.getString("stock_akhir"); 
                    String [] tampil={no_faktur,tanggal,kd_costomer,nm_costumer,kd_barang,nm_barang,harga_jual,stock,jumlah,totalharga,bayar,sisa,stock_akhir};
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
        jTextField1 = new javax.swing.JTextField();
        vtgl = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Angsana New", 1, 36));
        jLabel1.setText("TRANSAKSI PENJUALAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 300, 30));

        jLabel2.setFont(new java.awt.Font("Angsana New", 1, 36));
        jLabel2.setText("TOKO RONI KOMPUTER");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 300, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Code Costumer");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Tanggal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 80, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("Nama Costumer");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel6.setText("Stock");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 80, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel7.setText("No Faktur");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 150, 30));

        vtgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vtglActionPerformed(evt);
            }
        });
        jPanel1.add(vtgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 150, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 150, 30));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 150, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel8.setText("Kode Barang");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel9.setText("Jumlah Beli ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel11.setText("Harga          Rp");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 20));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 150, 30));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 150, 30));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 150, 30));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 150, 30));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel12.setText("Bayar               Rp");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 120, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel13.setText("Sisa Stock");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 80, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel14.setText("Jumah Bayar   Rp");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 120, 20));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 150, 30));

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 150, 30));

        jButton1.setBackground(new java.awt.Color(102, 102, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 120, 50));

        jButton2.setBackground(new java.awt.Color(102, 102, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 130, 50));

        jButton3.setBackground(new java.awt.Color(102, 102, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 120, 50));

        jButton4.setBackground(new java.awt.Color(102, 102, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 120, 50));

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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 550, 120));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 1170, 150));

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
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 550, 120));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel15.setText("Nama Barang");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel16.setText("Sisa Bayar        Rp");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 120, 20));

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 150, 30));
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 150, 30));

        jButton5.setBackground(new java.awt.Color(102, 102, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("UPDATE STOCK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 170, 50));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("NEW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 120, 50));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel10.setText("Tabel Barang");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 100, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel17.setText("Tabel Customer");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 100, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1230, -1));

        jButton7.setBackground(new java.awt.Color(102, 102, 0));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("EXIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 120, 50));

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton8.setText("TAMBAH BARANG");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {            
            sql="insert into penjualan values('"+jTextField1.getText()
                                              +"','"+vtgl.getText()                                           
                                              +"','"+jTextField3.getText()    
                                              +"','"+jTextField4.getText()                                            
                                              +"','"+jTextField5.getText()                                           
                                              +"','"+jTextField6.getText()                                                
                                             
                                              +"','"+jTextField7.getText()
                                               +"','"+jTextField8.getText()
                                              +"','"+jTextField9.getText()                                           
                                              +"','"+jTextField10.getText()                                               
                                              +"','"+jTextField12.getText()
                                              +"','"+jTextField13.getText()
                                              +"','"+jTextField14.getText()
                                              +"')";
            st=con.createStatement();
            st.executeUpdate(sql);
             
             cibuak();
             //auto();
            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");
                                                       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "GAGAL TERSIMPAN"+e);            
        }     
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         jTextField5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
         jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
         jTextField7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
         jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
        int n1 ;
        int n2 ;
        int n3 ;      
        int proses ;
        int prosess ;
        n1 = Integer.valueOf(jTextField9.getText());
        n2 = Integer.valueOf(jTextField8.getText());
        n3 = Integer.valueOf(jTextField7.getText());
       
        
            proses = n2-n1;
            prosess = n3*n1;
            jTextField14.setText(""+proses);
            jTextField10.setText(""+prosess);
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
        int nn ;
        int nm ;       
        int proses ;
       
        nn = Integer.valueOf(jTextField10.getText());
        nm = Integer.valueOf(jTextField12.getText());       
            proses = nm - nn;        
            jTextField13.setText(""+proses);
           
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        bersih();
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         try
    {
        
        sql="update barang set nm_barang='"+jTextField6.getText()+                          
                              "',stock='"+jTextField14.getText()+
                              "' where kd_barang='"+jTextField5.getText()+"'";
                      st=con.createStatement();
                      st.execute(sql);
                      JOptionPane.showMessageDialog(null,"Stock Diprebaruhi");
                     
                      cigap();
                
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try
    {
        
        sql="update penjualan set tanggal='"+vtgl.getText()+
                                "',kd_costomer='"+jTextField3.getText()+
                                "',nm_costumer='"+jTextField4.getText()+
                                "',kd_barang='"+jTextField5.getText()+
                                "',nm_barang='"+jTextField6.getText()+
                                "',harga_jual='"+jTextField7.getText()+
                                "',stock='"+jTextField8.getText()+
                                "',jumlah='"+jTextField9.getText()+
                                                         
                                "',totalharga='"+jTextField10.getText()+
                                "',bayar='"+jTextField12.getText()+
                                "',sisa='"+jTextField13.getText()+               
                                "',stock_akhir='"+jTextField14.getText()+  
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            
            sql="DELETE from penjualan where no_faktur='"+jTextField1.getText()+"'";
            st=con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null,"Data Telah Dihapus!!");
            bersih();
            cibuak();
            auto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
         try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con = DriverManager.getConnection("jdbc:odbc:pklpelet","","");
         st = con.createStatement();
        String sql = "select * from penjualan where no_faktur like '"+jTextField1.getText()+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            jTextField1.setText(rs.getString(1));
            vtgl.setText(rs.getString(2));         
            jTextField3.setText(rs.getString(3));
            jTextField4.setText(rs.getString(4));
            jTextField5.setText(rs.getString(5));
            jTextField6.setText(rs.getString(6));
            jTextField7.setText(rs.getString(7));         
            jTextField8.setText(rs.getString(8));
            jTextField9.setText(rs.getString(9));
            jTextField10.setText(rs.getString(10));
            
            jTextField12.setText(rs.getString(11));         
            jTextField13.setText(rs.getString(12));
            jTextField14.setText(rs.getString(13));
            
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

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        jTextField3.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
        jTextField4.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
         try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con = DriverManager.getConnection("jdbc:odbc:pklpelet","","");
         st = con.createStatement();
        String sql = "select * from costumer where kd_costumer like '"+jTextField3.getText()+"'";
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

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
         try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con = DriverManager.getConnection("jdbc:odbc:pklpelet","","");
         st = con.createStatement();
        String sql = "select * from barang where kd_barang like '"+jTextField5.getText()+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            jTextField5.setText(rs.getString(1));
            jTextField6.setText(rs.getString(2));
            jTextField7.setText(rs.getString(5));
            jTextField8.setText(rs.getString(6));
            
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
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
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
         Double n1 ;
        Double n2 ;
        Double n3 ;      
        Double proses ;
        Double prosess ;
        n1 = Double.valueOf(jTextField9.getText());
        n2 = Double.valueOf(jTextField8.getText());
        n3 = Double.valueOf(jTextField7.getText());
       
        
            proses = n2-n1;
            prosess = n3*n1;
            jTextField14.setText(""+proses);
            jTextField10.setText(""+prosess);
       
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
try {
            sql="insert into penjualan values('"+jTextField1.getText()
                                              +"','"+vtgl.getText()
                                              +"','"+jTextField3.getText()
                                              +"','"+jTextField4.getText()
                                              +"','"+jTextField5.getText()
                                              +"','"+jTextField6.getText()

                                              +"','"+jTextField7.getText()
                                               +"','"+jTextField8.getText()
                                              +"','"+jTextField9.getText()
                                              +"','"+jTextField10.getText()
                                              +"','"+jTextField12.getText()
                                              +"','"+jTextField13.getText()
                                              +"','"+jTextField14.getText()
                                              +"')";
            st=con.createStatement();
            st.executeUpdate(sql);

             cibuak();
             //auto();
            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "GAGAL TERSIMPAN"+e);
        }     

        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
      


}//GEN-LAST:event_jButton8ActionPerformed

    private void vtglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vtglActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_vtglActionPerformed

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
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
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
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField vtgl;
    // End of variables declaration//GEN-END:variables
}
