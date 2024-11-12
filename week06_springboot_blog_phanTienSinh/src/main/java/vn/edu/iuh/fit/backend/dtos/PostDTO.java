/**
 * @ (#) PostDTO.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.Instant;
import java.util.Set;

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
public class PostDTO implements java.io.Serializable{
    private Long id;
    private String title;
    private String summary;
    private Boolean published;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant publishedAt;
    private String metaTitle;
    private String content;
    private UserDTO author;
    private PostDTO parent;
//    private Set<PostCommentDTO> postComments;
}
