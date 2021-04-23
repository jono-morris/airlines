package nz.co.airlines.flights.model.web;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    
    @GetMapping(value = "/datetime/{departureDateTime}") 
    public List<Flight> findForDate(@PathVariable("departureDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime) {
        ZonedDateTime zdt = departureDateTime.atZone(ZoneId.systemDefault());
        return flightRespostory.findForDate(Date.from(zdt.toInstant()));
    }
    
    /**
     * All flights departing from a given origin after a given date and time.
     * @param origin the airport the flights leaves from
     * @param departureDateTime the date and time to list flights from 
     * @return the list of scheduled flights departing from the origin
     */
    @GetMapping(value = "/origin/{origin}/datetime/{departureDateTime}") 
    public List<Flight> findDepartingForDate(
            @PathVariable("origin") String origin,
            @PathVariable("departureDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime) {
        ZonedDateTime zdt = departureDateTime.atZone(ZoneId.systemDefault());
        return flightRespostory.findDepartingFromOriginAndDate(origin, Date.from(zdt.toInstant()));
    }
    
    @GetMapping(value = "/origin/{origin}/airline/{airline}")
    public List<Flight> findDepartingforAirline(
            @PathVariable("origin") String origin,
            @PathVariable("airline") String airline) {
        return flightRespostory.findDepartingFromOriginForAirline(origin, airline);
    }
}
