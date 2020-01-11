package com.example.springboot20200107.request;

import lombok.Data;

@Data
public class AddCommentRequest {

    private Long userId;

    private Long scenicSpotId;

    private String comment;

}
