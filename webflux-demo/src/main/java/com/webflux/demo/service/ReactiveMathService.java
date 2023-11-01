package com.webflux.demo.service;

import com.webflux.demo.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> new Response(input * input));
    }
}
