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
public class KatalogM {
    public ArrayList<Motor> listMotor = new ArrayList<Motor>();    
    
    public void addMotor(Motor m) {
        listMotor.add(m);
    }
    
    public void removeMotor(Motor m) {
        listMotor.remove(m);
    }
    
    public Motor getMotor(int index) {
        return listMotor.get(index);
    }
    
//    public Motor getMotor(String nama) {
//        for (Motor m : listMotor) {
//            if (m.getNama() == nama) {
//                return m;
//            }
//        }
//        return null;
//    }
    
    public ArrayList<Motor> motorAktif() {
//        int i = 0;
//        System.out.println("Motor aktif: ");
//        for (Motor m : listMotor) {
//            if (m.isTersedia()) {
//                System.out.printf("%d. %s\n", ++i, m.getNama());
//            }
//        }
//        
//        if (i == 0) {
//            System.out.println("Tidak ada motor yang aktif.");
//        }

        ArrayList<Motor> aktif = new ArrayList<Motor>();
        for (Motor m : listMotor) {
            if (m.isTersedia()) {
                aktif.add(m);
            }
        }
        return aktif;

    }
    public ArrayList<Motor> motorNonAktif() {
//        int i = 0;
//        System.out.println("Motor tidak aktif: ");
//        for (Motor m : listMotor) {
//            if (!m.isTersedia()) {
//                System.out.printf("%d. %s\n", ++i, m.getNama());
//            }
//        }
//        
//        if (i == 0) {
//            System.out.println("Tidak ada motor yang non-aktif.");
//        }   

        ArrayList<Motor> nonAktif = new ArrayList<Motor>();
        for (Motor m : listMotor) {
            if (!m.isTersedia()) {
                nonAktif.add(m);
            }
        }
        return nonAktif;
    }
}
