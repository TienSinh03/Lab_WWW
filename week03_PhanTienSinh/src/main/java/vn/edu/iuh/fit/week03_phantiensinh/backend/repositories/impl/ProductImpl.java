/**
 * @ (#) ProductImpl.java      10/2/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/2/2024
 */
public class ProductImpl implements ProductRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;


    @Override
    public List<Product> getAll() {
        return entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }
}
