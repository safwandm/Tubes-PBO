/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    public static <T> List <T> query(String sql, Class<T> clazz) {
        try {
            st = koneksi.prepareStatement(sql);
            return resultSetToObject(st.executeQuery(sql), clazz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
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

    public static <T> List <T> resultSetToObject(ResultSet resultSet, Class<T> clazz) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        for(Field field: fields) {
            field.setAccessible(true);
        }

        List<T> list = new ArrayList<>();
        while(resultSet.next()) {

            T dto = clazz.getConstructor().newInstance();

            for(Field field: fields) {
                String name = field.getName();

                try{
                    String value = resultSet.getString(name);
                    field.set(dto, field.getType().getConstructor(String.class).newInstance(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            list.add(dto);

        }
        return list;
    }
}
