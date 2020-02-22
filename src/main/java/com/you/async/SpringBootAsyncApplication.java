package com.you.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @EnableAsync: 开启异步的支持；
 * @EnableAsync 与 xml配置中 <task:annotation-driven executor="threadPool"/>等效。二者用其一即可。
 * @ImportResource: 导入外部配置文件；
 */
//@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
@EnableAsync
@SpringBootApplication
public class SpringBootAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAsyncApplication.class, args);
    }

}
