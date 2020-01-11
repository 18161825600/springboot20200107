package com.example.springboot20200107.dao;

import com.example.springboot20200107.mapper.EnshrineMapper;
import com.example.springboot20200107.pojo.Enshrine;
import com.example.springboot20200107.pojo.EnshrineExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class EnshrineDao {

    @Autowired
    private EnshrineMapper enshrineMapper;

    public Integer insertEnshrine(Enshrine enshrine){
        return enshrineMapper.insert(enshrine);
    }

    public Integer deleteEnshrine(Long id){
        return  enshrineMapper.deleteByPrimaryKey(id);
    }

    public List<Enshrine> selectAllEnshrine(Integer pageNum){
        PageHelper.startPage(pageNum,10);
        EnshrineExample enshrineExample = new EnshrineExample();
        List<Enshrine> enshrines = enshrineMapper.selectByExample(enshrineExample);
        PageInfo<Enshrine> pageInfo = new PageInfo<>(enshrines);
        return pageInfo.getList();
    }

    public List<Enshrine> selectByUserId(Long userId){
        EnshrineExample enshrineExample = new EnshrineExample();
        enshrineExample.createCriteria().andUserIdEqualTo(userId);
        return enshrineMapper.selectByExample(enshrineExample);
    }

    public List<Enshrine> selectByScenicSpotId(Long scenicSpotId){
        EnshrineExample enshrineExample = new EnshrineExample();
        enshrineExample.createCriteria().andScenicSpotIdEqualTo(scenicSpotId);
        return enshrineMapper.selectByExample(enshrineExample);
    }

    public Long countAllEnshrine(){
        EnshrineExample enshrineExample = new EnshrineExample();
        return enshrineMapper.countByExample(enshrineExample);
    }

    public Long countByUserID(Long userId){
        EnshrineExample enshrineExample = new EnshrineExample();
        enshrineExample.createCriteria().andUserIdEqualTo(userId);
        return enshrineMapper.countByExample(enshrineExample);
    }

    public Long countByScenicSpotId(Long scenicSpotId){
        EnshrineExample enshrineExample = new EnshrineExample();
        enshrineExample.createCriteria().andScenicSpotIdEqualTo(scenicSpotId);
        return enshrineMapper.countByExample(enshrineExample);
    }
}
