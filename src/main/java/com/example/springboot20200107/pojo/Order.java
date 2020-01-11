package com.example.springboot20200107.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Long id;

    private Long userId;

    private Long ticketId;

    private Integer buyAdultTicketNum;

    private Integer buyStudentTicketNum;

    private Double totalPrice;

    /**
     * 0表示已退款
     * 1表示交易成功
     */
    private Short orderState;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getBuyAdultTicketNum() {
        return buyAdultTicketNum;
    }

    public void setBuyAdultTicketNum(Integer buyAdultTicketNum) {
        this.buyAdultTicketNum = buyAdultTicketNum;
    }

    public Integer getBuyStudentTicketNum() {
        return buyStudentTicketNum;
    }

    public void setBuyStudentTicketNum(Integer buyStudentTicketNum) {
        this.buyStudentTicketNum = buyStudentTicketNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Short getOrderState() {
        return orderState;
    }

    public void setOrderState(Short orderState) {
        this.orderState = orderState;
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