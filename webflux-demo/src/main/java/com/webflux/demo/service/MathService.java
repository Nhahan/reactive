package com.webflux.demo.service;

import com.webflux.demo.dto.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Response findSquare(int input) {
        return new Response(input * input);
    }

    public List<Response> multiplicationTable(int input) {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Response(i * input))
                .collect(Collectors.toList());
    }
}
