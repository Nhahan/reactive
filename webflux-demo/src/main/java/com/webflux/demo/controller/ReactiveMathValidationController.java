package com.webflux.demo.controller;

import com.webflux.demo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReactiveMathValidationController {

    private ReactiveMathService mathService;
}
