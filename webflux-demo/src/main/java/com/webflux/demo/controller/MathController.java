package com.webflux.demo.controller;

import com.webflux.demo.dto.Response;
import com.webflux.demo.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;

    @GetMapping("/math/square/{input}")
    public Response findSquare(@PathVariable int input) {
        return mathService.findSquare(input);
    }

    @GetMapping("/math/table/{input}")
    public List<Response> multiplicationTable(@PathVariable int input) {
        return mathService.multiplicationTable(input);
    }
}
