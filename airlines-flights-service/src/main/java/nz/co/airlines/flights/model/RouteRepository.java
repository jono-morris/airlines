package nz.co.airlines.flights.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends JpaRepository<Route, Integer> { 
    
    @Query("from Route route " + 
           "where route.scheduledDepartureTime > :time")
    List<Route> findAfterDepartureTime(@Param("time") Date time);

    @Query("from Route route " +
           "inner join route.origin as origin " +
           "where route.scheduledDepartureTime > :time " +
           "and"
           + " origin.code = :origin")
    List<Route> findDepartingFromOriginAndDate(
            @Param("origin") String origin,
            @Param("time") Date time);
    
    @Query("from Route route " +
           "inner join route.origin as origin " +
           "inner join route.operator as operator " +
           "where origin.code = :origin " + 
           "and operator.code = :operator")    
    List<Route> findDepartingFromOriginForAirline(
            @Param("origin") String origin,
            @Param("operator") String airline);
}