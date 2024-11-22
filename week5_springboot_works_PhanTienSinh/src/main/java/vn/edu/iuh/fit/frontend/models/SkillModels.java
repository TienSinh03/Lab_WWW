/**
 * @ (#) SkillModels.java      11/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.dtos.SkillDto;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/19/2024
 */
@Component
public class SkillModels {
    @Autowired
    private RestTemplate restTemplate;

    public List<SkillDto> getSkills () {
        return restTemplate.exchange("http://localhost:8080/api/skills", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SkillDto>>() {}).getBody();
    }
}
