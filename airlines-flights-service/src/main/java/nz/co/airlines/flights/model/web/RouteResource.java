package nz.co.airlines.flights.model.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nz.co.airlines.flights.model.Route;
import nz.co.airlines.flights.model.RouteRepository;

@RequestMapping("/route")
@RestController
@RequiredArgsConstructor
//@Slf4js
@Timed("airlines.flight")
public class RouteResource {

    private final RouteRepository routeRespostory;

    @GetMapping(value = "/")
    public List<Route> findAll() {
        return routeRespostory.findAll();
    }
    
    @GetMapping(value = "/time/{time}") 
    public List<Route> findAfterDepartureTime(
            @PathVariable("time")
            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        return routeRespostory.findAfterDepartureTime(localTimeToDate(time));
    }
    
    @GetMapping(value = "/origin/{origin}/time/{time}") 
    public List<Route> findDepartingOriginAfterTime(
            @PathVariable("origin") String origin,
            @PathVariable("time")
            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        return routeRespostory.findDepartingFromOriginAndDate(origin, localTimeToDate(time));
    }
    
    private Date localTimeToDate(LocalTime time) {
        return Date.from(
                time.atDate(LocalDate.now())
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
    
    @GetMapping(value = "/origin/{origin}/airline/{airline}")
    public List<Route> findDepartingforAirline(
            @PathVariable("origin") String origin,
            @PathVariable("airline") String airline) {
        return routeRespostory.findDepartingFromOriginForAirline(origin, airline);
    }
}
