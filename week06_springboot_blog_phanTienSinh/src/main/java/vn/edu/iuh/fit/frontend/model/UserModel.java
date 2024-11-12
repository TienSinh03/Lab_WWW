/**
 * @ (#) UserModel.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.dtos.UserDTO;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Component
public class UserModel {
    @Autowired
    private RestTemplate restTemplate;

    public UserDTO getUserById(Long id) {
        return restTemplate.exchange("http://localhost:8080/api/user/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<UserDTO>() {
                }).getBody();
    }
}
