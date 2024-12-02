package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Participante;

public class ParticipanteController {
    public void insert(Participante participante) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.persist(participante);
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Participante participante) {
        EntityManager em = ConnectionManager.getGerente();
        Participante participanteDelete = em.find(Participante.class, participante.getId());
        em.getTransaction().begin();
        em.remove(participanteDelete);
        em.getTransaction().commit();
        em.close();
    }
    
    public void edit(Participante participante) {
        EntityManager em = ConnectionManager.getGerente();
        em.getTransaction().begin();
        em.merge(participante);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Participante> getAll() {
        EntityManager em = ConnectionManager.getGerente();
        TypedQuery<Participante> query = em.createNamedQuery("Participante.getAll", Participante.class);
        return query.getResultList();
    }
    
    public Participante findById(int id) {
        EntityManager em = ConnectionManager.getGerente();
        Participante participante = em.find(Participante.class, id);
        return participante;
    }
    
    public Participante getByLogin(String login, String senha) {
        EntityManager gerente = ConnectionManager.getGerente();
        TypedQuery<Participante> consulta =  gerente.createNamedQuery("Participante.getByLogin", Participante.class);
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        try {
            return consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Participante> getByNome(String nome) {
        EntityManager gerente = ConnectionManager.getGerente();
        TypedQuery<Participante> consulta =  gerente.createNamedQuery("Participante.getByNome", Participante.class);
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
}
