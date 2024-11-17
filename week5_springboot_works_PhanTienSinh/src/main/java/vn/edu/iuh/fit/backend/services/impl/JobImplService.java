/**
 * @ (#) JobImplService.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.IJobRepository;
import vn.edu.iuh.fit.backend.services.JobServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
@Service
public class JobImplService implements JobServices {

    @Autowired
    private IJobRepository jobRepository;


    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Page<Job> getJobsByCompanyI_Paging(Long companyId, int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return jobRepository.findJobByCompanyId(companyId, pageable);
    }


    @Override
    public List<Job> getJobsByCompanyIda(Long companyId) {
        return jobRepository.findJobByCompany_Id(companyId);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).get();
    }

}
