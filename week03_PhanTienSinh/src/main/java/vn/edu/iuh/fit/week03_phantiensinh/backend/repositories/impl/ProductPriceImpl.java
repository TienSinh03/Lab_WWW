/**
 * @ (#) ProductPriceImpl.java      10/2/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.ProductPrice;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/2/2024
 */
public class ProductPriceImpl implements ProductPriceRepository {
//    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;

    public ProductPriceImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPADemo_MariaDB").createEntityManager();
    }

    @Override
    public double getPriceProduct(int id) {
//        ProductPrice productPrice = entityManager.createNamedQuery("ProductPrice.findByProducts_Id", ProductPrice.class).setParameter("id", id).getSingleResult();
//        return productPrice.getValue();
        String sql = "SELECT pp.*\n" +
                "FROM product_price pp\n" +
                "JOIN product p ON pp.price_id = p.price_id\n" +
                "WHERE p.product_id = ?;";

        ProductPrice productPrice = (ProductPrice) entityManager.createNativeQuery(sql, ProductPrice.class).setParameter(1, id).getSingleResult();
        return productPrice.getValue();
    }

    public static void main(String[] args) {
        ProductPriceImpl productPrice = new ProductPriceImpl();
        System.out.println(productPrice.getPriceProduct(1));
    }
}
