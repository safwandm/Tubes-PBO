/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daman1k
 */
public class DriverSeToRan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        KatalogM k = new KatalogM();
        Mitra mitra = new Mitra("mitra", "1", 19);
        Pelanggan pelanggan = new Pelanggan("pelanggan", "1", 20);
        Motor motor = new Motor("Motor1", mitra, 1984);
                       
                
        mitra.menyewakanM(motor, k);
        
        System.out.println("\n1");
        System.out.println("Aktif: ");
        k.motorAktif().forEach(action -> System.out.println("- "+action.getNama()));
        System.out.println("Non-Aktif: ");
        k.motorNonAktif().forEach(action -> System.out.println("- "+action.getNama()));

        
        pelanggan.sewaM(0, k);
        
        System.out.println("\n2");
        System.out.println("Aktif: ");
        k.motorAktif().forEach(action -> System.out.println("- "+action.getNama()));
        System.out.println("Non-Aktif: ");
        k.motorNonAktif().forEach(action -> System.out.println("- "+action.getNama()));
                
        
        pelanggan.mengembalikanM(k);
        
        System.out.println("\n3");
        System.out.println("Aktif: ");
        k.motorAktif().forEach(action -> System.out.println("- "+action.getNama()));
        System.out.println("Non-Aktif: ");
        k.motorNonAktif().forEach(action -> System.out.println("- "+action.getNama()));

        
        mitra.mencabutM(k);
        
        k.listMotor.forEach(action -> System.out.println(action.getNama()));
        System.out.println("\n4");
        System.out.println("Aktif: ");
        k.motorAktif().forEach(action -> System.out.println("- "+action.getNama()));
        System.out.println("Non-Aktif: ");
        k.motorNonAktif().forEach(action -> System.out.println("- "+action.getNama()));

    }
    
}
