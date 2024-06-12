/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

public class Pelanggan extends User {    
    public Pelanggan(int idUser, String username, String password, int umur) {
        super(idUser,username, password, umur, "Pelanggan");
    }
    public Motor getMotorDisewa() throws Exception {
            String sql = String.format("Select * from vu_join_transaksi_motor where id_user = '%s' and status_transaksi = 'aktif'", this.getIdUser());
            Koneksi.query(sql);
            Koneksi.rs.next();
            
            return new Motor(
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
            );
    }

}
