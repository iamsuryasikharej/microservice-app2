package com.example.microservice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/")

public class MyController {
    @Value("${server.port}")
    String x;
    @GetMapping("/getname")
    public int getName(@RequestHeader("first-request") String header)
    {
        System.out.println("port"+x);
        System.out.println(header+"<><><>");
        return 1/0;
    }
}