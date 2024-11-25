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
import vn.edu.iuh.fit.backend.dtos.*;
import vn.edu.iuh.fit.backend.services.CandidateServices;
import vn.edu.iuh.fit.backend.services.CompanyService;
import vn.edu.iuh.fit.backend.services.UserService;
import vn.edu.iuh.fit.frontend.models.CandidateModels;
import vn.edu.iuh.fit.frontend.models.CompanyModels;
import vn.edu.iuh.fit.frontend.models.JobModels;

import java.util.List;

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
    private CandidateModels candidateModels;

    @Autowired
    private JobModels jobModels;

    @GetMapping("/login")
    public String showFormLogin(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,Model model) {
        session.invalidate();
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
                return "redirect:/";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String showFormRegister(HttpSession session,Model model) {
        UserDto user = (UserDto) session.getAttribute("userLogin");
        CompanyDto company = companyModels.getCompanyById(user.getId());
        model.addAttribute("user", company);

        Integer countJob = jobModels.countJobByCompanyId(company.getId());
        model.addAttribute("countJob", countJob);

        Integer countCandidate = candidateModels.countCandidates();
        model.addAttribute("countCandidate", countCandidate);
        return "admin";
    }

    @GetMapping({"/", "/index"})
    public String showIndex(HttpSession session, Model model, @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                            @RequestParam(defaultValue = "9", required = false) Integer pageSize) {
        UserDto user = (UserDto) session.getAttribute("userLogin");



        if(user != null) {
            CandidateDto candidate = candidateModels.getCandidateById(user.getId());
            model.addAttribute("userLogin", candidate);
        } else {
            model.addAttribute("userLogin", null);
        }
        if(pageNo == null) {
            pageNo = 0;
        }
        if(pageSize == null) {
            pageSize = 9;
        }

        List<CompanyDto> companies = companyModels.getCompanies();
        PageDto<JobDto> jobs = jobModels.getJobs(pageNo, pageSize);

        // Tính toán phần pagination
        int start = Math.max(0, pageNo - 4); // Bắt đầu từ trang lớn hơn hoặc bằng 0
        int end = Math.min(jobs.getTotalPages() - 1, pageNo + 5); // Không vượt quá tổng số trang - 1


        model.addAttribute("jobs", jobs);
        model.addAttribute("companies", companies);

        model.addAttribute("start", start); // Gửi giá trị start của pagination
        model.addAttribute("end", end);     // Gửi giá trị end của pagination
        return "index";
    }
}
