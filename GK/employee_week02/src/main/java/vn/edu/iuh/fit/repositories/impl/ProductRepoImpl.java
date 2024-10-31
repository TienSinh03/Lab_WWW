/**
 * @ (#) ProductRepoImpl.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week2_phantiensinh.models.Product;
import vn.edu.iuh.fit.week2_phantiensinh.repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
public class ProductRepoImpl implements ProductRepository {

    private EntityManager em;
    private EntityTransaction et;
    private Map<Product, Integer> carts = new HashMap<>();

    public ProductRepoImpl() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            et.begin();
            em.persist(product);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        try {
            et.begin();
            em.merge(product);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(long id) {
        return false;
    }

    @Override
    public Product getProduct(long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> getAll() {
        try {
            return em.createNamedQuery("Product.findAll", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getPriceProduct(long id) {
        Product product = em.find(Product.class, id);
        return em.createNamedQuery("Product.getPrice", Double.class).setParameter("id", id).getSingleResult();
    }

    public void addCart(Product product, int quantity) {
        // Nếu sản phẩm đã có trong giỏ hàng, cập nhật số lượng
        if (carts.containsKey(product)) {
            carts.put(product, carts.get(product) + quantity);
        } else {
            // Nếu sản phẩm chưa có trong giỏ hàng, thêm nó vào với số lượng ban đầu
            carts.put(product, quantity);
        }
    }

    public Map<Product, Integer> getCarts() {
        return carts;
    }

public static void main(String[] args) {
    ProductRepoImpl productRepo = new ProductRepoImpl();
    double price = productRepo.getPriceProduct(1);
    System.out.println("Price: " + price);
}
}
