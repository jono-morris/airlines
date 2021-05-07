package nz.co.airlines.flights.model.web;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    
    @GetMapping(value = "/flight/{flightId}")
    public Optional<Flight> findFlightDetailsById(
            @PathVariable("flightId") int flightId) {
        
        return flightRespostory.findById(flightId);
    }
}
