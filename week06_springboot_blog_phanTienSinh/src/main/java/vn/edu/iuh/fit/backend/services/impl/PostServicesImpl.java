/**
 * @ (#) PostServicesImpl.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.PostDTO;
import vn.edu.iuh.fit.backend.mapper.PostMapper;
import vn.edu.iuh.fit.backend.repositories.PostRepository;
import vn.edu.iuh.fit.backend.services.PostService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Service
public class PostServicesImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostDTO> getPosts_NoPaging() {
        return postRepository.findAll().stream().map(postMapper::toDTO).toList();
    }

    @Override
    public PostDTO getPostById(Long id) {
        return postMapper.toDTO(postRepository.findById(id).orElse(null));
    }
}
