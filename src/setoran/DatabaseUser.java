/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setoran;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author haidar
 */
public class DatabaseUser {
    private static List<User> registeredUser = new ArrayList<User>();
    
    public static boolean isUsernameExist(String username) {
        for (User user : registeredUser){
            if (user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    
    public static void registerUser(User user){
        registeredUser.add(user);
    }
    
    public static User authUser(String username, String password){
        for (User user : registeredUser){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
