/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Cuenta;
import ec.edu.ups.negocio.GestionRecarga;
import ec.edu.ups.negocio.GestionRecargaLocal;
import java.util.Date;
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
public class ClienteBean {

    @Inject
    private GestionRecargaLocal on;
    private Cliente cliente;
    private String numeroCuenta;
    private String saldoCuenta;
    private Cuenta cuentaDeAhorro;

    @PostConstruct
    private void iniciar() {
        cliente = new Cliente();
        cuentaDeAhorro = new Cuenta();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(String saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public Cuenta getCuentaDeAhorro() {
        return cuentaDeAhorro;
    }

    public void setCuentaDeAhorro(Cuenta cuentaDeAhorro) {
        this.cuentaDeAhorro = cuentaDeAhorro;
    }

    public String crearCliente() {
        try {

            on.guardarCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String crearCuenta() {
        try {
            cuentaDeAhorro.setNumeroCuenta(numeroCuenta);
            cuentaDeAhorro.setCliente(cliente);
            cuentaDeAhorro.setSaldo(Double.parseDouble(saldoCuenta));
            on.guardarCuentaDeAhorros(cuentaDeAhorro);
            cliente = new Cliente();
            try {
                FacesContext contex = FacesContext.getCurrentInstance();
                contex.getExternalContext().redirect("CrearCliente.xhtml");
            } catch (Exception t) {

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
