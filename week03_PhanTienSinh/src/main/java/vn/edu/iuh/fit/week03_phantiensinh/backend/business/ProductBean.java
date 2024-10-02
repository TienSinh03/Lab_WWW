/**
 * @ (#) ProductBean.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.business;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_phantiensinh.backend.dtos.ProductDTO;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;

import java.util.ArrayList;
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

    @Inject
    private ProductRepository productRepository;

    @Inject
    private ProductPriceRepository productPriceRepository;

    public ProductBean() {
//        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public List<ProductDTO> getAllDTO() {
        List<Product> products = productRepository.getAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            double price = productPriceRepository.getPriceProduct(product.getId());

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setDescription(product.getDescription());
            productDTO.setImgPath(product.getImgPath());
            productDTO.setName(product.getName());
            productDTO.setPrice(price);

            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    @Override
    public ProductDTO getById_DTO(int id) {
        Product product = productRepository.getById(id);
        double price = productPriceRepository.getPriceProduct(product.getId());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setImgPath(product.getImgPath());
        productDTO.setName(product.getName());
        productDTO.setPrice(price);
        return productDTO;
    }


//    public static void main(String[] args) {
//        List<Product> products = new ProductBean().getAll();
//        for (Product product : products) {
//            System.out.println(product);
//        }
//    }
}
