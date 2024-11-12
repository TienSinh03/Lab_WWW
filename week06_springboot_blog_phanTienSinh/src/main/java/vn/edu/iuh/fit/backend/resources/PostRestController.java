/**
 * @ (#) PostRestController.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.dtos.PostDTO;
import vn.edu.iuh.fit.backend.services.PostService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
@RestController
@RequestMapping("api/post")
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getPosts_NoPaging());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
    
}
