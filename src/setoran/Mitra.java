/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

import java.util.ArrayList;


/**
 *
 * @author daman1k
 */
public class Mitra extends User {
    ArrayList<Motor> listMotor = new ArrayList<>();
    public Mitra(int idUser, String username, String password, int umur) {
        super(idUser, username, password, umur, "Mitra");
        
        
    }

public ArrayList<Motor> getListMotor() {
        try {
            
            String sql = String.format("Select * from Motor where id_pemilik = '%s' and deleted = 'false'", this.getIdUser());
            Koneksi.query(sql);
            while (Koneksi.rs.next()) {                
                listMotor.add(new Motor(
                        Koneksi.rs.getInt("id_motor"),
                        Koneksi.rs.getString("plat_nomor"),
                        Koneksi.rs.getString("brand"),
                        Koneksi.rs.getString("tipe"),
                        Koneksi.rs.getString("tahun"),
                        Koneksi.rs.getString("transmisi"),
                        Koneksi.rs.getString("status_motor"),
                        Koneksi.rs.getInt("silinder"),
                        Koneksi.rs.getInt("harga_harian"),
                        Koneksi.rs.getInt("id_pemilik")
                    )
                );
            } 
        } catch (Exception e) {}
        
        return listMotor;
    }
    
    
        
}
