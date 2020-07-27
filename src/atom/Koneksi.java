/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atom;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Fauzy Wahyudi
 */
public class Koneksi {
    final static String url ="jdbc:mysql://localhost/db_dayafamily";
    final static String user = "root";
    final static String pass = "";
    final static String jdbcName = "com.mysql.jdbc.Driver";
    
    Connection con;
    
    public Connection getKoneksi(){
        try {
            Class.forName(jdbcName);
            this.con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung");
        }
        return con;
    }
}
