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
public class Motor implements Deletable{
    private int idMotor;
    private String platNomor;
    private String brand;
    private String tipe;
    private String tahun;
    private String transmisi;
    private String statusMotor;
    private int silinder;
    private int hargaHarian;
    private int idPemilik;    

    public Motor(int id_motor, String plat_nomor, String brand, String tipe, String tahun, String transmisi, String status_motor, int silinder, int harga_harian, int id_pemilik) {
        this.idMotor = id_motor;
        this.platNomor = plat_nomor;
        this.brand = brand;
        this.tipe = tipe;
        this.tahun = tahun;
        this.transmisi = transmisi;
        this.statusMotor = status_motor;
        this.silinder = silinder;
        this.hargaHarian = harga_harian;
        this.idPemilik = id_pemilik;
    }

    public int getIdMotor() {
        return idMotor;
    }
    public int getId(){
        return idMotor;
    }
    public String getColId() {
        return "id_motor";
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

    public Integer getSilinder() {
        return silinder;
    }

    public void setSilinder(int silinder) {
        this.silinder = silinder;
    }

    public Integer getHargaHarian() {
        return hargaHarian;
    }

    public void setHargaHarian(int hargaHarian) {
        this.hargaHarian = hargaHarian;
    }
    
    public int getIdPemilik() {
        return idPemilik;
    }

    public void setIdPemilik(int idPemilik) {
        this.idPemilik = idPemilik;
    }
        
}