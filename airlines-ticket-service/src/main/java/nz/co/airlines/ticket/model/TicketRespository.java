package nz.co.airlines.ticket.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRespository extends JpaRepository <Ticket, Integer> {

    @Query("From Ticket ticket " +
           "inner join ticket.passenger passenger " +
           "where passenger.id = :passengerId")
    List<Ticket> findPassengerTickets(
            @Param("passengerId") String passengerId);
    
}