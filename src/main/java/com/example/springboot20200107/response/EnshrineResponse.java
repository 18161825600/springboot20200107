package com.example.springboot20200107.response;

import lombok.Data;

@Data
public class EnshrineResponse {

    private String nickName;

    private String scenicSpotName;

    private String scenicSpotImg;

    private String scenicSpotDescribe;

    private Long totalEnshrine;
}
