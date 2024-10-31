/**
 * @ (#) ProductRepository.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.repositories;

import vn.edu.iuh.fit.week2_phantiensinh.models.Product;

import java.util.List;
import java.util.Map;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
public interface ProductRepository {
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(long id);
    public Product getProduct(long id);
    public List<Product> getAll();
    public double getPriceProduct(long id);
    public void addCart(Product product, int quantity);
    public Map<Product, Integer> getCarts();
}
