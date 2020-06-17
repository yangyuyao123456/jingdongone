package com.yyy.jingdongnew;

import com.yyy.jingdongnew.handler.SpiderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class JingdongnewApplication {
    @Autowired
    private SpiderHandler spiderHandler;
    public static void main(String[] args) {
        SpringApplication.run(JingdongnewApplication.class, args);
    }
    @PostConstruct
    public void task() {
        spiderHandler.spiderData();
    }
}
