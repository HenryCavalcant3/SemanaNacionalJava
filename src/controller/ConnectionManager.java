package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getFabrica() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("SemanaPU");
        return emf;
    }
    
    public static EntityManager getGerente() {
        return getFabrica().createEntityManager();
    }
}