/**
 * @ (#) ProductBeanRemote.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.business;

import jakarta.ejb.Remote;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
@Remote
public interface ProductBeanRemote {
    void add (Product product);
   List<Product> getAll();
    Product getById(int id);

}
