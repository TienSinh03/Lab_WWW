/**
 * @ (#) HandleRegister.java      8/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.session01.beans;

import vn.edu.iuh.fit.session01.dao.DaoLogin;
import vn.edu.iuh.fit.session01.dao.impl.LoginDaoImpl;
import vn.edu.iuh.fit.session01.entity.User;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 8/24/2024
 */
public class HandleRegister {
    public boolean insert(User user) {
        DaoLogin dao = new LoginDaoImpl();
        if (user!=null) {
            dao.insertLogin(user);
            return true;
        }
        return false;
    }
}
