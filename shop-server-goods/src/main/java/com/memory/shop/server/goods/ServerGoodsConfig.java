package com.memory.shop.server.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zmh on 2017/9/28.
 */
@SpringBootApplication
@MapperScan("com.memory.shop.server.goods.mapper")
@EnableTransactionManagement
public class ServerGoodsConfig {
    public static void main(String[] args) {
        SpringApplication.run(ServerGoodsConfig.class,args);
    }
}
