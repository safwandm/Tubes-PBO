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
    private DatabaseUser databaseUser = new DatabaseUser();
    
    public void login(){
        System.out.println("\nsilahkan login");

        System.out.print("Username: ");
        String username = scanStr.nextLine();
        System.out.print("password: ");
        String password = scanStr.nextLine();

        User user = databaseUser.authUser(username, password);

        if (user == null){
            System.out.println("username atau password salah");
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
        
        System.out.println("\nsilahkan register");
        System.out.print("username: ");
        String username = scanStr.nextLine();
        System.out.print("age: ");
        int age = scanInt.nextInt();
        System.out.print("password: ");
        String password = scanStr.nextLine();

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
                    System.out.println("\nInvalid input try again\n");
                    continue;
            }
        }
                
        databaseUser.registerUser(user);
        currentUser = user;

    }

}
