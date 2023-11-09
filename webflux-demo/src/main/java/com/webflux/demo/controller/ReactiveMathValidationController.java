package com.webflux.demo.controller;

import com.webflux.demo.dto.Response;
import com.webflux.demo.exception.InputValidationException;
import com.webflux.demo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
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
}
