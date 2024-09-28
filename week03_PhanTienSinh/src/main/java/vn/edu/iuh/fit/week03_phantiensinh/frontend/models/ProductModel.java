/**
 * @ (#) ProductModel.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.ProductPrice;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
public class ProductModel {
    private final String URL = "http://localhost:8080/week03_PhanTienSinh-1.0-SNAPSHOT/api/products";

    public void createProduct(Product product) {
        try(Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL);

            Response response = target.request().post(Entity.json(product));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Product added successfully");
            } else {
                System.out.println("Failed to add product");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL);
            Response response = target.request().post(Entity.json(product));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Product added successfully");
            } else {
                System.out.println("Failed to add product");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
