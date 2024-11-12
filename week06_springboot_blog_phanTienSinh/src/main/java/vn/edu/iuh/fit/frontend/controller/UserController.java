/**
 * @ (#) UserController.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.services.UserServices;
import vn.edu.iuh.fit.frontend.model.UserModel;

import java.time.Instant;
import java.util.Random;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userLogin")
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserModel userModel;

    @GetMapping("/profile")
    public String showUserList(Model model, @RequestParam("id") Long id) {
        UserDTO user = userModel.getUserById(id);
        model.addAttribute("user", user);
        return "user/profile-user";
    }

}
