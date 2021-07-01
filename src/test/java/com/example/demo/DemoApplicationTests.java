package com.example.demo;

import com.example.demo.entity.Dog;
import com.example.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
     private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
