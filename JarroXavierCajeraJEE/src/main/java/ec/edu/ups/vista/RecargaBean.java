/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Cuenta;
import ec.edu.ups.modelo.Recarga;
import ec.edu.ups.negocio.GestionRecargaLocal;
import ec.edu.ups.services.OperadoraCli;
import ec.edu.ups.services.SriCli;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Starman
 */
@ManagedBean
@SessionScoped
public class RecargaBean {

    @Inject
    private GestionRecargaLocal on;
    private Recarga recarga;
    private String numeroCuenta;
    private String numeroCelular;
    private String valor;
    private Cuenta cuenta;

    @PostConstruct
    private void iniciar() {
        recarga = new Recarga();
        cuenta = new Cuenta();
        recarga.setEstado("aprobado");
    }

    public RecargaBean() {
        iniciar();
    }

    public Recarga getRecarga() {
        return recarga;
    }

    public void setRecarga(Recarga recarga) {
        this.recarga = recarga;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String crearRecarga() {
        try {
            recarga.setCodigo(on.codigoRecarga());
            cuenta = on.buscarCuenta(numeroCuenta);
            if (cuenta != null) {
                recarga.setCuenta(cuenta);
                recarga.setNumerCelular(numeroCelular);
                recarga.setValorRecarga(Double.parseDouble(valor));
                on.crearRecarga(recarga);

                recarga = new Recarga();
                cuenta = new Cuenta();
                try {
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("Recarga.xhtml");
                } catch (Exception t) {

                }
            } else {
                try {
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("CrearCliente.xhtml");
                } catch (Exception t) {

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        OperadoraCli operadora = new OperadoraCli();
        SriCli sri = new SriCli();

        System.out.println(operadora.operadora());
        System.out.println(sri.sri());

        return null;
    }
}
