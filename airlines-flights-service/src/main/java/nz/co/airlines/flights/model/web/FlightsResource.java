package nz.co.airlines.flights.model.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import nz.co.airlines.flights.model.RouteRepository;

@RequestMapping("/flights")
@RestController
@RequiredArgsConstructor
//@Slf4js
@Timed("airlines.flight")
public class FlightsResource {
    
    private final RouteRepository routeRepository;
    
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
}
