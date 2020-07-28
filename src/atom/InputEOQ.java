/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputEOQ.java
 *
 * Created on Jan 4, 2019, 11:04:57 AM
 */

package atom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ferri A Effindri
 */
public class InputEOQ extends javax.swing.JFrame {
private Statement st;
    private ResultSet rs;
    private Connection con;
    private String sql;
    private Statement stat;
    /** Creates new form InputEOQ */
    public InputEOQ() {
        initComponents();

        koneksi();
        tampil_barang();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ckd_brg = new javax.swing.JComboBox();
        vnm_brg = new javax.swing.JTextField();
        vsatuan = new javax.swing.JTextField();
        vharga = new javax.swing.JTextField();
        vstok = new javax.swing.JTextField();
        vkebutuhan = new javax.swing.JTextField();
        vby_simpan = new javax.swing.JTextField();
        vby_pesan = new javax.swing.JTextField();
        vunit = new javax.swing.JTextField();
        vhari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Kode Barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nama Barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 100, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Satuan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Harga");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Stok");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Kebutuhan/Tahun");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 120, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Biaya Simpan");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Biaya Pesan");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 70, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Jml Pemesanan yang ekonomis/ Unit");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 290, 20));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Waktu Interval Pemesanan yang ekonomis/ Hari");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 290, 20));

        ckd_brg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        ckd_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckd_brgActionPerformed(evt);
            }
        });
        ckd_brg.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ckd_brgPropertyChange(evt);
            }
        });
        getContentPane().add(ckd_brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 80, -1));

        vnm_brg.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vnm_brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 240, 20));

        vsatuan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vsatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 120, -1));

        vharga.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 90, -1));

        vstok.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 60, -1));
        getContentPane().add(vkebutuhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, -1));

        vby_simpan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vby_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 130, 20));

        vby_pesan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vby_pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 20));

        vunit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        vunit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vunitActionPerformed(evt);
            }
        });
        getContentPane().add(vunit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 80, 20));

        vhari.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(vhari, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 80, 20));

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 90, 30));

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, 30));

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 90, 30));

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 90, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("PROSES");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 80, 40));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("ANALISA EOQ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void tampil_barang(){
        try {
            sql = "select *from barang";
            st = con.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {
                String panggil=rs.getString("kd_barang");
                ckd_brg.addItem(panggil);
            }
        } catch (Exception e) {
            ckd_brg.setSelectedItem("kd_barang");
        }
    }
    private void ckd_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckd_brgActionPerformed
        // TODO add your handling code here:
        try {
            sql= "select * from barang where kd_barang='"+ckd_brg.getSelectedItem()+"'";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {
                vnm_brg.setText(rs.getString("nm_barang"));
                vsatuan.setText(rs.getString("satuan"));

                vharga.setText(rs.getString("harga_beli"));
                vstok.setText(rs.getString("stock"));
            }
            vnm_brg.setEnabled(false);
            vsatuan.setEnabled(false);

            vharga.setEnabled(false);
            vstok.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            sql= "select jumlah,sum(jumlah) as tot from transaksijual where kd_brg='"+ckd_brg.getSelectedItem()+"'";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {
                vkebutuhan.setText(rs.getString("tot"));
            }
            vkebutuhan.setEnabled(true);
        } catch (Exception e) {
        }
}//GEN-LAST:event_ckd_brgActionPerformed

    private void ckd_brgPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ckd_brgPropertyChange
        // TODO add your handling code here:
}//GEN-LAST:event_ckd_brgPropertyChange

    private void vunitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vunitActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_vunitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Keluar",
                "Exit",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            this.dispose();
        }
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            sql="update inputeoq set kd_brg='"+ckd_brg.getSelectedItem()+
                    "',kbth_thn='"+vkebutuhan.getText()+
                    "',by_simpan='"+vby_simpan.getText()+
                    "',by_pesan='"+vby_pesan.getText()+
                    "',jml_psn='"+vunit.getText()+
                    "',interval='"+vhari.getText()+
                    "' where kd_brg='"+ckd_brg.getSelectedItem()+"'";
            st=con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Edit"+e);
        }
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        hapus();
}//GEN-LAST:event_jButton6ActionPerformed
  private void hapus(){
        ckd_brg.setSelectedItem("");
        vnm_brg.setText("");
        vsatuan.setText("");
        vharga.setText("");
        vstok.setText("");
        ckd_brg.requestFocus();
        ckd_brg.setEnabled(true);
        vnm_brg.setEnabled(true);
        vsatuan.setEnabled(true);
        vharga.setEnabled(true);
        vstok.setEnabled(true);

        vkebutuhan.setText("");
        vby_pesan.setText("");
        vby_simpan.setText("");
        vkebutuhan.setEnabled(true);
        vby_pesan.setEnabled(true);
        vby_simpan.setEnabled(true);

        vunit.setText("");
        vhari.setText("");
        vunit.setEnabled(true);
        vhari.setEnabled(true);

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String stock=vstok.getText().toString();
        if (ckd_brg.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Data Belum Lengkap");
            ckd_brg.requestFocus();
        }else   if (vkebutuhan.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Belum Lengkap");
            vkebutuhan.requestFocus();
        }else   if (vby_pesan.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Belum Lengkap");
            vby_pesan.requestFocus();
        }else   if (vby_simpan.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Belum Lengkap");
            vby_simpan.requestFocus();

        }else {

            try {
                sql="insert into inputeoq value('"+ckd_brg.getSelectedItem()+"','"
                        +vkebutuhan.getText()+"','"
                        +vby_simpan.getText()+"','"
                        +vby_pesan.getText()+"','"
                        +vunit.getText()+"','"
                        +vhari.getText()+"')";
                st = con.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimipan"+e);
            }
        }

        vkebutuhan.setEnabled(false);
        vby_simpan.setEnabled(false);
        vby_pesan.setEnabled(false);
        vunit.setEnabled(false);
        vhari.setEnabled(false);
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int kbth,bysimpan,bypesan,harii,interval;
        String hari = "",unit="";

        kbth=Integer.parseInt(vkebutuhan.getText());
        bysimpan=Integer.parseInt(vby_simpan.getText());
        bypesan=Integer.parseInt(vby_pesan.getText());
        harii=(int) Math.sqrt(2*(bypesan*kbth)/bysimpan);
        interval=(int)((double)Math.sqrt(((double)2*bypesan)/((double)bysimpan*kbth))*365);
        //hari+=" hari";
        //unit+=" unit";
        vunit.setText(String.valueOf(harii+unit));
        vhari.setText(String.valueOf(interval+hari));
}//GEN-LAST:event_jButton7ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputEOQ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ckd_brg;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField vby_pesan;
    private javax.swing.JTextField vby_simpan;
    private javax.swing.JTextField vharga;
    private javax.swing.JTextField vhari;
    private javax.swing.JTextField vkebutuhan;
    private javax.swing.JTextField vnm_brg;
    private javax.swing.JTextField vsatuan;
    private javax.swing.JTextField vstok;
    private javax.swing.JTextField vunit;
    // End of variables declaration//GEN-END:variables

    private void koneksi() {
         try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:pklpelet","","");

       }catch(Exception e)

       {
        JOptionPane.showMessageDialog(null,"eror"+ e.getMessage());
       }
    }

}