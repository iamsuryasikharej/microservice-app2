package com.example.microservice2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("MICROSERVICE-ONE")
public interface Ms1 {
    @GetMapping("/getname")
    public String getname(@RequestHeader("first-request") String token);
}
