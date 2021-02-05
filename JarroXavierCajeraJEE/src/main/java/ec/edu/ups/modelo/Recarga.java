/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Starman
 */
@Entity
public class Recarga implements Serializable {

    @Id
    private int codigo;
    @OneToOne
    @JoinColumn(name = "numero_cuenta")
    private Cuenta cuenta;
    private String numerCelular;
    private double valorRecarga;
    private String estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNumerCelular() {
        return numerCelular;
    }

    public void setNumerCelular(String numerCelular) {
        this.numerCelular = numerCelular;
    }

    public double getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(double valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
