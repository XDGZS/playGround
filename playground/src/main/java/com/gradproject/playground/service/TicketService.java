package com.gradproject.playground.service;

import com.gradproject.playground.entity.Ticket;
import com.gradproject.playground.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketMapper ticketMapper;
    private List<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

    private void find() {
        tickets.clear();
        tickets = ticketMapper.findAll();
    }

    public List<Ticket> findByUser(int userId) {
        return ticketMapper.findByUserId(userId);
    }
}
