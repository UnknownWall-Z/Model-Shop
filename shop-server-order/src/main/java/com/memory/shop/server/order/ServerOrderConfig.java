package com.memory.shop.server.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zmh on 2017/9/28.
 */
@SpringBootApplication
@MapperScan("com.memory.shop.server.order.mapper")
@EnableTransactionManagement
public class ServerOrderConfig {
    public static void main(String[] args) {
        SpringApplication.run(ServerOrderConfig.class,args);
    }
}
