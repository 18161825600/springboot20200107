package com.example.springboot20200107.service.impl;

import com.example.springboot20200107.dao.EnshrineDao;
import com.example.springboot20200107.dao.ScenicSpotDao;
import com.example.springboot20200107.dao.UserDao;
import com.example.springboot20200107.pojo.Enshrine;
import com.example.springboot20200107.pojo.ScenicSpot;
import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.request.AddEnshrineRequest;
import com.example.springboot20200107.response.EnshrineResponse;
import com.example.springboot20200107.service.EnshrineService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class EnshrineServiceImpl implements EnshrineService {
    @Autowired
    private EnshrineDao enshrineDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ScenicSpotDao scenicSpotDao;

    @Override
    public Integer insertEnshrine(AddEnshrineRequest addEnshrineRequest) {
        Enshrine enshrine = new Enshrine();
        BeanUtils.copyProperties(addEnshrineRequest,enshrine);
        enshrine.setCreateTime(new Date());
        return enshrineDao.insertEnshrine(enshrine);
    }

    @Override
    public Integer deleteEnshrine(Long id) {
        return enshrineDao.deleteEnshrine(id);
    }

    @Override
    public List<EnshrineResponse> selectAllEnshrine(Integer pageNum) {
        List<Enshrine> enshrines = enshrineDao.selectAllEnshrine(pageNum);
        return showEnshrineResponse(enshrines);
    }

    @Override
    public List<EnshrineResponse> selectByUserId(Long userId) {
        List<Enshrine> enshrines = enshrineDao.selectByUserId(userId);
        return showEnshrineResponse(enshrines);
    }

    @Override
    public List<EnshrineResponse> selectByScenicSpotId(Long scenicSpotId) {
        List<Enshrine> enshrines = enshrineDao.selectByScenicSpotId(scenicSpotId);
        return showEnshrineResponse(enshrines);
    }

    @Override
    public Long countAllEnshrine() {
        return enshrineDao.countAllEnshrine();
    }

    @Override
    public Long countByUserID(Long userId) {
        return enshrineDao.countByUserID(userId);
    }

    @Override
    public Long countByScenicSpotId(Long scenicSpotId) {
        return enshrineDao.countByScenicSpotId(scenicSpotId);
    }

    public List<EnshrineResponse> showEnshrineResponse(List<Enshrine> enshrines){
        List<EnshrineResponse> enshrineResponseList = new ArrayList<>();
        for (Enshrine enshrine:enshrines) {
            EnshrineResponse enshrineResponse = new EnshrineResponse();
            User user = userDao.selectUserById(enshrine.getUserId());
            enshrineResponse.setNickName(user.getNickName());
            ScenicSpot scenicSpot = scenicSpotDao.selectScenicSpotById(enshrine.getScenicSpotId());
            BeanUtils.copyProperties(scenicSpot,enshrineResponse);
            enshrineResponseList.add(enshrineResponse);
        }
        return enshrineResponseList;
    }
}
