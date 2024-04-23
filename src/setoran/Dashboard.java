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
    Scanner scan = new Scanner(System.in);

    private User currentUser;
    private DatabaseUser databaseUser;
    
    public void login(){
        System.out.println("silahkan login");

        System.out.print("Username: ");
        String username = scan.nextLine();
        System.out.print("password: ");
        String password = scan.nextLine();

        User user = databaseUser.authUser(username, password);

        if (user == null){
            System.out.println("username atau password salah");
        }

        currentUser = user;

        System.out.println("terlogin sebagai " + username);
    }

    public void logout(){
        currentUser = null;
    }

    public void register(){

        User user = null;
        
        System.out.print("\nusername: ");
        String username = scan.nextLine();
        System.out.print("age: ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.print("password: ");
        String password = scan.nextLine();

        while (user == null) {
        System.out.print("Mitra(M) or Pelanggan(P): ");
        String MorP = scan.nextLine();
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
        
        currentUser = user;

    }

}
