package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Matricula;

public class MatriculaController {
    public void insert(Matricula matricula) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(matricula);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Matricula matricula) {
        EntityManager em = ConnectionManager.getGerente();
        Matricula matriculaDelete = em.find(Matricula.class, matricula.getId());
        em.getTransaction().begin();
        em.remove(matriculaDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Matricula matricula) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(matricula);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Matricula> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Matricula> query = em.createNamedQuery("Matricula.getAll", Matricula.class);
        return query.getResultList();
    }
    
    public Matricula findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Matricula matricula = em.find(Matricula.class, id);
        return matricula;
    }
}
