/**
 * @ (#) ProductBean.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.business;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
@Stateless
public class ProductBean implements ProductBeanRemote{
    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;

    public ProductBean() {
//        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }

//    public static void main(String[] args) {
//        List<Product> products = new ProductBean().getAll();
//        for (Product product : products) {
//            System.out.println(product);
//        }
//    }
}
