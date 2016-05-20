package com.aronim.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * User: Kevin W. Sewell
 * Date: 2015-05-29
 * Time: 16h20
 */
@ComponentScan
@SpringBootApplication
@EnableMongoRepositories
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
