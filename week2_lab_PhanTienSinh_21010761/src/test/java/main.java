import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @ (#) main.java      9/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/19/2024
 */
public class main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        EntityTransaction et = em.getTransaction();
    }

}
