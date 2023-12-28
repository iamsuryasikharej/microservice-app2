package com.example.microservice1;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@RestController
@RequestMapping("/")

public class MyController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Value("${server.port}")
    String x;
    @GetMapping("/getname")
    public String getName(@RequestHeader("first-request") String header, HttpServletRequest httpServletRequest)
    {
        Enumeration enumeration=httpServletRequest.getHeaderNames();
        while(enumeration.hasMoreElements())
        {
            logger.info(httpServletRequest.getHeader(enumeration.nextElement().toString()).toString());
        }
        logger.info("port"+x);
        logger.info(header+"<><><>");
        return "hello";
    }
}