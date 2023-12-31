package com.webflux.demo.service;

import com.webflux.demo.dto.MultiplyRequestDto;
import com.webflux.demo.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> new Response(input * input));
    }

    public Flux<Response> multiplicationTable(int input) {
        return Flux.range(1, 10)
                .delayElements(java.time.Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("reactive math-service processing: " + i))
                .map(i -> new Response(i * input));
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> requestDtoMono) {
        return requestDtoMono
                .map(requestDto -> requestDto.getFirst() * requestDto.getSecond())
                .map(Response::new);
    }
}
