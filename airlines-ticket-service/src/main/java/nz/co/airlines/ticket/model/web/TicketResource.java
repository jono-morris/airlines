package nz.co.airlines.ticket.model.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.ticket.model.Ticket;
import nz.co.airlines.ticket.model.TicketRespository;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
@Timed("airlines.ticket")
public class TicketResource {

    private final TicketRespository ticketRepository;
    
    @GetMapping(value = "/")
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
    
    @GetMapping(value = "/passenger/{passengerId}")
    public List<Ticket> getPassengerTickets(
            @PathVariable("passengerId") Integer passengerId) {
        return ticketRepository.findPassengerTickets(passengerId);
    }
    
}
