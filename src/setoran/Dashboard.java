/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;

import java.util.Scanner;

/**
 *
 * @author haidar
 */
public class Dashboard {
    Scanner scanInt = new Scanner(System.in);
    Scanner scanStr = new Scanner(System.in);

    public User currentUser;
    //private DatabaseUser databaseUser = new DatabaseUser();
    
    public void login(){

        System.out.print("Username: ");
        String username = scanStr.nextLine();
        System.out.print("password: ");
        String password = scanStr.nextLine();

        User user = DatabaseUser.authUser(username, password);

        if (user == null){
            System.out.println("\nusername atau password salah");
            return;
        }

        currentUser = user;

        System.out.println("terlogin sebagai " + username);
    }

    public void logout(){
        currentUser = null;
    }

    public void register(){

        User user = null;
        
        String username, password;
        int age = 0;
                
        
        do {
            System.out.print("username: ");
            username = scanStr.nextLine();
            if (!DatabaseUser.isUsernameExist(username)) {
                System.out.println("\n - Username telah dipakai user lain - \n");
            }
        }
        while (!DatabaseUser.isUsernameExist(username));
        
        do {
            System.out.print("age: ");
            age = scanInt.nextInt();
            if (age < 18 || age > 90) {
                System.out.println("\n - Input umur tidak valid, Coba lagi - \n");
            }        }
        while (age < 18 || age > 90); 
        
        System.out.print("password: ");
        password = scanStr.nextLine();

        while (user == null) {
        System.out.print("Mitra(M) or Pelanggan(P): ");
        String MorP = scanStr.nextLine();
            switch (MorP) {
                case "M":
                    user = new Mitra(username, password, age);
                    break;
                case "P":
                    user = new Pelanggan(username, password, age);
                    break;
                default:
                    System.out.println("\n - Input tidak valid, Coba lagi - \n");
                    continue;
            }
        }
                
        DatabaseUser.registerUser(user);
        currentUser = user;

    }
    
}
