package com.karuna.tally;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TallyBootApplication {

    private static final Logger logger = LoggerFactory.getLogger(TallyBootApplication.class);

    public static void main(String... args) {
        SpringApplication.run(TallyBootApplication.class, args);
    }

    @PostConstruct
    private void init() {
        logger.info("TallyBootApplication init...");
    }

}
