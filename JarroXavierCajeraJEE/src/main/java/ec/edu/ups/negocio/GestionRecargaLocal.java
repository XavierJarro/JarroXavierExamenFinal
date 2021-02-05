/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.negocio;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Cuenta;
import ec.edu.ups.modelo.Recarga;
import javax.ejb.Local;

/**
 *
 * @author Starman
 */
@Local
public interface GestionRecargaLocal {

    public void guardarCliente(Cliente c);

    public void guardarCuentaDeAhorros(Cuenta c);

    public void crearRecarga(Recarga c);

    public Cuenta buscarCuenta(String numero);
    
    public int codigoRecarga();
}
