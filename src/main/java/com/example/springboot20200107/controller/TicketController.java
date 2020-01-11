package com.example.springboot20200107.controller;

import com.example.springboot20200107.pojo.Ticket;
import com.example.springboot20200107.request.AddTicketRequest;
import com.example.springboot20200107.request.UpdateTicketRequest;
import com.example.springboot20200107.response.TicketResponse;
import com.example.springboot20200107.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    //添加门票
    @PostMapping(value = "insert/ticket")
    public Integer insertTicket(@RequestBody AddTicketRequest addTicketRequest){
        return ticketService.insertTicket(addTicketRequest);
    }

    //通过门票名称修改门票
    @PutMapping(value = "update/ticket/by/id")
    public Integer updateByIdSelective(@RequestBody UpdateTicketRequest updateTicketRequest, Long id){
        return ticketService.updateByIdSelective(updateTicketRequest, id);
    }

    //通过门票名称删除门票
    @DeleteMapping(value = "delete/ticket")
    public Integer deleteByTicketName(String ticketName){
        return ticketService.deleteByTicketName(ticketName);
    }

    //查找全部门票信息
    @GetMapping(value = "select/all/ticket")
    public List<TicketResponse> selectAllTicket(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        return ticketService.selectAllTicket(pageNum);
    }

    //通过门票名称查找门票信息
    @GetMapping(value = "select/By/ticket/name")
    public List<TicketResponse> selectByTicketName(String ticketName){
        return ticketService.selectByTicketName(ticketName);
    }

    //通过成人票价格查找门票
    @GetMapping(value = "select/by/ticket/adultPrice")
    public List<TicketResponse> selectByTicketPriceAdult(Double ticketPriceMin,Double ticketPriceMax){
        return ticketService.selectByTicketPriceAdult(ticketPriceMin, ticketPriceMax);
    }

    //通过学生票价格查找门票
    @GetMapping(value = "select/by/ticket/studentPrice")
    public List<TicketResponse> selectByTicketPriceStudent(Double ticketPriceMin,Double ticketPriceMax){
        return ticketService.selectByTicketPriceStudent(ticketPriceMin, ticketPriceMax);
    }

    //查找有多少条门票信息
    @GetMapping(value = "count/all/ticket")
    public Long countAllTicket(){
        return ticketService.countAllTicket();
    }

    //通过成人票价格查找有多少条门票信息
    @GetMapping(value = "count/ticket/adultPrice")
    public Long countByTicketPriceAdult(Double ticketPriceMin,Double ticketPriceMax){
        return ticketService.countByTicketPriceAdult(ticketPriceMin, ticketPriceMax);
    }

    //通过学生票价格查找有多少条门票信息
    @GetMapping(value = "count/ticket/studentPrice")
    public Long countByTicketPriceStudent(Double ticketPriceMin,Double ticketPriceMax){
        return ticketService.countByTicketPriceStudent(ticketPriceMin, ticketPriceMax);
    }
}
