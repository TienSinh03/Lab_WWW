/**
 * @ (#) RoleRepositoryImpl.java      10/23/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Role;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/23/2024
 */
public class RoleRepositoryImpl implements vn.edu.iuh.fit.repositories.RoleRepository {
    private EntityManager em;
    private EntityTransaction et;

    public RoleRepositoryImpl() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }
    @Override
    public Role findRoleByAccount(String account_id) {
        String query = "select r from Role r join GrantAccess ga on r.role_id = ga.role.id where ga.account.id = :account_id";
        try {
            return em.createQuery(query, Role.class)
                    .setParameter("account_id", account_id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
