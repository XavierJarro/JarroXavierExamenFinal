/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Recarga;
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
public class RecargaDao {

    @PersistenceContext(name = "JarroAguirreCajeraJEEPersistenceUnit")
    private EntityManager em;

    public void insert(Recarga c) {
        em.persist(c);
    }

    public void update(Recarga c) {
        em.merge(c);
    }

    public Recarga read(int codigo) {
        return em.find(Recarga.class, codigo);
    }

    public void delete(int codigo) {
        Recarga c = read(codigo);
        em.remove(c);
    }

    public List<Recarga> getRecargas() {
        String jpql = "SELECT c FROM Recarga c ";

        Query q = em.createQuery(jpql, Recarga.class);
        return (List<Recarga>) q.getResultList();
    }

}
