package com.example.springboot20200107.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ScenicSpot {
    private Long id;

    private String scenicSpotName;

    private String scenicSpotAddress;

    private String scenicSpotImg;

    private String scenicSpotDescribe;

    private String scenicSpotImgs;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScenicSpotName() {
        return scenicSpotName;
    }

    public void setScenicSpotName(String scenicSpotName) {
        this.scenicSpotName = scenicSpotName == null ? null : scenicSpotName.trim();
    }

    public String getScenicSpotAddress() {
        return scenicSpotAddress;
    }

    public void setScenicSpotAddress(String scenicSpotAddress) {
        this.scenicSpotAddress = scenicSpotAddress == null ? null : scenicSpotAddress.trim();
    }

    public String getScenicSpotImg() {
        return scenicSpotImg;
    }

    public void setScenicSpotImg(String scenicSpotImg) {
        this.scenicSpotImg = scenicSpotImg == null ? null : scenicSpotImg.trim();
    }

    public String getScenicSpotDescribe() {
        return scenicSpotDescribe;
    }

    public void setScenicSpotDescribe(String scenicSpotDescribe) {
        this.scenicSpotDescribe = scenicSpotDescribe == null ? null : scenicSpotDescribe.trim();
    }

    public String getScenicSpotImgs() {
        return scenicSpotImgs;
    }

    public void setScenicSpotImgs(String scenicSpotImgs) {
        this.scenicSpotImgs = scenicSpotImgs == null ? null : scenicSpotImgs.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}