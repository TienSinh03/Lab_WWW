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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;


public interface CandidateServices {
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);
    public Candidate getByEmail(String email);
}
