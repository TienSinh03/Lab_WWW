/**
 * @ (#) PostCommentRepository.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.PostComment;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
