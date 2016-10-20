package com.moussi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmsClientServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AmsClientServiceApplication.class, args);
  }
}
