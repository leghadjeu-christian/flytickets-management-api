package com.example.restapi.rest_api.controller;

import com.example.restapi.rest_api.model.FlyTickets;
import com.example.restapi.rest_api.service.FlyTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flytickets")
public class FlyTicketController {

    @Autowired
    private FlyTicketService flyTicketService;

    @GetMapping
    public List<FlyTickets> getAllTickets() {
        return flyTicketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlyTickets> getTicketById(@PathVariable Long id) {
        Optional<FlyTickets> ticket = flyTicketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FlyTickets createTicket(@RequestBody FlyTickets ticket) {
        return flyTicketService.createTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        flyTicketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}