/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Koneksi {
    static Connection koneksi = getConnection();
    static Statement st;
    static PreparedStatement pst;
<<<<<<< Updated upstream
    static ResultSet rs;
=======
    public static ResultSet rs;
>>>>>>> Stashed changes
    
    public static Connection getConnection() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/setoran", "root", "");
            return koneksi;
<<<<<<< Updated upstream
        } catch (Exception e) {
=======
        } catch (ClassNotFoundException | SQLException e) {
>>>>>>> Stashed changes
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
<<<<<<< Updated upstream
    public static ResultSet query(String sql) {
=======
    public static void query(String sql) {
>>>>>>> Stashed changes
        try {
            st = koneksi.prepareStatement(sql);
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
<<<<<<< Updated upstream
            System.err.println(e);
        }
        return rs;
=======
            System.out.println(e.getMessage());
        }
>>>>>>> Stashed changes
    }
    
    public static void disconnect() throws SQLException {
        koneksi.close();
    }
    
    public static void update(String sql) {
        try {
            
        } catch (Exception e) {
        }
    }
}
