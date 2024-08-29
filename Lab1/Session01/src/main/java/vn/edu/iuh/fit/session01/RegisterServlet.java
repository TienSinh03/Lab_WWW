/**
 * @ (#) RegisterServlet.java      8/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.session01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.session01.beans.HandleRegister;
import vn.edu.iuh.fit.session01.entity.User;

import java.io.IOException;
import java.io.PrintWriter;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 8/24/2024
 */
@WebServlet(name="RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email, password, firstName, lastName);
        HandleRegister handleInsert = new HandleRegister();
        boolean handle = handleInsert.insert(user);
        PrintWriter out = resp.getWriter();
        if(handle) {
            resp.sendRedirect("login.html");
        } else {
            out.println("<h1 align =\"center\">Register Failed</h1>");
        }


    }
}
