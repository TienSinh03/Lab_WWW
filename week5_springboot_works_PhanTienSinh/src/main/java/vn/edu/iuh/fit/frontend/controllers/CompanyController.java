/**
 * @ (#) CompanyController.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.services.CompanyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public String showCompaniesListPaging(Model model, @RequestParam("page")Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);
        Page<Company> companyPage = companyService.getAllByPaging(currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("companyPage", companyPage);

        int totalPages = companyPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed().toList();
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "company/companies";
    }
}
