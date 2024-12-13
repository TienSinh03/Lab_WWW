/**
 * @ (#) PostCommentServicesImpl.java      11/13/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.PostCommentDTO;
import vn.edu.iuh.fit.backend.mapper.PostCommentMapper;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.backend.services.PostCommentService;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/13/2024
 */
@Service
public class PostCommentServicesImpl implements PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private PostCommentMapper postCommentMapper;
    @Override
    public PostCommentDTO save(PostCommentDTO postCommentDTO) {
        PostComment postComment = postCommentMapper.toEntity(postCommentDTO);
        return postCommentMapper.toDTO(postCommentRepository.save(postComment));
    }
}
