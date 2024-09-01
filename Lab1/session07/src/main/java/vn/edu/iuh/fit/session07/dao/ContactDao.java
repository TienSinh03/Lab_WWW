/**
 * @ (#) ContactDao.java      9/1/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.session07.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import vn.edu.iuh.fit.session07.entities.Contact;

import java.sql.Blob;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/1/2024
 */
public class ContactDao {
    private EntityManager em;
    private EntityTransaction tx;

    public ContactDao() {
        em = Persistence.createEntityManagerFactory("JPA_SQL").createEntityManager();
        tx = em.getTransaction();
    }

    /**
     * Insert contact to database
     * @param contact input contact
     * @return true if insert success, false if insert fail
     */
    public boolean insert(Contact contact) {
        // insert contact to database
        String jpql = "INSERT INTO contacts (first_name, last_name, photo) VALUES (?, ?, ?)";
        try {
            tx.begin();
            em.createNativeQuery(jpql)
                    .setParameter(1, contact.getFirstName())
                    .setParameter(2, contact.getLastName())
                    .setParameter(3, contact.getImage())
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return false;
    }

    /**
     * Get image by full name
     * @param firstName input find by first name
     * @param lastName input find by first name
     * @return byte[] image
     */
    public byte[] getImageByFullName(String firstName, String lastName) {
        String jpql = "SELECT c.image FROM Contact c WHERE c.firstName = :firstName AND c.lastName = :lastName";
        return em.createQuery(jpql, byte[].class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName).getSingleResult();

    }

}
