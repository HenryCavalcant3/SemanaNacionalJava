package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Curso;

public class CursoController {
    public void insert(Curso curso) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Curso curso) {
        EntityManager em = ConnectionManager.getGerente();
        Curso cursoDelete = em.find(Curso.class, curso.getId());
        em.getTransaction().begin();
        em.remove(cursoDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Curso curso) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Curso> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Curso> query = em.createNamedQuery("Curso.getAll", Curso.class);
        return query.getResultList();
    }
    
    public Curso findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Curso curso = em.find(Curso.class, id);
        return curso;
    }
    
    public List<Curso> getByNome(String nome) {
        EntityManager gerente = ConnectionManager.getGerente();
        TypedQuery<Curso> consulta =  gerente.createNamedQuery("Curso.getByNome", Curso.class);
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
}
