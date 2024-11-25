/**
 * @ (#) CandidateResources.java      11/7/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.services.CandidateServices;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateResources {
    @Autowired
    private CandidateServices candidateServices;

    @RequestMapping("")
    public ResponseEntity<PageDto<CandidateDto>> findAll(int pageNo, int pageSize) {
        PageDto<CandidateDto> candidates = candidateServices.findAll(pageNo, pageSize);
        return ResponseEntity.ok(candidates);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<CandidateDto> findById(@PathVariable Long id) {
        CandidateDto candidate = candidateServices.getCandidate(id);
        return ResponseEntity.ok(candidate);
    }

    @RequestMapping("/job/{jobId}")
    public ResponseEntity<PageDto<CandidateDto>> findCandidatesForJobWithSkillLevel(@PathVariable Long jobId, int pageNo, int pageSize) {
        PageDto<CandidateDto> candidates = candidateServices.findCandidatesForJobWithSkillLevel(jobId, pageNo, pageSize);
        return ResponseEntity.ok(candidates);
    }
}
