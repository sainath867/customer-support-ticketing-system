package com.example.ticketing.service;

import com.example.ticketing.entity.Ticket;
import com.example.ticketing.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repo;

    public Ticket createTicket(Ticket ticket) {
        ticket.setStatus("OPEN");
        return repo.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    public Ticket updateTicketStatus(Long id, String status) {
        Ticket ticket = repo.findById(id).orElseThrow();
        ticket.setStatus(status);
        return repo.save(ticket);
    }

    public Ticket assignAgent(Long id, String agent) {
        Ticket ticket = repo.findById(id).orElseThrow();
        ticket.setAssignedTo(agent);
        return repo.save(ticket);
    }
}
