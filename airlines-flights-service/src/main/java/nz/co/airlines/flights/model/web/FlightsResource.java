package nz.co.airlines.flights.model.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
    
//    @GetMapping(value = "/")
//    public List<Route> findAll() {
//        return routeRepository.findAll();
//    }
    
}
