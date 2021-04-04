package nz.co.airlines.flights.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    
    @Query("From Flight flight WHERE flight.departureDateTime > :departureDateTime")
    List<Flight> findForDate(@Param("departureDateTime") Date departureDateTime);
}

