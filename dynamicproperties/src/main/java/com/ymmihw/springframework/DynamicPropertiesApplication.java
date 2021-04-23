package com.ymmihw.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DynamicPropertiesApplication {

  public static void main(String[] args) {
    SpringApplication.run(DynamicPropertiesApplication.class, args);
  }
}
