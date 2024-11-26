/**
 * @ (#) JobResources.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.dtos.JobDto;
import vn.edu.iuh.fit.backend.dtos.JobSkillDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.services.JobServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
@RestController
@RequestMapping("/api/jobs")
public class JobResources {
    @Autowired
    private JobServices jobServices;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<PageDto<JobDto>> getJobs(int pageNo, int pageSize) {
        PageDto<JobDto> jobs = jobServices.getAllJobs(pageNo, pageSize);
        return ResponseEntity.ok(jobs);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<JobDto> getOne(@PathVariable Long id) {
        JobDto job = jobServices.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/company")
    public ResponseEntity<PageDto<JobDto>> getJobByCompanyId_Panging(Long companyId, int pageNo, int pageSize) {
        PageDto<JobDto> page = jobServices.getJobsByCompanyI_Paging(companyId, pageNo, pageSize);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/company/count")
    public ResponseEntity<Integer> countJobByCompanyId(Long companyId) {
        return ResponseEntity.ok(jobServices.countJobByCompanyId(companyId));
    }

    @GetMapping("/{jobId}/skills")
    public ResponseEntity<List<JobSkillDto>> getJobSkillsByJobId(@PathVariable Long jobId) {
        List<JobSkillDto> jobSkills = jobServices.getJobSkillsByJobId(jobId);
        return ResponseEntity.ok(jobSkills);
    }

    @PostMapping
    public ResponseEntity<JobDto> save(@RequestBody JobDto jobDto) {
        System.out.println("job resource: "+jobDto);
        JobDto job = jobServices.saveJob(jobDto);
        return ResponseEntity.ok(job);
    }

    @RequestMapping("/recruitment/{canId}/recommend")
    public ResponseEntity<PageDto<JobDto>> findJobsForCandidateWithSkillLevel(@PathVariable Long canId, int pageNo, int pageSize) {
        PageDto<JobDto> jobs = jobServices.findJobsForCandidateWithSkillLevel(canId, pageNo, pageSize);
        return ResponseEntity.ok(jobs);
    }
}
