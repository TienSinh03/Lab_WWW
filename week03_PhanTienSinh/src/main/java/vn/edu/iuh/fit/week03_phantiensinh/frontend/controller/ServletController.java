/**
 * @ (#) ServletController.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.frontend.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;
import vn.edu.iuh.fit.week03_phantiensinh.frontend.models.ProductModel;

import java.io.IOException;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
@WebServlet(name="ServletController", value = "/controller")
public class ServletController extends HttpServlet {

    @Inject
    private ProductModel productModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("add")){
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String img_path = req.getParameter("img_path");

            Product product = new Product(name, description, img_path);
            productModel.createProduct(product);
            resp.sendRedirect("formProduct.jsp");
        }
    }
}
