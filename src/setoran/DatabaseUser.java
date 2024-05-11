/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author haidar
 */
public class DatabaseUser extends DefaultTableModel {
    private static List<User> registeredUser = new ArrayList<User>();
    private static Connection cn;
    
    public static boolean isUsernameExist(String username) {
        for (User user : registeredUser){
            if (user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    
    public static void registerUser(User user){
        registeredUser.add(user);
    }
    
    public static void registerUser(String tipeAkun, String username, String password, int age) {
        try {
            cn = Koneksi.getConnection();
            Statement st = cn.createStatement();
            String sql = String.format("INSERT INTO user VALUES('"
                + username + "', '"
                + password + "', '"
                + age + "', '"
                + tipeAkun + "')");
            st.executeUpdate(sql);
//            ResultSet r = st.executeQuery(sql);
            
//            if (r.next()) {
//                return new Pelanggan(username, password, 20);
//            } else {
//                return null;
//            }
        } catch (Exception e) {
            System.out.println("RegisterError" + e.getMessage());
//            return null;
        }
    }
    
    public static User authUser(String username, String password){
//        for (User user : registeredUser){
//            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
//                return user;
//            }
//        }
//        return null;

        try {
            cn = Koneksi.getConnection();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM user WHERE username = '" + username + "' and password = '" + password + "'";
            ResultSet r = st.executeQuery(sql);
            
            if (r.next()) {
                return new Pelanggan(username, password, 20);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("AuthError");
            return null;
        }
    }
}
