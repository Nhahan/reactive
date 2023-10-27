package com.demo.webflux;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Objects;

@WebFluxTest(WebFluxController.class)
public class WebFluxControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Disabled // SSE 로그를 확인해보고 싶다면 @Disabled 를 주석처리하고 실행해주세요
    public void showSseData() {
        webTestClient
                .get()
                .uri("/sse")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/event-stream;charset=UTF-8")
                .returnResult(Long.class)
                .getResponseBody()
                .log()
                .blockLast();
    }

    @Test
    public void sseTest() {
        Flux<Long> expectedFlux = Flux.interval(Duration.ofSeconds(1)).take(1);

        StepVerifier.create(webTestClient
                        .get()
                        .uri("/sse")
                        .exchange()
                        .expectStatus().isOk()
                        .expectHeader().contentType("text/event-stream;charset=UTF-8")
                        .returnResult(Long.class)
                        .getResponseBody())
                .expectNextSequence(Objects.requireNonNull(expectedFlux.collectList().block()))
                .expectAccessibleContext();
    }
}