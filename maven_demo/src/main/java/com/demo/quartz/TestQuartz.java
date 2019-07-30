package com.demo.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
* @Description:  定时任务
* @Author:       tianjun
* @date:         2019/6/28 17:06
*/
@Component
public class TestQuartz {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestQuartz.class);

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test() {
        LOGGER.info("测试定时任务....................");
    }

}
