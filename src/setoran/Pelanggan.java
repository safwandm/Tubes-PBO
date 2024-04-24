/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

public class Pelanggan extends User {
    
    private Motor sewa;

    public Pelanggan(String username, String password, int age) {
        super(username, password, age);
    }

    public Motor getSewa() {
        return sewa;
    }
    
    public void sewaM(int m, KatalogM k) {
        if (!k.getListMotor().isEmpty()) {
            if (sewa == null) {
                sewa = k.getMotor(m);
                sewa.setTersedia(false);
                sewa.setPenyewa(this);
                System.out.println("\nMotor berhasil disewa");
            } else {
                System.out.println("\nAnda sudah menyewa motor: "+sewa.getNama());
            }       
        } else {
            System.out.println("\n");
        }
    }
    
    public void mengembalikanM(KatalogM km) {
        if (sewa != null) {
            sewa.setTersedia(true);
            sewa.setPenyewa(null);
            sewa = null;
            System.out.println("\nMotor berhasil dikembalikan");
        } else {
            System.out.println("\nAnda sedang tidak menyewa motor apapun");
        }
    }
    
    @Override
    public void UserInfo() {
        System.out.printf("\nNama: %s\nUmur: %s\nMotor yang disewa: ", this.getUsername(), this.getAge());
        if (sewa != null) {
            System.out.println(sewa.getNama());
            System.out.println("Harga Sewa: "+sewa.getHargaSewa());
            System.out.println("Pemilik: "+sewa.getPemilik().getUsername());
        } else {
            System.out.println("-");
        }
    }
}
