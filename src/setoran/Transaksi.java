/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setoran;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author daman1k
 */
public class Transaksi {
    int id_transaksi, id_user, id_motor, nominal, hariSewa;
    String tgl_mulai, tgl_selesai;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Transaksi(int id_transaksi, int id_user, int id_motor, int nominal, String tgl_mulai, String tgl_selesai) {
        this.id_transaksi = id_transaksi;
        this.id_user = id_user;
        this.id_motor = id_motor;
        this.nominal = nominal;
        this.tgl_mulai = tgl_mulai;
        this.tgl_selesai = tgl_selesai;
    }
    
    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(String tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }
    
    public int getHariSewa() {
                
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the strings to LocalDate
        LocalDate startDate = LocalDate.parse(tgl_mulai, formatter);
        LocalDate endDate = LocalDate.parse(tgl_selesai, formatter);

        // Calculate the number of days between
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        
        return (int)daysBetween;
        
    }
    public static int getHariSewa(String tgl_mulai, String tgl_selesai) {
                
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the strings to LocalDate
        LocalDate startDate = LocalDate.parse(tgl_mulai, formatter);
        LocalDate endDate = LocalDate.parse(tgl_selesai, formatter);

        // Calculate the number of days between
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);        
        
        return (int)daysBetween + 1;
        
    }
}
