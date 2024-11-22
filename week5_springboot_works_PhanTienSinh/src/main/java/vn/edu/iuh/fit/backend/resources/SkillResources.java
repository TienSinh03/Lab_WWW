/**
 * @ (#) SkillResources.java      11/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.dtos.SkillDto;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/19/2024
 */
@RestController
@RequestMapping("/api/skills")
public class SkillResources {
    @Autowired
    private SkillService skillService;

    @GetMapping("")
    public ResponseEntity<List<SkillDto>> getSkills() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }
}
