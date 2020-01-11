package com.example.springboot20200107.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {
    private Long id;

    private Long scenicSpotId;

    private String ticketName;

    private Double ticketPriceAdult;

    private Double ticketPriceStudent;

    private Integer ticketNumberAdult;

    private Integer ticketNumberStudent;

    private String ticketDescribe;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(Long scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName == null ? null : ticketName.trim();
    }

    public Double getTicketPriceAdult() {
        return ticketPriceAdult;
    }

    public void setTicketPriceAdult(Double ticketPriceAdult) {
        this.ticketPriceAdult = ticketPriceAdult;
    }

    public Double getTicketPriceStudent() {
        return ticketPriceStudent;
    }

    public void setTicketPriceStudent(Double ticketPriceStudent) {
        this.ticketPriceStudent = ticketPriceStudent;
    }

    public Integer getTicketNumberAdult() {
        return ticketNumberAdult;
    }

    public void setTicketNumberAdult(Integer ticketNumberAdult) {
        this.ticketNumberAdult = ticketNumberAdult;
    }

    public Integer getTicketNumberStudent() {
        return ticketNumberStudent;
    }

    public void setTicketNumberStudent(Integer ticketNumberStudent) {
        this.ticketNumberStudent = ticketNumberStudent;
    }

    public String getTicketDescribe() {
        return ticketDescribe;
    }

    public void setTicketDescribe(String ticketDescribe) {
        this.ticketDescribe = ticketDescribe == null ? null : ticketDescribe.trim();
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