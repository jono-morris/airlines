package nz.co.airlines.flights.model.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.flights.model.Airline;
import nz.co.airlines.flights.model.AirlineRepository;

@RequestMapping("/airlines")
@RestController
@RequiredArgsConstructor
@Timed("airlines.airports")
public class AirlineResource {

    private final AirlineRepository airlineRepository;
    
    @GetMapping(value = "/")
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }
}
