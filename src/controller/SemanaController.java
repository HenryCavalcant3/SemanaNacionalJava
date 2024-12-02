package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Semana;

public class SemanaController {
    public void insert(Semana semana) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(semana);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Semana semana) {
        EntityManager em = ConnectionManager.getGerente();
        Semana semanaDelete = em.find(Semana.class, semana.getId());
        em.getTransaction().begin();
        em.remove(semanaDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Semana semana) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(semana);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Semana> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Semana> query = em.createNamedQuery("Semana.getAll", Semana.class);
        return query.getResultList();
    }
    
    public Semana findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Semana semana = em.find(Semana.class, id);
        return semana;
    }
    
    public List<Semana> getByNome(String nome) {
        EntityManager gerente = ConnectionManager.getGerente();
        TypedQuery<Semana> consulta =  gerente.createNamedQuery("Semana.getByNome", Semana.class);
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
}
