package com.kosh.fullstack.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "p_like")
@Data
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private Long userId;
}
