package vn.edu.iuh.fit.week01_lab.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab.entities.Role;

import java.util.List;

public class RoleRepository {
    private EntityManager em;
    private EntityTransaction et;

    public RoleRepository() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public List<Role> findAllRoles() {
        try {
            return em.createNamedQuery("Role.findAll", Role.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Role getRoleByIdAccount(String account_id) {
        try {
            return em.createNamedQuery("Role.findRoleByIdAccount", Role.class)
                    .setParameter("account_id", account_id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
