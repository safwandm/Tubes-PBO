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
    private ArrayList<Motor> listMotor = new ArrayList<Motor>();    

    public ArrayList<Motor> getListMotor() {
        return listMotor;
    }
    
    public void addMotor(Motor m) {
        listMotor.add(m);    
    }
    
    public void removeMotor(Motor m) {
        listMotor.remove(m);
    }
    
    public Motor getMotor(int index) {
        return listMotor.get(index);
    }
    
    
//    public ArrayList<Motor> motorAktif() {
//
//        ArrayList<Motor> aktif = new ArrayList<Motor>();
//        for (Motor m : listMotor) {
//            if (m.isTersedia()) {
//                aktif.add(m);
//            }
//        }
//        return aktif;
//
//    }
//    public ArrayList<Motor> motorNonAktif() {
//
//        ArrayList<Motor> nonAktif = new ArrayList<Motor>();
//        for (Motor m : listMotor) {
//            if (!m.isTersedia()) {
//                nonAktif.add(m);
//            }
//        }
//        return nonAktif;
//    }
}
