/**
 * @ (#) UserServicesImpl.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.mapper.UserMapper;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.UserRepository;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserDTO> getUsers_NoPaging() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDTO).toList();
    }

    @Override
    public Page<UserDTO> getUsers_Paging(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return (Page<UserDTO>) userRepository.findAll(pageable).stream().map(userMapper::toDTO).toList();
    }
}
