package com.example.springboot20200107.dao;

import com.example.springboot20200107.mapper.TicketMapper;
import com.example.springboot20200107.pojo.Ticket;
import com.example.springboot20200107.pojo.TicketExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao {
    @Autowired
    private TicketMapper ticketMapper;

    public Integer insertTicket(Ticket ticket){
        return ticketMapper.insert(ticket);
    }

    public Integer updateByIdSelective(Ticket ticket){
        return ticketMapper.updateByPrimaryKey(ticket);
    }

    public Integer deleteByTicketName(String ticketName){
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNameEqualTo(ticketName);
        return ticketMapper.deleteByExample(ticketExample);
    }

    public List<Ticket> selectAllTicket(Integer pageNum){
        PageHelper.startPage(pageNum,5);
        TicketExample ticketExample = new TicketExample();
        List<Ticket> tickets = ticketMapper.selectByExample(ticketExample);
        PageInfo<Ticket> pageInfo = new PageInfo<>(tickets);
        return pageInfo.getList();
    }

    public List<Ticket> selectByTicketName(String ticketName){
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNameLike("%"+ticketName+"%");
        return ticketMapper.selectByExample(ticketExample);
    }

    public List<Ticket> selectByTicketPriceAdult(Double ticketPriceMin,Double ticketPriceMax){
        return ticketMapper.selectByExample(methodAdult(ticketPriceMin, ticketPriceMax));
    }

    public List<Ticket> selectByTicketPriceStudent(Double ticketPriceMin,Double ticketPriceMax){
        return ticketMapper.selectByExample(methodStudent(ticketPriceMin, ticketPriceMax));
    }

    public Ticket selectById(Long tickId){
        return ticketMapper.selectByPrimaryKey(tickId);
    }

    public Long countAllTicket(){
        TicketExample ticketExample = new TicketExample();
        return ticketMapper.countByExample(ticketExample);
    }

    public Long countByTicketPriceAdult(Double ticketPriceMin,Double ticketPriceMax){
        return ticketMapper.countByExample(methodAdult(ticketPriceMin, ticketPriceMax));
    }

    public Long countByTicketPriceStudent(Double ticketPriceMin,Double ticketPriceMax){
        return ticketMapper.countByExample(methodStudent(ticketPriceMin, ticketPriceMax));
    }

    public TicketExample methodStudent(Double ticketPriceMin, Double ticketPriceMax){
        TicketExample ticketExample = new TicketExample();
        if(ticketPriceMin==null){
            ticketExample.createCriteria().andTicketPriceStudentBetween(0.0, ticketPriceMax);
        }else if(ticketPriceMax==null){
            ticketExample.createCriteria().andTicketPriceStudentBetween(ticketPriceMin, Double.MAX_VALUE);
        }else {
            ticketExample.createCriteria().andTicketPriceStudentBetween(ticketPriceMin, ticketPriceMax);
        }
     return ticketExample;
    }

    public TicketExample methodAdult(Double ticketPriceMin, Double ticketPriceMax){
        TicketExample ticketExample = new TicketExample();
        if(ticketPriceMin==null){
            ticketExample.createCriteria().andTicketPriceAdultBetween(0.0, ticketPriceMax);
        }else if(ticketPriceMax==null){
            ticketExample.createCriteria().andTicketPriceAdultBetween(ticketPriceMin, Double.MAX_VALUE);
        }else {
            ticketExample.createCriteria().andTicketPriceAdultBetween(ticketPriceMin, ticketPriceMax);
        }
        return ticketExample;
    }
}
