package com.example.springboot20200107.dao;

import com.example.springboot20200107.mapper.OrderMapper;
import com.example.springboot20200107.mapper.TicketMapper;
import com.example.springboot20200107.mapper.UserMapper;
import com.example.springboot20200107.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TicketMapper ticketMapper;

    public Integer insertOrder(Order order){
        return orderMapper.insert(order);
    }

    public Integer deleteOrder(Long id){
        return orderMapper.deleteByPrimaryKey(id);
    }

    public Integer updateByIdSelective(Order order,Long id){
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(id);
        return orderMapper.updateByExampleSelective(order,orderExample);
    }

    public List<Order> selectAllOrder(Integer pageNum){
        PageHelper.startPage(pageNum,10);
        OrderExample orderExample = new OrderExample();
        List<Order> orders = orderMapper.selectByExample(orderExample);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return pageInfo.getList();
    }

    public List<Order> selectByUserId(Long userId){
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    public List<Order> selectByTicketId(Long ticketId){
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andTicketIdEqualTo(ticketId);
        return orderMapper.selectByExample(orderExample);
    }

    public Long countAllOrder(){
        OrderExample orderExample = new OrderExample();
        return orderMapper.countByExample(orderExample);
    }

    public Long countByUserId(Long userId){
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId);
        return orderMapper.countByExample(orderExample);
    }

    public Long countByTicketId(Long ticketId){
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andTicketIdEqualTo(ticketId);
        return orderMapper.countByExample(orderExample);
    }

    public Integer chargeBack(Long id){
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order.getOrderState()==0){
            //-2代表已退款
            return -2;
        }else{
            Date createTime = order.getCreateTime();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
            boolean equals = fmt.format(createTime).equals(fmt.format(new Date()));
            if(equals==true){
                Ticket ticket = ticketMapper.selectByPrimaryKey(order.getTicketId());
                if(order.getBuyAdultTicketNum()!=null && order.getBuyStudentTicketNum()!=null){
                    ticket.setTicketNumberStudent(ticket.getTicketNumberStudent()+order.getBuyStudentTicketNum());
                    ticket.setTicketNumberAdult(ticket.getTicketNumberAdult()+order.getBuyAdultTicketNum());
                    ticketMapper.updateByPrimaryKeySelective(ticket);
                }else if(order.getBuyAdultTicketNum()!=null && order.getBuyStudentTicketNum()==null){
                    ticket.setTicketNumberAdult(ticket.getTicketNumberAdult()+order.getBuyAdultTicketNum());
                    ticketMapper.updateByPrimaryKeySelective(ticket);
                }else if(order.getBuyAdultTicketNum()==null && order.getBuyStudentTicketNum()!=null){
                    ticket.setTicketNumberStudent(ticket.getTicketNumberStudent()+order.getBuyStudentTicketNum());
                    ticketMapper.updateByPrimaryKeySelective(ticket);
                }else{
                    //-1代表没买票
                    return -1;
                }
                User user = userMapper.selectByPrimaryKey(order.getUserId());
                user.setLastMoney(user.getLastMoney()+order.getTotalPrice());
                userMapper.updateByPrimaryKeySelective(user);

                order.setUpdateTime(new Date());
                order.setOrderState((short)0);
                //1代表退票成功
                return orderMapper.updateByPrimaryKeySelective(order);
            }else
                //0代表门票已过期
                return 0;
        }
    }
}
