package com.example.chapter06_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter061Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter061Application.class, args);
    }

}
