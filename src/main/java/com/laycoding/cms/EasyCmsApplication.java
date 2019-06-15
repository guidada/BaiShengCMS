package com.laycoding.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//启动类
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableTransactionManagement
public class EasyCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyCmsApplication.class, args);
    }

}
