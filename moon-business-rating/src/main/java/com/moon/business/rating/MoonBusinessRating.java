package com.moon.business.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MoonBusinessRating {
    public static void main(String[] args) {
        SpringApplication.run(MoonBusinessRating.class, args);
    }
}
