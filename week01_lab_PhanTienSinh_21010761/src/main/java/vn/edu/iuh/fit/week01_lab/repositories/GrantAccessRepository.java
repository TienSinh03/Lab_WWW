/**
 * @ (#) GrantAccessRepository.java      9/14/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab.entities.GrantAccess;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/14/2024
 */
public class GrantAccessRepository {
    private EntityManager em;
    private EntityTransaction et;

    public GrantAccessRepository() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public boolean insertGrantAccess(GrantAccess grantAccess) {
        try {
            et.begin();
            em.persist(grantAccess);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(GrantAccess grantAccess) {
        try {
            et.begin();
            em.merge(grantAccess);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean exists(String account_id, String role_id) {
        return em.createNamedQuery("GrantAccess.exists", Boolean.class)
                    .setParameter("account_id", account_id)
                    .setParameter("role_id", role_id)
                    .getSingleResult();

    }
}
