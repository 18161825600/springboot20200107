package com.example.springboot20200107.request;

import com.example.springboot20200107.bo.ScenicSpotImgBo;
import lombok.Data;

import java.util.List;

@Data
public class UpdateScenicSpotRequest {

    private String scenicSpotName;

    private String scenicSpotAddress;

    private String scenicSpotImg;

    private String scenicSpotDescribe;

    private List<ScenicSpotImgBo> scenicSpotImgBoList;
}
