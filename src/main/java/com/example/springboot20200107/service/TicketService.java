package com.example.springboot20200107.service;

import com.example.springboot20200107.pojo.Ticket;
import com.example.springboot20200107.request.AddTicketRequest;
import com.example.springboot20200107.request.UpdateTicketRequest;
import com.example.springboot20200107.response.TicketResponse;

import java.util.List;

public interface TicketService {

    Integer insertTicket(AddTicketRequest addTicketRequest);
    Integer updateByIdSelective(UpdateTicketRequest updateTicketRequest,Long id);
    Integer deleteByTicketName(String ticketName);
    List<TicketResponse> selectAllTicket(Integer pageNum);
    List<TicketResponse> selectByTicketName(String ticketName);
    List<TicketResponse> selectByTicketPriceAdult(Double ticketPriceMin, Double ticketPriceMax);
    List<TicketResponse> selectByTicketPriceStudent(Double ticketPriceMin,Double ticketPriceMax);
    Long countAllTicket();
    Long countByTicketPriceAdult(Double ticketPriceMin, Double ticketPriceMax);
    Long countByTicketPriceStudent(Double ticketPriceMin,Double ticketPriceMax);
}
