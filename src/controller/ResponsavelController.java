package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Responsavel;

public class ResponsavelController {
    public void insert(Responsavel responsavel) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(responsavel);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Responsavel responsavel) {
        EntityManager em = ConnectionManager.getGerente();
        Responsavel responsavelDelete = em.find(Responsavel.class, responsavel.getId());
        em.getTransaction().begin();
        em.remove(responsavelDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Responsavel responsavel) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(responsavel);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Responsavel> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Responsavel> query = em.createNamedQuery("Responsavel.getAll", Responsavel.class);
        return query.getResultList();
    }
    
    public Responsavel findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Responsavel responsavel = em.find(Responsavel.class, id);
        return responsavel;
    }
}
