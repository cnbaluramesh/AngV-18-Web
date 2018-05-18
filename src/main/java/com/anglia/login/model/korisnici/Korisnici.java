package com.anglia.login.model.korisnici;

import com.anglia.login.model.autorizacija.Autorizacija;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "korisnici")
public class Korisnici implements Serializable {

    @Id
    @Column(name = "korisnici_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int korisniciId;

    @Column(name = "prezime_ime")
    @NotBlank(message = "polje ne smije biti prazno")
    private String prezimeIme;

    @Column(name = "username")
    @NotBlank(message = "polje ne smije biti prazno")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "polje ne smije biti prazno")
    private String password;

    @OneToOne()
    @JoinColumn(name = "autorizacija_id")
    private Autorizacija autorizacija;

    /**
     * Prazan konstruktor objekta
     */
    public Korisnici() {
    }

    /**
     * Konstruktor objekta sa ulaznim parametrima
     *
     * @param prezimeIme
     * @param username
     * @param password
     * @param autorizacija
     */
    public Korisnici(String prezimeIme, String username, String password, Autorizacija autorizacija) {
        this.prezimeIme = prezimeIme;
        this.username = username;
        this.password = password;
        this.autorizacija = autorizacija;
    }

    public int getKorisniciId() {
        return korisniciId;
    }

    public void setKorisniciId(int korisniciId) {
        this.korisniciId = korisniciId;
    }

    public String getPrezimeIme() {
        return prezimeIme;
    }

    public void setPrezimeIme(String prezimeIme) {
        this.prezimeIme = prezimeIme;
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

    public Autorizacija getAutorizacija() {
        return autorizacija;
    }

    public void setAutorizacija(Autorizacija autorizacija) {
        this.autorizacija = autorizacija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Korisnici)) return false;
        Korisnici korisnici = (Korisnici) o;
        return getKorisniciId() == korisnici.getKorisniciId() &&
                Objects.equals(getPrezimeIme(), korisnici.getPrezimeIme()) &&
                Objects.equals(getUsername(), korisnici.getUsername()) &&
                Objects.equals(getPassword(), korisnici.getPassword()) &&
                Objects.equals(getAutorizacija(), korisnici.getAutorizacija());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKorisniciId(), getPrezimeIme(), getUsername(), getPassword(), getAutorizacija());
    }

    @Override
    public String toString() {
        return "Korisnici{" +
                "korisniciId=" + korisniciId +
                ", prezimeIme='" + prezimeIme + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", autorizacija=" + autorizacija +
                '}';
    }

    /**
     * Metod koji provjerava da li korisnik ima ID
     *
     * @return TRUE/FALSE ukoliko korisnik ima setovan ID
     */
    public boolean isKorisnikSet(){
        if(getKorisniciId() != 0){
            return true;
        }else{
            return false;
        }
    }
}
