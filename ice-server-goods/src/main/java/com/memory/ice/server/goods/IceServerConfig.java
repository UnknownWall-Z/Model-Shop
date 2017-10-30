package com.memory.ice.server.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wall on 2017/10/28.
 */
@SpringBootApplication
@MapperScan("com.memory.ice.server.goods.mapper")
public class IceServerConfig {
    public static void main(String[] args) {
        SpringApplication.run(IceServerConfig.class);
    }

}
