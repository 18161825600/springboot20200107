package com.example.springboot20200107.response;

import lombok.Data;

@Data
public class TicketResponse {

    private String ticketName;

    private Double ticketPriceAdult;

    private Double ticketPriceStudent;

    private Integer ticketNumberAdult;

    private Integer ticketNumberStudent;

    private String ticketDescribe;

    private Long totalTicket;
}
