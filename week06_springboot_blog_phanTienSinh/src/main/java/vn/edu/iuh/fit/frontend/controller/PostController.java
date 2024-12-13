/**
 * @ (#) PostRestController.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.PostCommentDTO;
import vn.edu.iuh.fit.backend.dtos.PostDTO;
import vn.edu.iuh.fit.backend.dtos.UserDTO;
import vn.edu.iuh.fit.backend.services.PostCommentService;
import vn.edu.iuh.fit.backend.services.PostService;
import vn.edu.iuh.fit.frontend.model.PostModel;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Controller
@RequestMapping("/post")
@SessionAttributes("userLogin")
public class PostController {

    @Autowired
    private PostModel postModel;

    @Autowired
    private PostCommentService postCommentService;

    @GetMapping({"/", "","/home"})
    public String getAllPosts(HttpSession session, Model model) {
        UserDTO userDTOLogin = (UserDTO) session.getAttribute("userLogin");
        model.addAttribute("userLogin", userDTOLogin);
        List<PostDTO> posts = postModel.getPosts_NoPaging();
        model.addAttribute("posts", posts);
        return "post/home";
    }

    @GetMapping({"/detail", "/detail/"})
    public String getDetailPost(Model model, @RequestParam("post_id") Long id) {
        PostDTO post = postModel.getPostById(id);
        model.addAttribute("post_detail", post);
        PostCommentDTO postCommentDTO = new PostCommentDTO();
        model.addAttribute("post_comment", postCommentDTO);
        return "post/detail-blog";
    }

    @GetMapping({"/nav"})
    public String createPost(HttpSession session,Model model) {
        UserDTO userDTOLogin = (UserDTO) session.getAttribute("userLogin");
        model.addAttribute("userLogin", userDTOLogin);
        return "fragments/navbar";
    }

    @PostMapping("/comment")
    public String commentPost(HttpSession session, Model model, @ModelAttribute("post_detail") PostDTO postDTO, @ModelAttribute("post_comment") PostCommentDTO postCommentDTO) {
        UserDTO userDTOLogin = (UserDTO) session.getAttribute("userLogin");

        if (postCommentDTO== null) {
            postCommentDTO = new PostCommentDTO();
        }
        Random rd = new Random();
        postCommentDTO.setUser(userDTOLogin);
        postCommentDTO.setCreatedAt(Instant.now());

        postCommentService.save(postCommentDTO);

        return "post/detail-blog";
    }
}
