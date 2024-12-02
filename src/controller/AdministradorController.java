package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Administrador;

public class AdministradorController {
    public void insert(Administrador administrador) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(administrador);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Administrador administrador) {
        EntityManager em = ConnectionManager.getGerente();
        Administrador administradorDelete = em.find(Administrador.class, administrador.getId());
        em.getTransaction().begin();
        em.remove(administradorDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Administrador administrador) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(administrador);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Administrador> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Administrador> query = em.createNamedQuery("Administrador.getAll", Administrador.class);
        return query.getResultList();
    }
    
    public Administrador findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Administrador administrador = em.find(Administrador.class, id);
        return administrador;
    }
    
    public Administrador getByLogin(String login, String senha) {
        EntityManager gerente = ConnectionManager.getGerente();
        TypedQuery<Administrador> consulta =  gerente.createNamedQuery("Administrador.getByLogin", Administrador.class);
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        try {
            return consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
