/**
 * @ (#) RegisterServlet.java      8/30/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edi.iuh.fit.session04;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 8/30/2024
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String url = req.getParameter("facebook");
        String bio = req.getParameter("bio");




        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1 align =\"center\">Register Success</h1>");
        String html="<br>"
                + "<html>"
                + "<head>"
                + "<title>Result Page</title>"
                + "</head>"
                + "<body>"
                + "<h3 align =\"center\">Full Name: "+ lastName + " "+ firstName +"</h3>"
                + "<h3 align =\"center\">Email: "+ email +"<br> Facebook URL: "+ url +"</h3>"
                + "<h3 align =\"center\">Short Bio: "+ bio +"</h3><br>"
                + "</body>"
                + "</html>";
        out.println(html);
    }

}
