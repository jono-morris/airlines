package nz.co.airlines.flights.model.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.flights.model.FlightRepository;
import nz.co.airlines.flights.model.Route;
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
    public List<Route> findAll() {
        return routeRepository.findAll();
    }
    
//    @GetMapping(value = "/{flightnum}")
//    public Optional<Route> findFlight(@PathVariable("flightnum") int flightnum) {
//        return routeRepostory.findAll(flightnum);
//    }
}
