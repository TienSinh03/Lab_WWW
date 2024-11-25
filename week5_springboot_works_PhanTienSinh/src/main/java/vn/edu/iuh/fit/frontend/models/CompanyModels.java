/**
 * @ (#) CompanyModels.java      11/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.dtos.CompanyDto;
import vn.edu.iuh.fit.backend.services.CompanyService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/18/2024
 */
@Component
public class CompanyModels {

    @Autowired
   private RestTemplate restTemplate;

    @Autowired
    private CompanyService companyService;

    public CompanyDto getCompanyById(Long id) {
        return restTemplate.getForObject("http://localhost:8080/api/companies/" + id, CompanyDto.class);
    }

    public List<CompanyDto> getCompanies() {
        return restTemplate.getForObject("http://localhost:8080/api/companies", List.class);
    }
}
