package com.kosh.fullstack.repository;

import com.kosh.fullstack.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
