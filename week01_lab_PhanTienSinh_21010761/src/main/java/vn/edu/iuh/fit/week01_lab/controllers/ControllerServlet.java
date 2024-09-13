package vn.edu.iuh.fit.week01_lab.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01_lab.entities.Account;
import vn.edu.iuh.fit.week01_lab.entities.Role;
import vn.edu.iuh.fit.week01_lab.services.AccountServices;
import vn.edu.iuh.fit.week01_lab.services.RoleServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/controller-servlet")
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountServices accountServices;

    @Inject
    private RoleServices roleServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
       if (action.equalsIgnoreCase("add")) {
           session.setAttribute("account", new Account());
            req.getRequestDispatcher("formAccount.jsp").forward(req, resp);

       } else if (action.equalsIgnoreCase("edit")) {
           String account_id = req.getParameter("id");

           Account account = accountServices.getInforAccount(account_id);
           session.setAttribute("account", account);
           req.getRequestDispatcher("formAccount.jsp").forward(req, resp);
       } else if (action.equalsIgnoreCase("delete")) {
           String account_id = req.getParameter("id");
           Account account = accountServices.getInforAccount(account_id);
           if (accountServices.deleteAccount(account)) {
               resp.sendRedirect("dashboard.jsp");
           } else {
               req.setAttribute("error", "Delete account failed!!");
               req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
           }
       } else if(action.equals("searchAccountByRole")) {
           String roleId = req.getParameter("selectRoleId");
           List<Account> accounts;
           System.out.println(roleId);
           if(roleId == null || roleId.equals("0")) {
               accounts = accountServices.getAllInforAccount();
           } else {
                accounts = accountServices.getAllAccountByRole(roleId);
           }
           session.setAttribute("accounts", accounts);
              req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (action.equalsIgnoreCase("login")) {
            String account_id = req.getParameter("account_id");
            String password = req.getParameter("password");
            Role role = roleServices.getRoleByIdAccount(account_id);
            boolean result = accountServices.verifyAccount(account_id, password);
            if (result) {
                if(role.getRole_id().equals("admin")){
                    req.getServletContext().setAttribute("account", accountServices.getInforAccount(account_id));
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                    resp.sendRedirect("dashboard.jsp");
                } else {
                    Account account = accountServices.getInforAccount(account_id);
                    String html = "<html><head><title>Account Information</title></head><body >" +
                            "<a href='login.jsp'>Log out</a >" +
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
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                resp.sendRedirect("login.jsp");
            }

        } else if (action.equalsIgnoreCase("add")) {
            String accountID = req.getParameter("account_id");
            String fullName = req.getParameter("full_name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String status = req.getParameter("status");
            Account account = new Account(accountID, fullName, password, email, phone, Integer.parseInt(status));

            if (accountServices.insertAccount(account)) {
                resp.sendRedirect("dashboard.jsp");
            } else {
                req.setAttribute("error", "Insert account failed!!");
                req.getRequestDispatcher("formAccount.jsp").forward(req, resp);
            }
        } else if(action.equalsIgnoreCase("edit")) {
            String accountID = req.getParameter("account_id");
            String fullName = req.getParameter("full_name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String status = req.getParameter("status");
            Account account = new Account(accountID, fullName, password, email, phone, Integer.parseInt(status));

            if (accountServices.updateAccount(account)) {
                resp.sendRedirect("dashboard.jsp");
            } else {
                req.setAttribute("error", "Update account failed!!");
                req.getRequestDispatcher("formAccount.jsp").forward(req, resp);
            }
        }
    }
}
