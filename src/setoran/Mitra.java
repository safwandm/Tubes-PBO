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
    
    Motor disewa;

    public Mitra(String username, String password, int age) {
        super(username, password, age);
    }
    
    @Override
    public void UserInfo() {
        System.out.printf("Nama: %s\nUmur: %s\n", this.getUsername(), this.getAge());
        if (disewa != null) {
            System.out.println("Motor yang disewakan: " + disewa.getNama());
            
            if (!disewa.isTersedia()) {
                System.out.println("Penyewa: " + disewa.getPenyewa().getUsername());
            }
            
        } else {
            System.out.println("-");
        }
    }
    
    public void menyewakanM(Motor m, KatalogM katalog) {
        katalog.addMotor(m);
        disewa = m;
    }   
    public void mencabutM(KatalogM katalog) {
        katalog.removeMotor(disewa);
        disewa = null;
    } 
}
