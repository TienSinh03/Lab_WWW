/**
 * @ (#) PostCommentDTO.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.dtos;

import lombok.*;

import java.time.Instant;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentDTO implements java.io.Serializable{
    private Long id;
    private String title;
    private Boolean published;
    private Instant createdAt;
    private Instant publishedAt;
    private String content;
    private PostCommentDTO parent;
    private UserDTO user;
    private PostDTO post;

}
