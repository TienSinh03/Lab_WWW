/**
 * @ (#) UserService.java      11/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.dtos.UserDto;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
public interface UserService {
    public UserDto getUserByUsernameAndPassword(String username, String password);
}
