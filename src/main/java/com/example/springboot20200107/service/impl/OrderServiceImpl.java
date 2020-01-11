package com.example.springboot20200107.service.impl;

import com.example.springboot20200107.dao.OrderDao;
import com.example.springboot20200107.dao.ScenicSpotDao;
import com.example.springboot20200107.dao.TicketDao;
import com.example.springboot20200107.dao.UserDao;
import com.example.springboot20200107.pojo.Order;
import com.example.springboot20200107.pojo.ScenicSpot;
import com.example.springboot20200107.pojo.Ticket;
import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.request.AddOrderRequest;
import com.example.springboot20200107.response.OrderResponse;
import com.example.springboot20200107.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ScenicSpotDao scenicSpotDao;
    @Autowired
    private TicketDao ticketDao;

    @Override
    public Integer insertOrder(AddOrderRequest addOrderRequest) {
        Order order =new Order();
        order.setUserId(addOrderRequest.getUserId());
        order.setTicketId(addOrderRequest.getTicketId());
        Ticket ticket = ticketDao.selectById(addOrderRequest.getTicketId());
        if(addOrderRequest.getBuyStudentTicketNum()==0 && addOrderRequest.getBuyAdultTicketNum()==0){
            return -2;
        }else if(addOrderRequest.getBuyAdultTicketNum()==0 && addOrderRequest.getBuyStudentTicketNum()!=0){
            order.setBuyStudentTicketNum(addOrderRequest.getBuyStudentTicketNum());
            order.setTotalPrice(ticket.getTicketPriceStudent()*addOrderRequest.getBuyStudentTicketNum());
        }else if(addOrderRequest.getBuyAdultTicketNum()!=0 && addOrderRequest.getBuyStudentTicketNum()==0){
            order.setBuyAdultTicketNum(addOrderRequest.getBuyAdultTicketNum());
            order.setTotalPrice(ticket.getTicketPriceAdult()*addOrderRequest.getBuyAdultTicketNum());
        }else{
            order.setBuyAdultTicketNum(addOrderRequest.getBuyAdultTicketNum());
            order.setBuyStudentTicketNum(addOrderRequest.getBuyStudentTicketNum());
            order.setTotalPrice(ticket.getTicketPriceAdult()*addOrderRequest.getBuyAdultTicketNum()+ticket.getTicketPriceStudent()*addOrderRequest.getBuyStudentTicketNum());
        }
        User user = userDao.selectUserById(addOrderRequest.getUserId());
        if(user.getLastMoney()>=order.getTotalPrice()){
            order.setCreateTime(new Date());
            order.setOrderState((short)1);
            user.setLastMoney(user.getLastMoney()-order.getTotalPrice());
            user.setUpdateTime(new Date());
            userDao.updateByUserIdSelective(user);
            ticket.setTicketNumberAdult(ticket.getTicketNumberAdult()-addOrderRequest.getBuyAdultTicketNum());
            ticket.setTicketNumberStudent(ticket.getTicketNumberStudent()-addOrderRequest.getBuyStudentTicketNum());
            ticketDao.updateByIdSelective(ticket);
            return orderDao.insertOrder(order);
        }else return -1;
    }

    @Override
    public Integer deleteOrder(Long id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public Integer updateByIdSelective(Order order, Long id) {
        return orderDao.updateByIdSelective(order, id);
    }

    @Override
    public List<OrderResponse> selectAllOrder(Integer pageNum) {
        List<Order> orders = orderDao.selectAllOrder(pageNum);
        return showOrderResponse(orders);
    }

    @Override
    public List<OrderResponse> selectByUserId(Long userId) {
        List<Order> orders = orderDao.selectByUserId(userId);
        return showOrderResponse(orders);
    }

    @Override
    public List<OrderResponse> selectByTicketId(Long ticketId) {
        List<Order> orders = orderDao.selectByTicketId(ticketId);
        return showOrderResponse(orders);
    }

    @Override
    public Long countAllOrder() {
        return orderDao.countAllOrder();
    }

    @Override
    public Long countByUserId(Long userId) {
        return orderDao.countByUserId(userId);
    }

    @Override
    public Long countByTicketId(Long ticketId) {
        return orderDao.countByTicketId(ticketId);
    }

    @Override
    public Integer chargeBack(Long id) {
        return orderDao.chargeBack(id);
    }


    public List<OrderResponse> showOrderResponse(List<Order> orders){
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order order:orders) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order,orderResponse);

            User user = userDao.selectUserById(order.getUserId());
            orderResponse.setUserName(user.getUserName());

            Ticket ticket = ticketDao.selectById(order.getTicketId());
            orderResponse.setTicketPriceAdult(ticket.getTicketPriceAdult());
            orderResponse.setTicketPriceStudent(ticket.getTicketPriceStudent());

            ScenicSpot scenicSpot = scenicSpotDao.selectScenicSpotById(ticket.getScenicSpotId());
            orderResponse.setScenicSpotName(scenicSpot.getScenicSpotName());

            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

}
