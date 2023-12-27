package com.example.springgateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class Filter1 implements GatewayFilter {
    final Logger logger =
            LoggerFactory.getLogger(Filter1.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("filter 1");
        logger.info("filter1");

        return chain.filter(exchange);
    }
}
