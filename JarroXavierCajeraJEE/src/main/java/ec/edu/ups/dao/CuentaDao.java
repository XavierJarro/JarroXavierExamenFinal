/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Cuenta;
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
public class CuentaDao {

    @PersistenceContext(name = "JarroAguirreCajeraJEEPersistenceUnit")
    private EntityManager em;

    public void insert(Cuenta c) {
        em.persist(c);
    }

    public void update(Cuenta c) {
        em.merge(c);
    }

    public Cuenta read(int codigo) {
        return em.find(Cuenta.class, codigo);
    }

    public void delete(int codigo) {
        Cuenta c = read(codigo);
        em.remove(c);
    }

    public List<Cuenta> getCuentas() {
        String jpql = "SELECT r FROM Cuenta r";
        Query q = em.createQuery(jpql, Cuenta.class);
        return (List<Cuenta>) q.getResultList();
    }

}
