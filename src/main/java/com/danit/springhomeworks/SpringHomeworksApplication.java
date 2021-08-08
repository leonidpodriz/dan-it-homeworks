package com.danit.springhomeworks;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class SpringHomeworksApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringHomeworksApplication.class, args);
    }
}
