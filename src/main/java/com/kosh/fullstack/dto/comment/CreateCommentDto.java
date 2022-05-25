package com.kosh.fullstack.dto.comment;

import lombok.Data;

@Data
public class CreateCommentDto {
    private Long postId;
    private Long userId;
    private String text;
}
