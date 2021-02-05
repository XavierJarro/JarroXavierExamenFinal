/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Starman
 */
@Stateless
public class ClienteDao {
    
    @PersistenceContext(name = "JarroAguirreCajeraJEEPersistenceUnit")
    private EntityManager em;
    
    public void insert(Cliente c) {
        em.persist(c);
    }

    public void update(Cliente c) {
        em.merge(c);
    }

    public Cliente read(String cedulaCliente) {
        return em.find(Cliente.class, cedulaCliente);
    }

    public void delete(String cedulaCliente) {
        Cliente c = read(cedulaCliente);
        em.remove(c);
    }

    public List<Cliente> getClientes() {
        String jpql = "SELECT c FROM Cliente c ";

        Query q = em.createQuery(jpql, Cliente.class);
        return q.getResultList();
    }
}
