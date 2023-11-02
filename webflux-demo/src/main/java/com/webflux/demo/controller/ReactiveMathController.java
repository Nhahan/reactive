package com.webflux.demo.controller;

import com.webflux.demo.dto.Response;
import com.webflux.demo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReactiveMathController {

    private final ReactiveMathService reactiveMathService;

    @GetMapping("/math/square/{input}")
    public Mono<Response> findSquare(@PathVariable int input) {
        return reactiveMathService.findSquare(input);
    }

    @GetMapping("/math/table/{input}")
    public Flux<Response> multiplicationTable(@PathVariable int input) {
        return reactiveMathService.multiplicationTable(input);
    }
}
