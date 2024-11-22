/**
 * @ (#) CandidateServices.java      11/3/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/3/2024
 */

import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;

import java.util.List;


public interface CandidateServices {
    public PageDto<CandidateDto> findAll(int pageNo, int pageSize);
    public List<CandidateDto> findAllNoPaging();
    public CandidateDto getByEmail(String email);

    public CandidateDto getCandidate(Long id);

    public Integer countCandidates();
}
