package com.example.springboot20200107.controller;

import com.example.springboot20200107.pojo.Enshrine;
import com.example.springboot20200107.request.AddEnshrineRequest;
import com.example.springboot20200107.response.EnshrineResponse;
import com.example.springboot20200107.service.EnshrineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EnshrineController {

    @Autowired
    private EnshrineService enshrineService;

    //添加收藏
    @PostMapping(value = "insert/enshrine")
    public Integer insertEnshrine(@RequestBody AddEnshrineRequest addEnshrineRequest){
        return enshrineService.insertEnshrine(addEnshrineRequest);
    }

    //通过主键删除收藏
    @DeleteMapping(value = "delete/enshrine")
    public Integer deleteEnshrine(Long id){
        return enshrineService.deleteEnshrine(id);
    }

    //查看所有的收藏记录
    @GetMapping(value = "select/all/enshrine")
    public List<EnshrineResponse> selectAllEnshrine(Integer pageNum){
        return enshrineService.selectAllEnshrine(pageNum);
    }

    //通过用户id查看该用户收藏了哪些景点
    @GetMapping(value = "select/by/userId")
    public List<EnshrineResponse> selectByUserId(Long userId){
        return enshrineService.selectByUserId(userId);
    }

    //通过景点id查看该景点被哪些用户收藏
    @GetMapping(value = "select/by/scenicSpotId")
    public List<EnshrineResponse> selectByScenicSpotId(Long scenicSpotId){
        return enshrineService.selectByScenicSpotId(scenicSpotId);
    }

    //查看有多少条收藏记录
    @GetMapping(value = "count/all/enshrine")
    public Long countAllEnshrine(){
        return enshrineService.countAllEnshrine();
    }

    //通过用户id查看该用户收藏了多少景点
    @GetMapping(value = "count/by/userId")
    public Long countByUserID(Long userId){
        return enshrineService.countByUserID(userId);
    }

    //通过景点id查看该景点被多少人收藏
    @GetMapping(value = "count/by/scenicSpotId")
    public Long countByScenicSpotId(Long scenicSpotId){
        return enshrineService.countByScenicSpotId(scenicSpotId);
    }
}
