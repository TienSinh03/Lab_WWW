/**
 * @ (#) UserMapper.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.models.User;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
