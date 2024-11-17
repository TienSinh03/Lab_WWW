/**
 * @ (#) HomeController.java      11/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.CompanyDto;
import vn.edu.iuh.fit.backend.dtos.UserDto;
import vn.edu.iuh.fit.backend.services.CompanyService;
import vn.edu.iuh.fit.backend.services.UserService;
import vn.edu.iuh.fit.frontend.models.CompanyModels;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
@Controller
@RequestMapping("/")
@SessionAttributes("userLogin")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyModels companyModels;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/login")
    public String showFormLogin(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/do-login")
    public String login(HttpSession session , @ModelAttribute("user") UserDto user) {
        UserDto userDTO = userService.getUserByUsernameAndPassword(user.getUsername().trim(), user.getPassword().trim());
        System.out.println("hello"+userDTO);
        if (userDTO != null) {
            session.setAttribute("userLogin", userDTO);
            if(userDTO.getRoles().get(0).getCode().equals("COMPANY")) {
                return "redirect:/dashboard";
            }else if(userDTO.getRoles().get(0).getCode().equals("USER")) {
                return "";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String showFormRegister(HttpSession session,Model model) {
        UserDto user = (UserDto) session.getAttribute("userLogin");
        CompanyDto company = companyModels.getCompanyById(user.getId());
        model.addAttribute("user", company);
        return "admin";
    }
}
