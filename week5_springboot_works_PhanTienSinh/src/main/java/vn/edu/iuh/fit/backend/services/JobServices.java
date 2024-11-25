/**
 * @ (#) JobServices.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backend.dtos.JobDto;
import vn.edu.iuh.fit.backend.dtos.JobSkillDto;
import vn.edu.iuh.fit.backend.dtos.JobSkillIdDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.entities.Job;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
public interface JobServices {
    public PageDto<JobDto> getAllJobs(int pageNo, int pageSize);
    public PageDto<JobDto> getJobsByCompanyI_Paging(Long companyId, int pageNo, int pageSize);
    public List<JobDto> getJobsByCompanyIda(Long companyId);
    public JobDto getJobById(Long id);

    public JobDto saveJob(JobDto jobDto);
    public int countJobByCompanyId(Long companyId);

    public List<JobSkillDto> getJobSkillsByJobId(Long jobId);

    public PageDto<JobDto> findJobsForCandidateWithSkillLevel(Long canId, int pageNo, int pageSize);

}
