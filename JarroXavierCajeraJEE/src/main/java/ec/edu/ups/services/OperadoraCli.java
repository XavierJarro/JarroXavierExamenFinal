/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Starman
 */
public class OperadoraCli {

    private String WS = "http://localhost:8083/JarroXavierOperadoraJEE/operadora/bo/transferenciaOperadora";

    public String operadora() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(WS);
        String respuesta = target.request().post(Entity.json(null), String.class);
        return respuesta;
    }

}
