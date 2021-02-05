/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicios;

import ec.edu.ups.negocio.GestionSriLocal;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Starman
 */
@Path("/bs")
public class ServicioRecargaRest {

    @Inject
    private GestionSriLocal on;

    @GET
    @Path("/transferenciaSri")
    @Produces("application/json")
    public Respuesta transferenciaSri() {
        return on.aceptarRechazarFactura();
    }
    

}
