/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author $arwan
 */
public class User {


    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }
    
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the no_tlp
     */
    public String getNo_tlp() {
        return no_tlp;
    }

    /**
     * @param no_tlp the no_tlp to set
     */
    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }
    
    private int id_user;
    private String nama;
    private String email;
    private String password;
    private String confirm_password;
    private String no_tlp;
}
