package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Organizador;

public class OrganizadorController {
    public void insert(Organizador organizador) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(organizador);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Organizador organizador) {
        EntityManager em = ConnectionManager.getGerente();
        Organizador organizadorDelete = em.find(Organizador.class, organizador.getId());
        em.getTransaction().begin();
        em.remove(organizadorDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Organizador organizador) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(organizador);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Organizador> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Organizador> query = em.createNamedQuery("Organizador.getAll", Organizador.class);
        return query.getResultList();
    }
    
    public Organizador findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Organizador organizador = em.find(Organizador.class, id);
        return organizador;
    }
}
