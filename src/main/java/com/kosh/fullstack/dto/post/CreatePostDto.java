package com.kosh.fullstack.dto.post;

import lombok.Data;

@Data
public class CreatePostDto {

    private Long userId;
    private String title;
    private String text;

}
