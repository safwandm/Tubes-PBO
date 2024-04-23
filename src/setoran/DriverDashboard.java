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
        
        Scanner scan = new Scanner(System.in);
        
        int input;
        boolean loop = true;
        
        while (loop) {
            System.out.print("\n1. Login\n2. Register\nInput: ");
            input = scan.nextInt();
            
            if (input == 1) {
                d.login();
            } else {
                d.register();
            }
            
      
            
        }
        
    } 
}
