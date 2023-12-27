package com.example.springgateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class GlobalFilter implements org.springframework.cloud.gateway.filter.GlobalFilter {

    final Logger logger =
            LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {
        logger.info("Global Pre Filter executed");
        return chain.filter(exchange);
    }


}