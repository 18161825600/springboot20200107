package com.example.springboot20200107.request;

import lombok.Data;

@Data
public class UpdateTicketRequest {

    private Double ticketPriceAdult;

    private Double ticketPriceStudent;

    private Integer ticketNumberAdult;

    private Integer ticketNumberStudent;

    private String ticketDescribe;
}
