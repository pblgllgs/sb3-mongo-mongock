package com.pblgllgs.mongo;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class MongoMongockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoMongockApplication.class, args);
    }

}
