package com.cmx.dbasy.log4j;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
@Slf4j
public class Log4jApplication {
//    private final static Logger log = (Logger) LoggerFactory.getLogger(Log4jApplication.class);

    public static void main(String[] args) {
        log.info("1111");
        SpringApplication.run(Log4jApplication.class, args);
        log.info("2222");
    }

}
