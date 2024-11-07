/**
 * @ (#) CandidateServicesImpl.java      11/7/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.services.CandidateServices;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
@Service
public class CandidateServicesImpl implements CandidateServices {

    @Autowired
    private ICandidateRepository candidateRepository;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    @Override
    public Candidate getByEmail(String email) {
        return candidateRepository.findByEmail(email);
    }
}
