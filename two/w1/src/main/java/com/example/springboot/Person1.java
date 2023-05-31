package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person1{
    @Value("${person    .id}")
    private int id;
    @Value("${person.age}")
    private int age;
    @Value("${person.name}")
    private String name;
    @Value("${person.hobby}")
    private List<String> hobby;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
