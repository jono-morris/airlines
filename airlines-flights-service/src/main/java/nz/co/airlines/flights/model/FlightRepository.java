package nz.co.airlines.flights.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    
    @Query("from Flight flight " +
           "inner join flight.route as route " +
           "inner join route.origin as origin " +
           "inner join route.destination as destination " +
           "where origin.code = :origin " + 
           "and destination.code = :destination " +
           "and flight.departureDate = :departureDate")    
    List<Flight> findDepartingFromOriginForAirline(
            @Param("origin") String origin,
            @Param("destination") String destination,
            @Param("departureDate") Date departureDate);
}
