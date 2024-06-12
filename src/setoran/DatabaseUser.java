/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author haidar
 */
public class DatabaseUser extends DefaultTableModel {
    private static ArrayList<User> registeredUser = new ArrayList<>();
    public static User currentUser;
    
    public static boolean isUsernameExist(String username) {
        for (User user : registeredUser){
            if (user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    
    
    public static void registerUser(String tipeAkun, String username, String password, int age) {
        try {
            String sql = String.format("INSERT INTO user VALUES(NULL, '"
                + username + "', '"
                + password + "', '"
                + age + "', '"
                + tipeAkun + "')");
            Koneksi.update(sql);
        } catch (Exception e) {
            System.out.println("RegisterError" + e.getMessage());
        }
    }
    
    public static User authUser(String username, String password){
        try {
            String sql = "SELECT * FROM user WHERE username = '" + username + "' and password = '" + password + "'";
            Koneksi.query(sql);
            if (Koneksi.rs.next()) {
                int idUser = Koneksi.rs.getInt("id_user");
                int umur = Koneksi.rs.getInt("umur");
                String tipeAkun = Koneksi.rs.getString("tipe_akun");
                if (tipeAkun.equals("Pelanggan")) {
                    currentUser = new Pelanggan(idUser, username, password, umur);
                } else if (tipeAkun.equals("Mitra")) {
                    currentUser = new Mitra(idUser, username, password, umur);
                }
                
                return currentUser;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("AuthError");
            return null;
        }
    }
}
