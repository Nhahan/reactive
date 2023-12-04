package com.webflux.demo.controller;

import com.webflux.demo.dto.Response;
import com.webflux.demo.exception.InputValidationException;
import com.webflux.demo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReactiveMathValidationController {

    private ReactiveMathService mathService;

    @GetMapping("/reactive-math/square/{input}/throw")
    public Mono<Response> findSquare(@PathVariable int input) {
        if (input < 10 || input >= 20) throw new InputValidationException(input);
        return mathService.findSquare(input);
    }

    @GetMapping("/reactive-math/square/{input}/mono-error")
    public Mono<Response> monoError(@PathVariable int input) {
        return Mono.just(input)
                .handle((integer, sink) -> {
                    if (integer >= 10 && integer >= 20) {
                        sink.next(integer);
                    } else {
                        sink.error(new InputValidationException(integer));
                    }
                })
                .cast(Integer.class)
                .flatMap(i -> mathService.findSquare(i));
    }

    @GetMapping("/reactive-math/square/{input}/sample")
    public Mono<ResponseEntity<Response>> sample(@PathVariable int input) {
        return Mono.just(input)
                .filter(i -> i >= 10 && i <= 20)
                .flatMap(i -> mathService.findSquare(i))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}