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
    private int idMotor;
    private String platNomor;
    private String brand;
    private String tipe;
    private String tahun;
    private String transmisi;
    private String statusMotor;
    private int silinder;
    private int hargaHarian;
    
//    private String nama;
//    private User pemilik;
//    private Pelanggan penyewa;
//    private int hargaSewa;
//    private boolean tersedia;

//    public Motor(String nama, User pemilik, int hargaSewa) {
//        this.nama = nama;
//        this.pemilik = pemilik;
//        this.hargaSewa = hargaSewa;
//        tersedia = true;
//    }

    public Motor(int id_motor, String plat_nomor, String brand, String tipe, String tahun, String transmisi, String status_motor, int silinder, int harga_harian) {
        this.idMotor = id_motor;
        this.platNomor = plat_nomor;
        this.brand = brand;
        this.tipe = tipe;
        this.tahun = tahun;
        this.transmisi = transmisi;
        this.statusMotor = status_motor;
        this.silinder = silinder;
        this.hargaHarian = harga_harian;
    }

    public int getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(int idMotor) {
        this.idMotor = idMotor;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTransmisi() {
        return transmisi;
    }

    public void setTransmisi(String transmisi) {
        this.transmisi = transmisi;
    }

    public String getStatusMotor() {
        return statusMotor;
    }

    public void setStatusMotor(String statusMotor) {
        this.statusMotor = statusMotor;
    }

    public int getSilinder() {
        return silinder;
    }

    public void setSilinder(int silinder) {
        this.silinder = silinder;
    }

    public int getHargaHarian() {
        return hargaHarian;
    }

    public void setHargaHarian(int hargaHarian) {
        this.hargaHarian = hargaHarian;
    }
    
//    public String getNama() {
//        return nama;
//    }
//
//    public User getPemilik() {
//        return pemilik;
//    }
//    
//    public User getPenyewa() {
//        return penyewa;
//    }
//
//    public void setPenyewa(User pemilik) {
//        this.pemilik = pemilik;
//    }
//
//    public int getHargaSewa() {
//        return hargaSewa;
//    }
//    
//    public boolean isTersedia() {
//        return tersedia;
//    }
//
//    public void setTersedia(boolean tersedia) {
//        this.tersedia = tersedia;
//    }
//
//    public void motorInfo() {
//        System.out.printf("Nama: %s\nPemilik: %s\nHarga sewa: %d\n", nama, pemilik.getUsername(), hargaSewa);
//    }
    
}