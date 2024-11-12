/**
 * @ (#) UserServices.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.models.User;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
public interface UserServices {
    public List<UserDTO> getUsers_NoPaging();

    public Page<UserDTO> getUsers_Paging(int page, int size, String sortBy, String sortDirection);

}
