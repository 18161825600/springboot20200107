package com.example.springboot20200107.response;

import lombok.Data;

import java.util.List;

@Data
public class ScenicSpotResponse {

    private String scenicSpotName;

    private String scenicSpotAddress;

    private String scenicSpotImg;

    private String scenicSpotDescribe;

    private String scenicSpotImgs;

    private Long totalScenicSpot;
}
