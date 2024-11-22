/**
 * @ (#) IUserRepository.java      11/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.User;

import java.util.Optional;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    public Optional<User> findByUsernameAndPassword(String username, String password);
}
