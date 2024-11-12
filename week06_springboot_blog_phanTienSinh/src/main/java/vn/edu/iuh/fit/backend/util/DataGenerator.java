/**
 * @ (#) DataGenerator.java      11/9/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.util;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.backend.repositories.PostRepository;
import vn.edu.iuh.fit.backend.repositories.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/9/2024
 */
@Component
public class DataGenerator implements org.springframework.boot.CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    private final Faker faker = new Faker();
    private final Random random = new Random();

    @Override
    public void run(String... args) {
//        generateUsers(10);
//        generatePosts(20);
//        generatePostComments(50);
    }

    private void generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setFirstName(faker.name().firstName());
            user.setMiddleName(faker.name().nameWithMiddle());
            user.setLastName(faker.name().lastName());
            user.setMobile(faker.phoneNumber().cellPhone());
            user.setEmail(faker.internet().emailAddress());
            user.setPasswordHash(faker.internet().password());
            user.setRegisteredAt(Instant.now().minusSeconds(random.nextInt(100000)));
            user.setLastLogin(Instant.now().minusSeconds(random.nextInt(50000)));
            user.setIntro(faker.lorem().sentence(5));
            user.setProfile(faker.lorem().paragraph());
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    private void generatePosts(int count) {
        List<User> users = (List<User>) userRepository.findAll();
        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Post post = new Post();
            post.setAuthor(users.get(random.nextInt(users.size())));
            post.setTitle(faker.book().title());
            post.setMetaTitle(faker.lorem().sentence(3));
            post.setSummary(faker.lorem().sentence(10));
            post.setPublished(random.nextBoolean());
            post.setCreatedAt(Instant.now().minusSeconds(random.nextInt(100000)));
            post.setUpdatedAt(Instant.now());
            post.setPublishedAt(Instant.now().minusSeconds(random.nextInt(50000)));
            post.setContent(faker.lorem().paragraph(5));
            posts.add(post);
        }
        postRepository.saveAll(posts);
    }

    private void generatePostComments(int count) {

//      CHÚ Ý LỖI
        List<Post> posts = (List<Post>) postRepository.findAll();
        List<PostComment> comments = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < count; i++) {
            PostComment comment = new PostComment();
                comment.setPost(posts.get(rd.nextInt(posts.size())));
                comment.setParent(null);
                comment.setTitle(faker.lorem().sentence(5));
                comment.setPublished(rd.nextBoolean());

                comment.setCreatedAt(Instant.now().minusSeconds(rd.nextInt(365 * 24 * 60 * 60)));
                comment.setPublishedAt(comment.getPublished() ? Instant.now().minusSeconds(rd.nextInt(365 * 24 * 60 * 60)) : null);
                comment.setContent(faker.lorem().paragraph(3));
                postCommentRepository.save(comment);
        }
//        postCommentRepository.saveAll(comments);
    }
}
