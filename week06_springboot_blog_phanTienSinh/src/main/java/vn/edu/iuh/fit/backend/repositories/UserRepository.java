/**
 * @ (#) UserRepository.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.User;

import java.util.Optional;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.passwordHash = ?2")
    public Optional<User> findByEmailAndPassword(String email, String password);
}
