package nz.co.airlines.aircraft.model.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.aircraft.model.Seat;
import nz.co.airlines.aircraft.model.SeatRepository;

@RequestMapping("/seat")
@RestController
@RequiredArgsConstructor
@Timed("airlines.seat")
public class SeatResource {
    
    private final SeatRepository seatRepository;
    
    @GetMapping(value = "/boardingpass/{boardingPassId}")
    public Seat findByBoardingPassId(
        @PathVariable("boardingPassId") Integer boardingPassId) {
            return seatRepository.findByBoardingPassId(boardingPassId);
        }
}
