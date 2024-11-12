/**
 * @ (#) PostRestController.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.dtos.PostDTO;
import vn.edu.iuh.fit.backend.services.PostService;
import vn.edu.iuh.fit.frontend.model.PostModel;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostModel postModel;

    @GetMapping({"/", "","/home"})
    public String getAllPosts(Model model) {
        List<PostDTO> posts = postModel.getPosts_NoPaging();
        model.addAttribute("posts", posts);
        return "post/home";
    }

    @GetMapping({"/detail", "/detail/"})
    public String getDetailPost(Model model, @RequestParam("post_id") Long id) {
        PostDTO post = postModel.getPostById(id);
        model.addAttribute("post_detail", post);
        return "post/detail-blog";
    }
}
