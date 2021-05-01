package nz.co.airlines.ticket.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRespository extends JpaRepository <Ticket, Integer> {

}   