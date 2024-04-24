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
    
    private Motor disewakan;

    public Mitra(String username, String password, int age) {
        super(username, password, age);
    }

    public Motor getDisewa() {
        return disewakan;
    }
    
    @Override
    public void UserInfo() {
        System.out.printf("\nNama: %s\nUmur: %s\nMotor yang disewakan: ", this.getUsername(), this.getAge());
        if (disewakan != null) {
            System.out.println(disewakan.getNama());
            System.out.println("Harga sewa: "+disewakan.getHargaSewa());
            
            if (!disewakan.isTersedia()) {
                System.out.println("Penyewa: " + disewakan.getPenyewa().getUsername());
            }
            
        } else {
            System.out.println("-");
        }
    }
    
    public void menyewakanM(Motor m, KatalogM k) {
        if (disewakan == null) {
            k.addMotor(m);
            disewakan = m;
            System.out.printf("\n%s telah berhasil disewakan\n", m.getNama());
        } else {
            System.out.println("\nAnda sudah menyewakan: "+disewakan.getNama());
        }
    }   
    
    public void mencabutM(KatalogM k) {
        if (disewakan != null) {
            if (disewakan.isTersedia()) {
                k.removeMotor(disewakan);
                disewakan = null;
                System.out.println("\nMotor teah berhasil dicabut");
            } else {
                System.out.println("\nMotor sedang disewa pelanggan");
            }
        } else {
            System.out.println("\nAnda tidak sedang menyewakan motor");
        }
    } 
}
