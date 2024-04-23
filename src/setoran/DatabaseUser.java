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
    private List<User> registeredUser = new ArrayList<User>();
    
    public void registerUser(User user){
        registeredUser.add(user);
    }
    
    public User authUser(String username, String password){
        for (User user : registeredUser){
            if (user.getUsername() == username && user.getPassword() == password){
                return user;
            }
        }
        return null;
    }
}
