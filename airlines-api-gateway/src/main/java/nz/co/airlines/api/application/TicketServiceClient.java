package nz.co.airlines.api.application;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import nz.co.airlines.api.dto.TicketDetails;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TicketServiceClient {

    private final WebClient.Builder webClientBuilder;
    
    public Mono<TicketDetails> getOwner(final int ownerId) {
        return webClientBuilder.build().get()
            .uri("http://ticket-service/ticket/{ticketId}", ownerId)
            .retrieve()
            .bodyToMono(TicketDetails.class);
    }
}
