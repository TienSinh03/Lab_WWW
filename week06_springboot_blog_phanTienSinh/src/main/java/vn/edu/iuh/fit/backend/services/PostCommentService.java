/**
 * @ (#) PostCommentService.java      11/13/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.dtos.PostCommentDTO;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/13/2024
 */
public interface PostCommentService {
    public PostCommentDTO save(PostCommentDTO postCommentDTO);
}
