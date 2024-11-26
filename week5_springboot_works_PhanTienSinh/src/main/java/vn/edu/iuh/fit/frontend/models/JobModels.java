/**
 * @ (#) JobModels.java      11/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.dtos.JobDto;
import vn.edu.iuh.fit.backend.dtos.JobSkillDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.resources.JobResources;
import vn.edu.iuh.fit.backend.services.JobServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/18/2024
 */
@Component
public class JobModels {

    @Autowired
    private JobResources jobResources;

    @Autowired
    private RestTemplate restTemplate;

    public PageDto<JobDto> getJobs( int pageNo, int pageSize) {
        return restTemplate.getForObject("http://localhost:8080/api/jobs"
                        + "?pageNo=" + pageNo
                        + "&pageSize=" + pageSize,
                PageDto.class);
    }

    public PageDto<JobDto> getJobsByCompanyI_Paging(Long companyId, int pageNo, int pageSize) {
        return restTemplate.getForObject("http://localhost:8080/api/jobs/company?companyId=" + companyId
                + "&pageNo=" + pageNo
                + "&pageSize=" + pageSize,
                PageDto.class);
    }

    public JobDto getJobById(Long id) {
        return restTemplate.getForObject("http://localhost:8080/api/jobs/" + id, JobDto.class);
    }

    public Integer countJobByCompanyId(Long companyId) {
        return restTemplate.getForObject("http://localhost:8080/api/jobs/company/count?companyId=" + companyId, Integer.class);
    }

    public List<JobSkillDto> getJobSkillsByJobId(Long jobId) {
        ResponseEntity<List<JobSkillDto>> response = restTemplate.exchange("http://localhost:8080/api/jobs/" + jobId + "/skills",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<JobSkillDto>>() {
                });
        return response.getBody();
    }

    public JobDto saveaJob(JobDto jobDto) {
        System.out.println("job model "+jobDto);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<JobDto> request = new HttpEntity<>(jobDto, headers);

        ResponseEntity<JobDto> response = restTemplate.exchange(
                "http://localhost:8080/api/jobs",
                HttpMethod.POST,
                request,
                JobDto.class);

        return response.getBody();
    }

    public PageDto<JobDto> findJobsForCandidateWithSkillLevel(Long canId, int pageNo, int pageSize) {
        return restTemplate.getForObject("http://localhost:8080/api/jobs/recruitment/" + canId + "/recommend"
                        + "?pageNo=" + pageNo
                        + "&pageSize=" + pageSize,
                PageDto.class);
    }
}
