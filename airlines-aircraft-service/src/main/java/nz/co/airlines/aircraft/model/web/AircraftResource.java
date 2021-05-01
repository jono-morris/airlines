package nz.co.airlines.aircraft.model.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.aircraft.model.Aircraft;
import nz.co.airlines.aircraft.model.AircraftRepository;

@RequestMapping("/aircraft")
@RestController
@RequiredArgsConstructor
@Timed("airlines.aircraft")
public class AircraftResource {

    private final AircraftRepository aircraftRepository;
    
    @GetMapping(value = "/flight/{flightId}")
    public Aircraft findByFlightIdAndFetchSeats(
            @PathVariable("flightId") Integer flightId) {
        
        return aircraftRepository.findByFlightIdAndFetchSeats(flightId);
    }
    
    @GetMapping(value = "/flight/{flightId}/freeseats")
    public Integer findByFlightId(
            @PathVariable("flightId") Integer flightId) {
        return aircraftRepository.findByFlightId(flightId).freeSeats();
    }
}
