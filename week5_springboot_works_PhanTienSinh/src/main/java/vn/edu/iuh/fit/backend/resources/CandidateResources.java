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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.services.CandidateServices;

import java.util.List;

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

    @RequestMapping("/all")
    public ResponseEntity<List<Candidate>> findAll() {
        List<Candidate> candidates = candidateServices.findAllNoPaging();
        return ResponseEntity.ok(candidates);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable Long id) {
        Candidate candidate = candidateServices.getCandidate(id);
        return ResponseEntity.ok(candidate);
    }
}
