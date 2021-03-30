package nz.co.airlines.flights.model.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.flights.model.Airport;
import nz.co.airlines.flights.model.AirportRepository;

@RequestMapping("/airports")
@RestController
@RequiredArgsConstructor
@Timed("airlines.airports")
public class AirportResource {

    private final AirportRepository airportRepository;
    
    @GetMapping(value = "/")
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }
}
