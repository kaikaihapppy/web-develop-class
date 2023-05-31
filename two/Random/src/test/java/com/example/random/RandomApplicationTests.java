package com.example.random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RandomApplicationTests {
    @Value("${tom.age}")

    private int number;

    @Test
    void contextLoads() {
        System.out.println(number);
    }

}
