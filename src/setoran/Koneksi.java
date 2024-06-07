/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Koneksi {
    static Connection koneksi = getConnection();
    static Statement st;
    static PreparedStatement pst;
    public static ResultSet rs;
    
    // Ganti sesuai dengan preferensi koneksi masing-masing
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/setoran", "root", "");
            return koneksi;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static void query(String sql) {
        try {
            st = koneksi.prepareStatement(sql);
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void disconnect() throws SQLException {
        koneksi.close();
    }
    
    public static void update(String sql) throws SQLException {
        try {
            st = koneksi.prepareStatement(sql);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        }
    }
}
