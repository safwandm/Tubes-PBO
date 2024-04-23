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
public class Motor {
    private String nama;
    private User pemilik, penyewa;
    private int hargaSewa;
    private boolean tersedia;

    public Motor(String nama, User pemilik, int hargaSewa) {
        this.nama = nama;
        this.pemilik = pemilik;
        this.hargaSewa = hargaSewa;
        tersedia = true;
    }

    public String getNama() {
        return nama;
    }

    public User getPemilik() {
        return pemilik;
    }
    
    public User getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(User penyewa) {
        this.penyewa = penyewa;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }
    
    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void motorInfo() {
        System.out.printf("Nama: %s\nPemilik: %s\nHarga sewa: %d\n", nama, pemilik.getUsername(), hargaSewa);
    }
    
}
