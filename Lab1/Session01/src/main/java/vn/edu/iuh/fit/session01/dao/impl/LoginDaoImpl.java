package vn.edu.iuh.fit.session01.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.session01.dao.DaoLogin;
import vn.edu.iuh.fit.session01.entity.User;

public class LoginDaoImpl implements DaoLogin {
    private EntityManager em;
    private EntityTransaction tx;

    public LoginDaoImpl() {
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public boolean insertLogin(User user) {
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getLogin(String username) {
        return em.find(User.class, username);
    }
}
