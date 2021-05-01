package nz.co.airlines.ticket.model.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.ticket.model.Passenger;
import nz.co.airlines.ticket.model.PassengerRespository;

@RequestMapping("/passenger")
@RestController
@RequiredArgsConstructor
@Timed("airlines.passenger")
public class PassengerResource {

    private final PassengerRespository passengerRepository;
 
    @GetMapping(value = "/id/{passengerId}")
    public Optional<Passenger> getPassengerTickets(
            @PathVariable("passengerId") Integer passengerId) {
        return passengerRepository.findById(passengerId);
    }
}
