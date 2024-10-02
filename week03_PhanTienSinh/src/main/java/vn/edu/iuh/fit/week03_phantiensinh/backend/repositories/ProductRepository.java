/**
 * @ (#) ProductRepository.java      10/2/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.repositories;

import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/2/2024
 */
public interface ProductRepository {
    public List<Product> getAll();
    public Product getById(int id);
}
