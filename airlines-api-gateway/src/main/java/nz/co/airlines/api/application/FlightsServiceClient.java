package nz.co.airlines.api.application;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FlightsServiceClient {

    private final WebClient.Builder webClientBuilder;
}
