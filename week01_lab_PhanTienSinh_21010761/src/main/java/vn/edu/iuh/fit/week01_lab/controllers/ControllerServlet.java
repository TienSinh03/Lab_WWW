package vn.edu.iuh.fit.week01_lab.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lab.entities.Account;
import vn.edu.iuh.fit.week01_lab.entities.Role;
import vn.edu.iuh.fit.week01_lab.services.AccountServices;
import vn.edu.iuh.fit.week01_lab.services.RoleServices;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", urlPatterns = "/controller-servlet")
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountServices accountServices;

    @Inject
    private RoleServices roleServices;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String account_id = req.getParameter("account_id");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        if (action.equalsIgnoreCase("login")) {
            Role role = roleServices.getRoleByIdAccount(account_id);
            boolean result = accountServices.verifyAccount(account_id, password);
            if (result) {
                if(role.getRole_id().equals("admin")){
                    resp.sendRedirect("dashboard.jsp");
                } else {
                    Account account = accountServices.getInforAccount(account_id);
                    String html = "<html><head><title>Account Information</title></head><body >" +
                            "<a href='index.jsp'>Log out</a >" +
                            "<h1>Account Information</h1 >" +
                            "<p>Account ID: " + account.getAccount_id() + "</p >" +
                            "<p>Full Name: " + account.getFull_name() + "</p >" +
                            "<p>Email: " + account.getEmail() + "</p >" +
                            "<p>Phone: " + account.getPhone() + "</p >" +
                            "<p>Status: " + account.getStatus() + "</p >" +
                            "</body></html >";
                    out.println(html);
                }
            } else {
                req.setAttribute("error", "Login failed!!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                resp.sendRedirect("index.jsp");
            }

        } else if (action.equals("register")) {

        }
    }
}
