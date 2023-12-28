package com.example.microservice2;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class MyController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    Ms1 ms1;
    @GetMapping("/gethi")
    @CircuitBreaker(name = "microservice-one",fallbackMethod = "defaultStores")
    public String hi(HttpServletRequest httpServletRequest)
    {
        logger.info("entry");
        String x=ms1.getname("header from microservice 1");
        logger.info(x);
        return x;
    }
    public String defaultStores(Exception e) {
        System.out.println("entry1");
        return "fall back method";
    }
}


