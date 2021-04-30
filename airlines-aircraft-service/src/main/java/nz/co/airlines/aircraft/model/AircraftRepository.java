package nz.co.airlines.aircraft.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer>  {

    
    @Query("from Aircraft aircraft " +
           "left join fetch aircraft.seats " +
            "where aircraft.flightId = :flightId")
    Aircraft findByFlightIdAndFetchSeats(
          @Param("flightId") Integer flightId);
    
    Aircraft findByFlightId(Integer flightId);
}
