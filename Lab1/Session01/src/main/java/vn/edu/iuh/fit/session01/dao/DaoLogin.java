package vn.edu.iuh.fit.session01.dao;

import vn.edu.iuh.fit.session01.entity.User;

public interface DaoLogin {
    public boolean insertLogin(User user) ;
    public User getLogin(String username);
}
