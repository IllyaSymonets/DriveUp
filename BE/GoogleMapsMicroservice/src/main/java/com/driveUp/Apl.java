package com.driveUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Apl {
    public static void main(String[] args) {
        SpringApplication.run(Apl.class, args);
    }
}

