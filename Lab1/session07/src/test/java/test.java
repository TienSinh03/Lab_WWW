import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @ (#) test.java      8/31/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 8/31/2024
 */
public class test {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPA_SQL").createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
