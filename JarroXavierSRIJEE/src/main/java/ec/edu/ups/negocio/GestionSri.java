/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.negocio;

import ec.edu.ups.servicios.Respuesta;
import javax.ejb.Stateless;

/**
 *
 * @author Starman
 */
@Stateless
public class GestionSri implements GestionSriLocal {

    public Respuesta aceptarRechazarFactura() {
        Respuesta res = new Respuesta();

        int numero = (int) (Math.random() * 10 + 1);
        if (numero == 0) {
            res.setCodigo(1);
            res.setEstado("aprobado");
        } else {
            res.setCodigo(2);
            res.setEstado("rechazado");
        }

        return res;
    }
}
