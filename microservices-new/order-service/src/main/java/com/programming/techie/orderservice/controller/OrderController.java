package com.programming.techie.orderservice.controller;

import com.programming.techie.orderservice.dto.OrderRequest;
import com.programming.techie.orderservice.service.OrderService;
import io.github.resiliance4j.circuitBreaker.annotation.CircuitBreaker;
import io.github.resiliance4j.retry.annotation.Retry;
import io.github.resiliance4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import com.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController{

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Something went wrong, please order later");
    }
}

// body field for postman when testing:

// {
//     "orderLineItemsDtoList":[
//         {
//             "skuCode":"iphone_13",
//             "price":1200,
//             "quantity":1
//         }
//     ]
// }