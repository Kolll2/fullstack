package com.kosh.fullstack.repository;

import com.kosh.fullstack.entities.Like;
import com.kosh.fullstack.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long aLong);
}
