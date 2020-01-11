package com.example.springboot20200107.controller;

import com.example.springboot20200107.pojo.Order;
import com.example.springboot20200107.request.AddOrderRequest;
import com.example.springboot20200107.response.OrderResponse;
import com.example.springboot20200107.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    //用户下订单
    @PostMapping(value = "insert/order")
    public String insertOrder(@RequestBody AddOrderRequest addOrderRequest){
        Integer integer = orderService.insertOrder(addOrderRequest);
        if (integer==1){
            return "交易成功";
        }else if(integer==-1){
            return "余额不足";
        }else if(integer==-2){
            return "未选票";
        }
        else return "服务器错误";
    }

    //用户退单
    @PutMapping(value = "chargeBack/order")
    public String chargeBack(Long id) {
        Integer integer = orderService.chargeBack(id);
        if (integer == 1) {
            return "退款成功";
        } else if (integer == 0) {
            return "门票已过期，退款失败";
        }else if(integer==-2){
            return "请勿重复退票";
        }else return "订单有误";
    }

    //通过id删除订单信息
    @DeleteMapping(value = "delete/order")
    public Integer deleteOrder(Long id){
        return orderService.deleteOrder(id);
    }

    //通过id修改订单信息
    @PutMapping(value = "update/order/by/id")
    public Integer updateByIdSelective(@RequestBody Order order,Long id){
        order.setUpdateTime(new Date());
        return orderService.updateByIdSelective(order, id);
    }

    //查找所有的订单
    @GetMapping(value = "select/order/all")
    public List<OrderResponse> selectAllOrder(Integer pageNum){
        return orderService.selectAllOrder(pageNum);
    }

    //通过用户id查找该用户的订单
    @GetMapping(value = "select/order/userId")
    public List<OrderResponse> selectByUserId(Long userId){
        return orderService.selectByUserId(userId);
    }

    //通过门票id查找该景点的所有订单
    @GetMapping(value = "select/order/ticketId")
    public List<OrderResponse> selectByTicketId(Long ticketId){
        return orderService.selectByTicketId(ticketId);
    }

    //查看有多少条订单记录
    @GetMapping(value = "count/all/order")
    public Long countAllOrder(){
        return orderService.countAllOrder();
    }

    //查看该用户下了多少单
    @GetMapping(value = "count/order/userId")
    public Long countByUserId(Long userId){
        return orderService.countByUserId(userId);
    }

    //查看该景点下了多少单
    @GetMapping(value = "count/order/ticketId")
    public Long countByTicketId(Long ticketId){
        return orderService.countByTicketId(ticketId);
    }
}
