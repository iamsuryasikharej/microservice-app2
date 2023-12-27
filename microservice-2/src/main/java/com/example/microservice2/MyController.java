package com.example.microservice2;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/")
public class MyController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/getname")
    public List<String> getName() {
        String URL=discoveryClient.getInstances("MICROSERVICE-1").get(0).getUri().toString();
        System.out.println(URL);
        HashMap<String,String> stringStringHashMap=new HashMap<>();
        List<Application> applicationList = eurekaClient.getApplications().getRegisteredApplications();
        for (Application application : applicationList) {
            List<InstanceInfo> applicationsInstances = application.getInstances();
            for (InstanceInfo applicationsInstance : applicationsInstances) {

                String name = applicationsInstance.getAppName();
                String url = applicationsInstance.getHomePageUrl();
                stringStringHashMap.put(name, url);
                System.out.println(name + ": " + url);
            }
    }
        List l=new ArrayList();
        for (int i = 20; i < 40; i++) {
            String url=stringStringHashMap.get("MICROSERVICE-1");
           String x= restTemplate.getForObject(URL+"/getname", String.class);
            l.add(x);
        }

        return l;

    }
}
