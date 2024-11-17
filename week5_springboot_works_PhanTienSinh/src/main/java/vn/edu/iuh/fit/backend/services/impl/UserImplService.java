/**
 * @ (#) UserImplService.java      11/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.UserDto;
import vn.edu.iuh.fit.backend.mapper.UserMapper;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.IUserRepository;
import vn.edu.iuh.fit.backend.services.UserService;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/18/2024
 */
@Service
public class UserImplService implements UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password).orElse(null);
        System.out.println(user);
        if (user == null) {
            return null;
        }
        return userMapper.toDto(user);

    }
}
