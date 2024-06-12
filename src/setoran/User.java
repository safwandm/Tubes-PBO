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
public abstract class User {
    private String username, password, tipeAkun;
    private int idUser, umur;

    public User(int idUser, String username, String password, int umur, String tipeAkun) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.umur = umur;
        this.tipeAkun = tipeAkun;
    }

    public String getTipeAkun() {
        return tipeAkun;
    }

    public void setTipeAkun(String tipeAkun) {
        this.tipeAkun = tipeAkun;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    } 
}
