package com.kosh.fullstack.controllers;

import com.kosh.fullstack.dto.post.CreatePostDto;
import com.kosh.fullstack.dto.post.UpdatePostDto;
import com.kosh.fullstack.entities.Post;
import com.kosh.fullstack.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createPost (@RequestBody CreatePostDto newPost){
        return postService.createPost(newPost);
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody UpdatePostDto updatedPost){
        return postService.updatePostById(postId, updatedPost);
    }

    @DeleteMapping("/{postId}")
    public void deletePost (@PathVariable Long postId){
        postService.deletePostById(postId);
    }
}
