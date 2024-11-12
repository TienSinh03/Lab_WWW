/**
 * @ (#) PostMapper.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.edu.iuh.fit.backend.dtos.PostDTO;
import vn.edu.iuh.fit.backend.models.Post;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "author", target = "author")
    PostDTO toDTO(Post post);

    @Mapping(source = "author", target = "author")
    Post toEntity(PostDTO postDTO);
}
