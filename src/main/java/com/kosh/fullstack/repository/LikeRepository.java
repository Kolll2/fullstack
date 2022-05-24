package com.kosh.fullstack.repository;

import com.kosh.fullstack.entities.Comment;
import com.kosh.fullstack.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
