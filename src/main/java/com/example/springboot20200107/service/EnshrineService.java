package com.example.springboot20200107.service;

import com.example.springboot20200107.pojo.Enshrine;
import com.example.springboot20200107.request.AddEnshrineRequest;
import com.example.springboot20200107.response.EnshrineResponse;

import java.util.List;

public interface EnshrineService {

    Integer insertEnshrine(AddEnshrineRequest addEnshrineRequest);
    Integer deleteEnshrine(Long id);
    List<EnshrineResponse> selectAllEnshrine(Integer pageNum);
    List<EnshrineResponse> selectByUserId(Long userId);
    List<EnshrineResponse> selectByScenicSpotId(Long scenicSpotId);
    Long countAllEnshrine();
    Long countByUserID(Long userId);
    Long countByScenicSpotId(Long scenicSpotId);
}
