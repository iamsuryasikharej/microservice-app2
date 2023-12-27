package com.example.springgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		RouteLocator routeLocator=builder.routes()
//				.route(r -> r.path("/getname/**")
//						//Pre and Post Filters provided by Spring Cloud Gateway
////						.filters(f -> f.addRequestHeader("first-request", "first-request-header")
////								.addResponseHeader("first-response", "first-response-header"))
//						.filters(f->f.filter(new Filter1()).addRequestHeader("first-request", "first-request-header"))
//
//						.uri("lb://MICROSERVICE-ONE")
//				)
				.route(r-> r.path("/gethi/**").filters(f->f.filter(new Filter1()))
								.uri("lb://MICROSERVICE-TWO"))

				.build();
		return routeLocator;

//				.route(r -> r.path("/consumer/**")
//						//Pre and Post Filters provided by Spring Cloud Gateway
//						.filters(f -> f.addRequestHeader("second-request", "second-request-header")
//								.addResponseHeader("second-response", "second-response-header"))
//						.uri("http://localhost:8082/")
//						.id("consumerModule"))
	}
}
