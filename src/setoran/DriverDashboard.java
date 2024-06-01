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
public class DriverDashboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Dashboard d = new Dashboard();
//        KatalogM k = new KatalogM();
//        
//        Scanner scanInt = new Scanner(System.in);
//        Scanner scanStr = new Scanner(System.in);
//        
//        int input;
//        String inputStr;
//        
//        boolean loop = true;
//        
//        while (loop) {
//            System.out.println("\n-----Login/Register-----");
//            System.out.print("1. Login\n2. Register\n0. Exit\nInput: ");
//            input = scanInt.nextInt();
//            
//            switch (input) {
//                case 1:
//                    System.out.println("\n-----Login-----");
//                    d.login();
//                    break;
//                case 2:
//                    System.out.println("\n-----Register-----");
//                    d.register();
//                    break;
//                case 0:
//                    loop = false;
//                    break;
//                default:
//                    System.out.println("\nInput tidak dikenali");
//            }
//            
//            while (d.currentUser != null) {
//                System.out.println("\n-----Menu-----");
//                if (d.currentUser instanceof Pelanggan) {
//                    Pelanggan user = (Pelanggan)d.currentUser;
//                    System.out.print("1. Sewa motor\n2. Mengembalikan\n3. Info\n0. Logout\nInput: ");
//                    input = scanInt.nextInt();
//                    
//                    switch (input) {
//                        case 1:
//                            if (user.getSewa() != null) {
//                                System.out.println("\nAnda sudah menyewa sebuah motor");
//                            } else if (k.getListMotor().isEmpty()) {
//                                System.out.println("\nTidak ada motor yang tersedia");
//                            } else {
//                                System.out.println("\nPilih motor yang tersedia: ");
//                                int i = 0;
//                                for (Motor m: k.motorAktif()) {
//                                    System.out.printf("%d. Nama: %s\n   Harga: %d\n   Pemilik: %s\n",
//                                            ++i,
//                                            m.getNama(),
//                                            m.getHargaSewa(), 
//                                            m.getPemilik().getUsername());
//                                }
//                                
//                                System.out.print("Input: ");
//                                input = scanInt.nextInt();
//                                user.sewaM(--input, k);
//                            }
//                            break;
//                            
//                        case 2:
//                            user.mengembalikanM(k);
//                            break;
//                            
//                        case 3:
//                            user.UserInfo();
//                            break;
//                            
//                        case 0:
//                            d.logout();
//                            continue;
//                            
//                        default:
//                            System.out.println("\nInput tidak dikenali");
//                    }
//
//                } else {
//                    Mitra user = (Mitra)d.currentUser;
//                    System.out.print("1. Menyewakan Motor\n2. Mencabut\n3. Info\n0. Logout\nInput: ");
//                    input = scanInt.nextInt();
//                    
//                    switch (input) {
//                        case 1:
//                            
//                            if (user.getDisewa() == null) {
//                                String nama;
//                                int harga;
//                                System.out.println("\nTulis Deskripsi motor");
//                                System.out.print("Nama: ");
//                                nama = scanStr.nextLine();
//                                System.out.print("Harga: ");
//                                harga = scanInt.nextInt();
//                                user.menyewakanM(new Motor(nama, user, harga), k);
//                            } else {
//                                System.out.printf("\nAnda sedang menyewakan %s. Cabut dulu motornya untuk menyewakan motor lain\n", user.getDisewa().getNama());
//                            }
//                            break;
//                            
//                        case 2:
//                            user.mencabutM(k);
//                            break;  
//                            
//                        case 3:
//                            user.UserInfo();
//                            break;
//                            
//                        case 0:
//                            d.logout();
//                            continue;
//                            
//                        default:
//                            System.out.println("Input tidak dikenali");
//                    }
//                }
//            }
//        }   
    }
}
