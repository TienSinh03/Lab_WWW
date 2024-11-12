/**
 * @ (#) UserRestController.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.repositories.UserRepository;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> showUserALl() {
        return ResponseEntity.ok(userServices.getUsers_NoPaging());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> showUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userServices.getUserById(id));
    }

}
