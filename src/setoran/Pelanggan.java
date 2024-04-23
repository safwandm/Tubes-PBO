/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

/**
 *
 * @author daman1k
 */
public class Pelanggan extends User {
    
    Motor sewa = null;

    public Pelanggan(String username, String password, int age) {
        super(username, password, age);
    }
    
    public void menyewa(Motor m) {
        if (sewa != null) {
            sewa = m;
        } else {
        }
    }
    
    @Override
    public void UserInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
