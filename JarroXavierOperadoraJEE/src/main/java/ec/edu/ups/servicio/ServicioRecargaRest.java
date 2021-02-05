/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicio;

import ec.edu.ups.negocio.GestionOperadoraLocal;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Starman
 */
@Path("/bo")
public class ServicioRecargaRest {

    @Inject
    private GestionOperadoraLocal on;

    @POST
    @Path("/transferenciaOperadora")
    @Produces("application/json")
    @Consumes("application/json")
    public Respuesta transferenciaOperadora() {
        return on.aceptarRechazarRecarga();
    }

}
