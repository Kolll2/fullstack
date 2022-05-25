package com.kosh.fullstack.service;

import com.kosh.fullstack.dto.post.CreatePostDto;
import com.kosh.fullstack.dto.post.UpdatePostDto;
import com.kosh.fullstack.entities.Post;
import com.kosh.fullstack.entities.User;
import com.kosh.fullstack.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;


    public PostService(PostRepository postRepository,
                       UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createPost(CreatePostDto newPost) {
        User user = userService.findById(newPost.getUserId());
        if (user == null) return null;

        Post post = new Post();
        post.setText(newPost.getText());
        post.setTitle(newPost.getTitle());
        post.setUser(user);
        return postRepository.save(post);
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updatePostById(Long postId, UpdatePostDto updatedPost) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            //todo add custom 404 exception
            return null;
        }

        Post post = optionalPost.get();
        post.setTitle(updatedPost.getTitle());
        post.setText(updatedPost.getText());

        return postRepository.save(post);
    }
}
