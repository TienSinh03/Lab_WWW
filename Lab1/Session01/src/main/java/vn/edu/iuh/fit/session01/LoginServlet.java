package vn.edu.iuh.fit.session01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.session01.beans.CheckLogin;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us = req.getParameter("username");
        String pw = req.getParameter("password");

        CheckLogin checkLogin = new CheckLogin();
        boolean result = checkLogin.checkLogin(us, pw);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        if(result){
            out.println("<h1>Chúc mừng bạn đã đăng nhập thành công!</h1>");
        } else {
            out.println("<h1>Đăng nhập thất bại!</h1>");
        }
    }
}
