package com.example.springboot20200107.service;


import com.example.springboot20200107.pojo.ScenicSpot;
import com.example.springboot20200107.request.AddScenicSpotRequest;
import com.example.springboot20200107.request.UpdateScenicSpotRequest;
import com.example.springboot20200107.response.ScenicSpotResponse;

import java.util.List;

public interface ScenicSpotService {

    Integer insertScenicSpot(AddScenicSpotRequest addScenicSpotRequest);
    Integer updateByScenicSpotSelective(UpdateScenicSpotRequest updateScenicSpotRequest, String scenicSpotName);
    Integer deleteByScenicSpotName(String scenicSpotName);
    ScenicSpot selectScenicSpotById(Long id);
    List<ScenicSpotResponse> selectAllScenicSpot(Integer pageNum);
    List<ScenicSpotResponse> selectByScenicSpotName(String scenicSpotName);
}
