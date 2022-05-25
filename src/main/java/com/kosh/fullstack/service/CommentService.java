package com.kosh.fullstack.service;

import com.kosh.fullstack.dto.comment.CreateCommentDto;
import com.kosh.fullstack.dto.comment.UpdateCommentDto;
import com.kosh.fullstack.entities.Comment;
import com.kosh.fullstack.entities.Post;
import com.kosh.fullstack.entities.User;
import com.kosh.fullstack.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    protected final CommentRepository commentRepository;
    protected final PostService postService;
    protected final UserService userService;

    public CommentService(CommentRepository commentRepository,
                          PostService postService,
                          UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<Comment> getAllCommentsWithParams(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent())
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        else if (userId.isPresent())
            return commentRepository.findByUserId(userId.get());
        else if (postId.isPresent())
            return commentRepository.findByPostId(postId.get());
        return commentRepository.findAll();
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CreateCommentDto createComment) {
        User user = userService.findById(createComment.getUserId());
        Post post = postService.getPostById(createComment.getPostId());
        //todo add exception
        if (user == null || post == null) throw new RuntimeException("404 userId or postId is null");

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setText(createComment.getText());
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, UpdateCommentDto updateCommentDto) {
        Optional<Comment> foundedComment = commentRepository.findById(commentId);

        if (foundedComment.isEmpty()) return null;

        Comment comment = foundedComment.get();
        comment.setText(updateCommentDto.getText());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
