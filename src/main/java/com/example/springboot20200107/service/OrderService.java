package com.example.springboot20200107.service;

import com.example.springboot20200107.pojo.Order;
import com.example.springboot20200107.request.AddOrderRequest;
import com.example.springboot20200107.response.OrderResponse;

import java.util.List;

public interface OrderService {

    Integer insertOrder(AddOrderRequest addOrderRequest);
    Integer deleteOrder(Long id);
    Integer updateByIdSelective(Order order, Long id);
    List<OrderResponse> selectAllOrder(Integer pageNum);
    List<OrderResponse> selectByUserId(Long userId);
    List<OrderResponse> selectByTicketId(Long ticketId);
    Long countAllOrder();
    Long countByUserId(Long userId);
    Long countByTicketId(Long ticketId);
    Integer chargeBack(Long id);

}
