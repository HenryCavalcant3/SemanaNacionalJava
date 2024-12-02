package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Presenca;

public class PresencaController {
    public void insert(Presenca presenca) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(presenca);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Presenca presenca) {
        EntityManager em = ConnectionManager.getGerente();
        Presenca presencaDelete = em.find(Presenca.class, presenca.getId());
        em.getTransaction().begin();
        em.remove(presencaDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Presenca presenca) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(presenca);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Presenca> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Presenca> query = em.createNamedQuery("Presenca.getAll", Presenca.class);
        return query.getResultList();
    }
    
    public Presenca findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Presenca presenca = em.find(Presenca.class, id);
        return presenca;
    }
}
