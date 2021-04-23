package nz.co.airlines.flights.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    
    @Query("From Flight flight WHERE flight.departureDateTime > :departureDateTime")
    List<Flight> findForDate(@Param("departureDateTime") Date departureDateTime);

    @Query("From Flight flight " +
           "inner join flight.route as route " +
           "inner join route.origin as origin " +
           "WHERE flight.departureDateTime > :departureDateTime " +
           "AND origin.code = :origin")
    List<Flight> findDepartingFromOriginAndDate(
            @Param("origin") String origin,
            @Param("departureDateTime") Date departureDateTime);
    
    
    @Query("From Flight flight " +
            "inner join flight.route as route " +
            "inner join route.origin as origin " +
            "inner join route.operator as operator " +
            "where origin.code = :origin " + 
            "and operator.code = :operator")    
    List<Flight> findDepartingFromOriginForAirline(
            @Param("origin") String origin,
            @Param("operator") String airline);
}
