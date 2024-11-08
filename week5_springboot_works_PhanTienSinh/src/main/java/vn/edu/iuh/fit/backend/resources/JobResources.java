/**
 * @ (#) JobResources.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.services.CompanyService;
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
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobServices.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Job> getOne(@PathVariable Long id) {
        Job job = jobServices.getJobById(id);
        return ResponseEntity.ok(job);
    }
}
