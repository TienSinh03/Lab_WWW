package vn.edu.iuh.fit.session01.beans;

import vn.edu.iuh.fit.session01.dao.DaoLogin;
import vn.edu.iuh.fit.session01.dao.impl.LoginDaoImpl;
import vn.edu.iuh.fit.session01.entity.User;

public class CheckLogin {
    public boolean checkLogin(String email, String pw) {
        DaoLogin daoLogin = new LoginDaoImpl();
        User user = daoLogin.getLogin(email);
        if (user != null) {
            return user.getEmail().equals(email) && user.getPassword().equals(pw);
        }
        return false;
    }
}
