/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

import java.util.ArrayList;

/**
 *
 * @author daman1k
 */
public class Mitra extends User {
    
    private ArrayList<Motor> motorDisewa;

    public Mitra(String username, String password, int age) {
        super(username, password, age);
    }
    
    
    
    @Override
    public void UserInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
