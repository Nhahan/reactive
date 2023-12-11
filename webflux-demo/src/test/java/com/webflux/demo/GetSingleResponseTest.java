package com.webflux.demo;

import com.webflux.demo.dto.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GetSingleResponseTest extends BaseTest {

    @Autowired
    private WebClient webClient;

    @Test
    public void blockTest() {
        Response response = webClient
                .get()
                .uri("router/square/{number}", 5)
                .retrieve()
                .bodyToMono(Response.class) // Mono<Response>
                .block();

        System.out.println("response: " + response);
    }

    @Test
    public void stepVerifierTest() {
        Mono<Response> responseMono = webClient
                .get()
                .uri("router/square/{number}", 5)
                .retrieve()
                .bodyToMono(Response.class);// Mono<Response>
    }

}
