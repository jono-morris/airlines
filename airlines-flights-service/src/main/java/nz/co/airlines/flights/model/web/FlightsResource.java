package nz.co.airlines.flights.model.web;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.flights.model.Flight;
import nz.co.airlines.flights.model.FlightRepository;

@RequestMapping("/flights")
@RestController
@RequiredArgsConstructor
//@Slf4js
@Timed("airlines.flight")
public class FlightsResource {
    
    private final FlightRepository flightRespostory;

    @GetMapping(value = "/")
    public List<Flight> findAll() {
        return flightRespostory.findAll();
    }
    
    @GetMapping(value = "/origin/{origin}/destination/{destination}/date/{departureDate}") 
    public List<Flight> findDepartingFromOriginForAirline(
            @PathVariable("origin") String origin,
            @PathVariable("destination") String destination,
            @PathVariable("departureDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {
        
        return flightRespostory.findDepartingFromOriginForAirline(
                origin, 
                destination, 
                Date.from(departureDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }        
}
