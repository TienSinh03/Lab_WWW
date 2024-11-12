/**
 * @ (#) PostModel.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.dtos.PostDTO;
import vn.edu.iuh.fit.backend.services.PostService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Component
public class PostModel {
    @Autowired
    private PostService postService;

    @Autowired
    private RestTemplate restTemplate;

    public List<PostDTO> getPosts_NoPaging() {
        return restTemplate.exchange("http://localhost:8080/api/post", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PostDTO>>() {
                }).getBody();
    }

    public PostDTO getPostById(Long id) {
        return restTemplate.exchange("http://localhost:8080/api/post/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<PostDTO>() {
                }).getBody();
    }

}
