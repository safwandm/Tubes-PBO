/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;
import java.util.Scanner;

/**
 *
 * @author daman1k
 */
public class DriverDashboard {
    public static void main(String[] args) {
        Dashboard d = new Dashboard();
        KatalogM k = new KatalogM();
        
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        
        int input;
        String inputStr;
        
        boolean loop = true;
        
        while (loop) {
            System.out.print("\n1. Login\n2. Register\n0. Exit\nInput: ");
            input = scanInt.nextInt();
            
            if (input == 1) {
                d.login();
            } else if (input == 2) {
                d.register();
            } else {
                loop = false;
            }
            
            while (d.currentUser != null) {
                if (d.currentUser instanceof Pelanggan) {
                    Pelanggan user = (Pelanggan)d.currentUser;
                    System.out.print("\n1. Sewa motor\n2. Mengembalikan\n3. Info\n0. Logout\nInput: ");
                    input = scanInt.nextInt();
                    
                    switch (input) {
                        case 1:
                            
                            if (!k.listMotor.isEmpty()) {
                                System.out.println("\nPilih motor yang tersedia: ");
                                int i = 0;
                                for (Motor m: k.motorAktif()) {
                                    System.out.println(++i +". "+ m.getNama());
                                }

                                System.out.print("Input: ");
                                input = scanInt.nextInt();
                                user.sewaM(--input, k);
                            } else {
                                System.out.println("\nTidak ada motor yang tersedia");
                            }
                            
                            break;
                        case 2:
                            user.mengembalikanM(k);
                            System.out.println("\nMotor berhasil dikembalikan");
                            break;
                        case 3:
                            user.UserInfo();
                            break;
                        case 0:
                            d.logout();
                            continue;
                        default:
                            System.out.println("Input tidak dikenali");
                    }

                } else {
                    Mitra user = (Mitra)d.currentUser;
                    System.out.print("\n1. Menyewa\n2. Mencabut\n3. Info\n0. Logout\nInput: ");
                    input = scanInt.nextInt();
                    
                    switch (input) {
                        case 1:
                            String nama;
                            int harga;
                            System.out.println("\nTulis Deskripsi motor");
                            System.out.print("Nama: ");
                            nama = scanStr.nextLine();
                            System.out.print("Harga: ");
                            harga = scanInt.nextInt();
                            user.menyewakanM(new Motor(nama, user, harga), k);
                            break;
                            
                        case 2:
                            user.mencabutM(k);
                            System.out.println("Motor berhasil dicabut dari katalog");
                            break;                            
                            
                        case 3:
                            user.UserInfo();
                            break;
                        case 0:
                            d.logout();
                            continue;
                        default:
                            System.out.println("Input tidak dikenali");
                    }
                }
            }
           
            
        }
        
    } 
}
