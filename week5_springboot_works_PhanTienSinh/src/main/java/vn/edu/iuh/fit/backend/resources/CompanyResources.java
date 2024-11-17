/**
 * @ (#) CompanyResources.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.dtos.CompanyDto;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.repositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.services.CompanyService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
@RestController
@RequestMapping("/api/companies")
public class CompanyResources {
    @Autowired
    private CompanyService companyService;


    @RequestMapping("/all")
    public ResponseEntity<List<CompanyDto>> findAll() {
        List<CompanyDto> companies = companyService.getAll();
        return ResponseEntity.ok(companies);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Company> getOne(@PathVariable Long id) {
        Company company = companyService.getById(id).get();
        return ResponseEntity.ok(company);
    }
}
