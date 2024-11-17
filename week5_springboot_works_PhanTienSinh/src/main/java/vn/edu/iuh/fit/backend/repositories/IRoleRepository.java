/**
 * @ (#) IRoleRepository.java      11/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backend.models.Role;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/18/2024
 */
public interface IRoleRepository extends CrudRepository<Role, Long> {

//    public Role findByU
}
