package vn.edu.iuh.fit.week01_lab.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab.entities.Log;

public class LogRepository {

    private EntityManager em;
    private EntityTransaction et;

    public LogRepository() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public boolean insertLog(Log log) {
        try {
            et.begin();
            em.persist(log);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

}
