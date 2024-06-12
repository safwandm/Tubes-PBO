/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
    
    // parameter structure berisi list 2 dimensi, dengan format {{[nama kolom], [tipe data kolom]}, {[nama kolom], [tipe data kolom]}}
    // untuk tipe data gunakan enum Koneksi.RowType
    public static List<List<Object>> query(String sql, String[][] structure) {
        try {
            st = koneksi.prepareStatement(sql);
            return resultSetToObject(st.executeQuery(sql), structure);
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
                    throw e;
                }

            }
            list.add(dto);
        }
        return list;
    }
    
    public enum RowType { number, string, date };
    public static List<List<Object>> resultSetToObject(ResultSet resultSet, String[][] structure) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        List<List<Object>> list = new ArrayList<>();
        while(resultSet.next()) {

            List<Object> obj = new ArrayList<Object>();

            for(String[] field: structure) {
                
                try{
                    if (RowType.number.toString().equals(field[1]))
                        obj.add(resultSet.getInt(field[0]));
                    else if (RowType.string.toString().equals(field[1]))
                        obj.add(resultSet.getString(field[0]));
                    else
                        obj.add(resultSet.getDate(field[0]));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }

            }

            list.add(obj);

        }
        return list;
    }

    // ada parameter table karena belum tentu objeknya disimpan di 1 table saja
    public static void delete(Deletable data, String table) {
        try {
            String sql = String.format("delete from " + table +" where " + data.getColId() + " = %d", 
                data.getId());
            Koneksi.update(sql);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    public static void softDelete(Deletable data, String table) {
        try {
            String sql = String.format("update %s set deleted='true' where %s=%d", 
                table, data.getColId(), data.getId());
            Koneksi.update(sql);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
