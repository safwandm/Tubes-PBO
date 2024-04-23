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
    private Mitra pemilik;
    private Pelanggan penyewa;
    private int hargaSewa;
    private boolean tersedia;

    public Motor(String nama, Mitra pemilik, int hargaSewa) {
        this.nama = nama;
        this.pemilik = pemilik;
        this.hargaSewa = hargaSewa;
        tersedia = true;
    }

    public String getNama() {
        return nama;
    }

    public Pelanggan getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(Pelanggan penyewa) {
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
