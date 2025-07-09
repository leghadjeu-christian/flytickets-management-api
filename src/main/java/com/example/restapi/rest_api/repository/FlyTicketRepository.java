package com.example.restapi.rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.rest_api.model.FlyTickets;

@Repository
public interface  FlyTicketRepository extends JpaRepository<FlyTickets, Long> {
    
}
