package com.kosh.fullstack.controllers;

import com.kosh.fullstack.dto.comment.CreateCommentDto;
import com.kosh.fullstack.dto.comment.UpdateCommentDto;
import com.kosh.fullstack.entities.Comment;
import com.kosh.fullstack.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParams(userId, postId);
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CreateCommentDto createComment) {
        return commentService.createComment(createComment);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, UpdateCommentDto updateCommentDto) {
        return commentService.updateComment(commentId, updateCommentDto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
