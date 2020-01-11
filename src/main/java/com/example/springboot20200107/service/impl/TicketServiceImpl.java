package com.example.springboot20200107.service.impl;

import com.example.springboot20200107.dao.TicketDao;
import com.example.springboot20200107.pojo.Ticket;
import com.example.springboot20200107.request.AddTicketRequest;
import com.example.springboot20200107.request.UpdateTicketRequest;
import com.example.springboot20200107.response.TicketResponse;
import com.example.springboot20200107.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public Integer insertTicket(AddTicketRequest addTicketRequest) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(addTicketRequest,ticket);
        ticket.setCreateTime(new Date());
        return ticketDao.insertTicket(ticket);
    }

    @Override
    public Integer updateByIdSelective(UpdateTicketRequest updateTicketRequest,Long id) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(updateTicketRequest,ticket);
        ticket.setId(id);
        ticket.setUpdateTime(new Date());
        return ticketDao.updateByIdSelective(ticket);
    }

    @Override
    public Integer deleteByTicketName(String ticketName) {
        return ticketDao.deleteByTicketName(ticketName);
    }

    @Override
    public List<TicketResponse> selectAllTicket(Integer pageNum) {
        List<Ticket> tickets = ticketDao.selectAllTicket(pageNum);
        List<TicketResponse> search = search(tickets);
        for (TicketResponse t:search) {
            t.setTotalTicket(ticketDao.countAllTicket());
        }
        return search;
    }

    @Override
    public List<TicketResponse> selectByTicketName(String ticketName) {
        List<Ticket> tickets = ticketDao.selectByTicketName(ticketName);
        return search(tickets);
    }

    @Override
    public List<TicketResponse> selectByTicketPriceAdult(Double ticketPriceMin, Double ticketPriceMax) {
        List<Ticket> tickets = ticketDao.selectByTicketPriceAdult(ticketPriceMin, ticketPriceMax);
        List<TicketResponse> search = search(tickets);
        for (TicketResponse t:search) {
            t.setTotalTicket(ticketDao.countByTicketPriceAdult(ticketPriceMin, ticketPriceMax));
        }
        return search;
    }

    @Override
    public List<TicketResponse> selectByTicketPriceStudent(Double ticketPriceMin, Double ticketPriceMax) {
        List<Ticket> tickets = ticketDao.selectByTicketPriceStudent(ticketPriceMin, ticketPriceMax);
        List<TicketResponse> search = search(tickets);
        for (TicketResponse t:search) {
            t.setTotalTicket(ticketDao.countByTicketPriceStudent(ticketPriceMin, ticketPriceMax));
        }
        return search;
    }

    @Override
    public Long countAllTicket() {
        return ticketDao.countAllTicket();
    }

    @Override
    public Long countByTicketPriceAdult(Double ticketPriceMin, Double ticketPriceMax) {
        return ticketDao.countByTicketPriceAdult(ticketPriceMin, ticketPriceMax);
    }

    @Override
    public Long countByTicketPriceStudent(Double ticketPriceMin, Double ticketPriceMax) {
        return ticketDao.countByTicketPriceStudent(ticketPriceMin, ticketPriceMax);
    }

    public List<TicketResponse> search(List<Ticket> tickets){
        List<TicketResponse> ticketResponseList = new ArrayList<>();
        for (Ticket ticket:tickets) {
            TicketResponse ticketResponse = new TicketResponse();
            BeanUtils.copyProperties(ticket,ticketResponse);
            ticketResponseList.add(ticketResponse);
        }
        return ticketResponseList;
    }
}
