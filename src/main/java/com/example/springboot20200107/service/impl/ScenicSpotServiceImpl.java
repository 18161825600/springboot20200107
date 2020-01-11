package com.example.springboot20200107.service.impl;

import com.example.springboot20200107.bo.ScenicSpotImgBo;
import com.example.springboot20200107.dao.ScenicSpotDao;
import com.example.springboot20200107.pojo.ScenicSpot;
import com.example.springboot20200107.request.AddScenicSpotRequest;

import com.example.springboot20200107.request.UpdateScenicSpotRequest;
import com.example.springboot20200107.response.ScenicSpotResponse;
import com.example.springboot20200107.service.ScenicSpotService;
import com.example.springboot20200107.utils.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScenicSpotServiceImpl implements ScenicSpotService {
    @Autowired
    private ScenicSpotDao scenicSpotDao;

    @Override
    public Integer insertScenicSpot(AddScenicSpotRequest addScenicSpotRequest) {
        ScenicSpot scenicSpot = new ScenicSpot();
        BeanUtils.copyProperties(addScenicSpotRequest,scenicSpot);
        List<String> scenicImgList = addScenicSpotRequest.getScenicSpotImgBoList();
        HashMap<String,String> hashMap = new HashMap<>();
        for (String s:scenicImgList) {
            String uuid = UUID.randomUUID().toString();
            hashMap.put(uuid,s);
        }
        scenicSpot.setScenicSpotImgs(JsonUtils.objectToJson(hashMap));
        scenicSpot.setCreateTime(new Date());
        return scenicSpotDao.insertScenicSpot(scenicSpot);
    }

    @Override
    public Integer updateByScenicSpotSelective(UpdateScenicSpotRequest updateScenicSpotRequest, String scenicSpotName) {
        ScenicSpot scenicSpot = new ScenicSpot();
        BeanUtils.copyProperties(updateScenicSpotRequest,scenicSpot);
        scenicSpot.setUpdateTime(new Date());
        List<ScenicSpotImgBo> scenicSpotImgBoList = updateScenicSpotRequest.getScenicSpotImgBoList();
        if (!CollectionUtils.isEmpty(scenicSpotImgBoList)) {
            for (ScenicSpotImgBo scenicSpotImgBo : scenicSpotImgBoList) {
                if(StringUtils.isEmpty(scenicSpotImgBo.getScenicImgUUID())){
                    String uuid = UUID.randomUUID().toString();
                    scenicSpotImgBo.setScenicImgUUID(uuid);
                }
            }
            scenicSpot.setScenicSpotImgs(JsonUtils.objectToJson(scenicSpotImgBoList));
        }

        return scenicSpotDao.updateByScenicSpotSelective(scenicSpot, scenicSpotName);
    }

    @Override
    public Integer deleteByScenicSpotName(String scenicSpotName) {
        return scenicSpotDao.deleteByScenicSpotName(scenicSpotName);
    }

    @Override
    public ScenicSpot selectScenicSpotById(Long id) {
        return scenicSpotDao.selectScenicSpotById(id);
    }

    @Override
    public List<ScenicSpotResponse> selectAllScenicSpot(Integer pageNum) {
        List<ScenicSpot> scenicSpots = scenicSpotDao.selectAllScenicSpot(pageNum);
        List<ScenicSpotResponse> list = new ArrayList<>();
        for (ScenicSpot scenicSpot:scenicSpots) {
            ScenicSpotResponse scenicSpotResponse = new ScenicSpotResponse();
            scenicSpotResponse.setScenicSpotName(scenicSpot.getScenicSpotName());
            scenicSpotResponse.setScenicSpotAddress(scenicSpot.getScenicSpotAddress());
            scenicSpotResponse.setScenicSpotDescribe(scenicSpot.getScenicSpotDescribe());
            scenicSpotResponse.setScenicSpotImg(scenicSpot.getScenicSpotImg());
            scenicSpotResponse.setScenicSpotImgs(scenicSpot.getScenicSpotImgs());
            scenicSpotResponse.setTotalScenicSpot(scenicSpotDao.countAllScenicSpot());
            list.add(scenicSpotResponse);
        }
        return list;
    }

    @Override
    public List<ScenicSpotResponse> selectByScenicSpotName(String scenicSpotName) {
        List<ScenicSpot> scenicSpots = scenicSpotDao.selectByScenicSpotName(scenicSpotName);
        List<ScenicSpotResponse> list = new ArrayList<>();
        for (ScenicSpot scenicSpot:scenicSpots) {
            ScenicSpotResponse scenicSpotResponse = new ScenicSpotResponse();
            scenicSpotResponse.setScenicSpotName(scenicSpot.getScenicSpotName());
            scenicSpotResponse.setScenicSpotAddress(scenicSpot.getScenicSpotAddress());
            scenicSpotResponse.setScenicSpotDescribe(scenicSpot.getScenicSpotDescribe());
            scenicSpotResponse.setScenicSpotImg(scenicSpot.getScenicSpotImg());
            scenicSpotResponse.setScenicSpotImgs(scenicSpot.getScenicSpotImgs());
            scenicSpotResponse.setTotalScenicSpot(scenicSpotDao.countAllScenicSpot());
            list.add(scenicSpotResponse);
        }
        return list;
    }

}
