package com.demo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
* @Description: 项目启动后立即初始化
* @Author:       tianjun
* @date:         2019/6/28 17:00
*/
@Component
public class InitRunner implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(InitRunner.class);

    @Override
    @Order(1) //从小到大的顺序执行
    public void run(String... strings) throws Exception {
        LOGGER.info("开始加载初始化信息（比如说初始信息到redis中）-------------");
    }
}
