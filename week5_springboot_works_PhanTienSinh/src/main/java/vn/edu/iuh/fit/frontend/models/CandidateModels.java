/**
 * @ (#) CandidateModels.java      11/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.services.CandidateServices;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/18/2024
 */
@Component
public class CandidateModels {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CandidateServices candidateServices;

    public CandidateDto getCandidateById(Long id) {
        return restTemplate.getForObject("http://localhost:8080/api/candidates/" + id, CandidateDto.class);
    }

    public PageDto<CandidateDto> getCandidates(int pageNo, int pageSize) {
        return restTemplate.getForObject("http://localhost:8080/api/candidates?pageNo=" + pageNo
                + "&pageSize=" + pageSize,
                PageDto.class);
    }

    public Integer countCandidates() {
        return candidateServices.countCandidates();
    }
}
