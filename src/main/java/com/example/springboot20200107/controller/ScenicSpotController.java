package com.example.springboot20200107.controller;

import com.example.springboot20200107.pojo.ScenicSpot;

import com.example.springboot20200107.pojo.ScenicSpotExample;
import com.example.springboot20200107.request.AddScenicSpotRequest;
import com.example.springboot20200107.request.UpdateScenicSpotRequest;
import com.example.springboot20200107.response.ScenicSpotResponse;
import com.example.springboot20200107.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ScenicSpotController {
    @Autowired
    private ScenicSpotService scenicSpotService;

    //添加景点
    @PostMapping(value = "insert/scenic/spot")
    public Integer insertScenicSpot(@RequestBody AddScenicSpotRequest addScenicSpotRequest){
        return scenicSpotService.insertScenicSpot(addScenicSpotRequest);
    }

    //通过景点名称修改景点信息
    @PutMapping(value = "update/scenic/spot")
    public Integer updateByScenicSpotSelective(@RequestBody UpdateScenicSpotRequest updateScenicSpotRequest, String scenicSpotName){
        return scenicSpotService.updateByScenicSpotSelective(updateScenicSpotRequest, scenicSpotName);
    }

    //通过景点名称删除景点
    @DeleteMapping(value = "delete/scenic/spot")
    public Integer deleteByScenicSpotName(String scenicSpotName){
        return scenicSpotService.deleteByScenicSpotName(scenicSpotName);
    }

    //查找所有景点
    @GetMapping(value = "select/all/scenic/spot")
    public List<ScenicSpotResponse> selectAllScenicSpot(Integer pageNum){
        return scenicSpotService.selectAllScenicSpot(pageNum);
    }

    //通过景点名称查找景点信息
    @GetMapping(value = "select/by/scenic/name")
    public List<ScenicSpotResponse> selectByScenicSpotName(String scenicSpotName){
        return scenicSpotService.selectByScenicSpotName(scenicSpotName);
    }

}
