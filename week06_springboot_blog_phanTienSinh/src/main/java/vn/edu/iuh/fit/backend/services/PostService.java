/**
 * @ (#) PostService.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.dtos.PostDTO;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
public interface PostService {
    public List<PostDTO> getPosts_NoPaging();
    public PostDTO getPostById(Long id);
}
