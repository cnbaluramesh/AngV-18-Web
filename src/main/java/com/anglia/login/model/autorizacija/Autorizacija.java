package com.anglia.login.model.autorizacija;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "autorizacija")
public class Autorizacija implements Serializable {
    @Id
    @Column(name = "autorizacija_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autorizacijaId;

    @Column(name = "ime_pozicije")
    @NotBlank(message = "polje nesmije biti prazno")
    private String imePozicije;

    @Column(name = "nivo_autorizacije")
    @NotNull(message = "polje nesmije biti prazno")
    private int nivoAutorizacije;

    /**
     * Prazan konstruktor objekta
     */
    public Autorizacija() {
    }

    /**
     * Konstruktor objekta sa ulaznim parametrima
     *
     * @param imePozicije
     * @param nivoAutorizacije
     */
    public Autorizacija(String imePozicije, int nivoAutorizacije) {
        this.imePozicije = imePozicije;
        this.nivoAutorizacije = nivoAutorizacije;
    }

    public int getAutorizacijaId() {
        return autorizacijaId;
    }

    public void setAutorizacijaId(int autorizacijaId) {
        this.autorizacijaId = autorizacijaId;
    }

    public String getImePozicije() {
        return imePozicije;
    }

    public void setImePozicije(String imePozicije) {
        this.imePozicije = imePozicije;
    }

    public int getNivoAutorizacije() {
        return nivoAutorizacije;
    }

    public void setNivoAutorizacije(int nivoAutorizacije) {
        this.nivoAutorizacije = nivoAutorizacije;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autorizacija)) return false;
        Autorizacija that = (Autorizacija) o;
        return getAutorizacijaId() == that.getAutorizacijaId() &&
                getNivoAutorizacije() == that.getNivoAutorizacije() &&
                Objects.equals(getImePozicije(), that.getImePozicije());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAutorizacijaId(), getImePozicije(), getNivoAutorizacije());
    }

    @Override
    public String toString() {
        return "Autorizacija{" +
                "autorizacijaId=" + autorizacijaId +
                ", imePozicije='" + imePozicije + '\'' +
                ", nivoAutorizacije=" + nivoAutorizacije +
                '}';
    }

    public boolean isAutorizacijaSet(){
        if(getAutorizacijaId() != 0)
            return true;
        return false;
    }
}
