package com.ahead.smartlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zqh
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ahead.**.mapper")
public class SmartlockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartlockServerApplication.class, args);
    }

}
