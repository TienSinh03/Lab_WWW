/**
 * @ (#) AppController.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.time.Instant;
import java.util.Random;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/form-login")
    public String showFormLogin(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/do-login")
    public String login(HttpSession session , @ModelAttribute("user") UserDTO user) {
        UserDTO userDTO = userServices.findByEmailAndPassword(user.getEmail(), user.getPasswordHash());
        System.out.println(userDTO);
        if (userDTO != null) {
            session.setAttribute("userLogin", userDTO);
            return "redirect:/post/home";
        }
        return "redirect:/form-login";
    }

    @GetMapping("/form-register")
    public String showFormRegister(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/do-register")
    public String register(@ModelAttribute("user") UserDTO user) {
        Random rd = new Random();
        user.setRegisteredAt(Instant.now().minusSeconds(rd.nextInt(365 * 24 * 60 * 60)));
        userServices.save(user);
        return "redirect:/form-login";
    }

}
