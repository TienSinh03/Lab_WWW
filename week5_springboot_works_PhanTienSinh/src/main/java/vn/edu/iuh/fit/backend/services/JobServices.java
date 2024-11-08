/**
 * @ (#) JobServices.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.backend.models.Job;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
public interface JobServices {
    public List<Job> getAllJobs();
    public Page<List<Job>> getJobsByCompanyI_Paging(Long companyId, int pageNo, int pageSize, String sortBy, String sortDirection);
    public List<Job> getJobsByCompanyIda(Long companyId);
    public Job getJobById(Long id);
}
