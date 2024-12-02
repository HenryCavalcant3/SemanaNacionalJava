package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Evento;

public class EventoController {
    public void insert(Evento evento) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Evento evento) {
        EntityManager em = ConnectionManager.getGerente();
        Evento eventoDelete = em.find(Evento.class, evento.getId());
        em.getTransaction().begin();
        em.remove(eventoDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Evento evento) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(evento);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Evento> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Evento> query = em.createNamedQuery("Evento.getAll", Evento.class);
        return query.getResultList();
    }
    
    public Evento findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Evento evento = em.find(Evento.class, id);
        return evento;
    }
}
