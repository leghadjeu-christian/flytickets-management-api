package com.example.restapi.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.rest_api.model.FlyTickets;
import com.example.restapi.rest_api.repository.FlyTicketRepository;

@Service
public class FlyTicketService {
    
    private final FlyTicketRepository flyTicketRepository;
    
    @Autowired
    public FlyTicketService(FlyTicketRepository flyTicketRepository) {
        this.flyTicketRepository = flyTicketRepository;
    }
    
    public List<FlyTickets> getAllTickets() {
        return flyTicketRepository.findAll();
    }
    
    public Optional<FlyTickets> getTicketById(Long id) {
        return flyTicketRepository.findById(id);
    }
    
    public FlyTickets createTicket(FlyTickets ticket) {
        return flyTicketRepository.save(ticket);
    }
    
    public void deleteTicket(Long id) {
        if (flyTicketRepository.existsById(id)) {
            flyTicketRepository.deleteById(id);
        } else {
            throw new RuntimeException("FlyTicket not found with id: " + id);
        }
    }}