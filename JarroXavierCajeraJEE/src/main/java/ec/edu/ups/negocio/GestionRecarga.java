/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.negocio;

import ec.edu.ups.dao.ClienteDao;
import ec.edu.ups.dao.CuentaDao;
import ec.edu.ups.dao.RecargaDao;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Cuenta;
import ec.edu.ups.modelo.Recarga;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Starman
 */
@Stateless
public class GestionRecarga implements GestionRecargaLocal {

    @Inject
    private ClienteDao clienteDao;

    @Inject
    private CuentaDao cuentaDao;

    @Inject
    private RecargaDao recargaDao;

    public void guardarCliente(Cliente c) {
        clienteDao.insert(c);
    }

    public void guardarCuentaDeAhorros(Cuenta c) {
        cuentaDao.insert(c);
    }

    public void crearRecarga(Recarga c) {
        recargaDao.insert(c);
    }

    public Cuenta buscarCuenta(String numero) {
        Cuenta cue = new Cuenta();
        for (Cuenta c : cuentaDao.getCuentas()) {
            if (c.getNumeroCuenta() == numero) {
                System.out.println(c.getNumeroCuenta());
                cue = c;
            }
        }
        return cue;
    }

    public int codigoRecarga() {
        int codigo = 0;
        codigo = recargaDao.getRecargas().size() + 1;
        return codigo;
    }

}
