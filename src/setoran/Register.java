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
public class Register {
    Scanner scan = new Scanner(System.in);
    
    private String username, password, MorP;
    private int age;
    
    public User Registration() {
        
        User user= null;
        
        System.out.print("\nusername: ");
        username = scan.nextLine();
        System.out.print("age: ");
        age = scan.nextInt();
        scan.nextLine();
        System.out.print("password: ");
        password = scan.nextLine();

        while (user == null) {
        System.out.print("Mitra(M) or Pelanggan(P): ");
        MorP = scan.nextLine();
            switch (MorP) {
                case "M":
                    user = new Mitra(username, password, age);
                case "P":
                    user = new Pelanggan(username, password, age);
                default:
                    System.out.println("\nInvalid input try again\n");
                    continue;

            }
        }
        
        return user;
       
    }
}
