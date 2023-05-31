package com.example.springboot;
import com.example.springboot.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests1 {
    @Autowired
    private Person1 person;
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
