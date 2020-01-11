package com.example.springboot20200107.dao;

import com.example.springboot20200107.mapper.ScenicSpotMapper;
import com.example.springboot20200107.pojo.ScenicSpot;
import com.example.springboot20200107.pojo.ScenicSpotExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScenicSpotDao {
    @Autowired
    private ScenicSpotMapper scenicSpotMapper;

    public Integer insertScenicSpot(ScenicSpot scenicSpot){
        return scenicSpotMapper.insertSelective(scenicSpot);
    }

    public Integer updateByScenicSpotSelective(ScenicSpot scenicSpot,String scenicSpotName){
        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        scenicSpotExample.createCriteria().andScenicSpotNameEqualTo(scenicSpotName);
        return scenicSpotMapper.updateByExampleSelective(scenicSpot,scenicSpotExample);
    }

    public Integer deleteByScenicSpotName(String scenicSpotName){
        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        scenicSpotExample.createCriteria().andScenicSpotNameEqualTo(scenicSpotName);
        return scenicSpotMapper.deleteByExample(scenicSpotExample);
    }

    public ScenicSpot selectScenicSpotById(Long id){
        return scenicSpotMapper.selectByPrimaryKey(id);
    }

    public List<ScenicSpot> selectAllScenicSpot(Integer pageNum){
        PageHelper.startPage(pageNum,5);
        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        List<ScenicSpot> scenicSpots = scenicSpotMapper.selectByExample(scenicSpotExample);
        PageInfo<ScenicSpot> pageInfo = new PageInfo<>(scenicSpots);
        return pageInfo.getList();
    }

    public List<ScenicSpot> selectByScenicSpotName(String scenicSpotName){
        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        scenicSpotExample.createCriteria().andScenicSpotNameLike("%"+scenicSpotName+"%");
        return scenicSpotMapper.selectByExample(scenicSpotExample);
    }

    public Long countAllScenicSpot(){
        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        return scenicSpotMapper.countByExample(scenicSpotExample);
    }
}
