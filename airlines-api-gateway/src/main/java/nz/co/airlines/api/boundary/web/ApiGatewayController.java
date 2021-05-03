package nz.co.airlines.api.boundary.web;

import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nz.co.airlines.api.boundary.web.api.dto.BoardingPassDetails;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class ApiGatewayController {

    private final ReactiveCircuitBreakerFactory cbFactory;
    
    @GetMapping(value = "ticket/{ticketId}")
    public Mono<BoardingPassDetails> getBoardingPassDetailsForTicket(final @PathVariable int ticketId) {
        return null;
    }
}
