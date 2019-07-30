package com.demo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
* @Description:  项目启动监听
* @Author:       tianjun
* @date:         2019/6/28 16:57
*/
@Component
public class InstantiationTracingBeanPostProcessor implements
        ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

    @Override
    @SuppressWarnings("all")
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")) {
            // root application context 没有parent，他就是老大.
            // 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            logger.info("parent");
            ApplicationContext ac = event.getApplicationContext();
            String[] beanNameArray = ac.getBeanDefinitionNames();
            for (int i = 0; i < beanNameArray.length; i++) {
                if (logger.isInfoEnabled()) {
                    logger.info("parent bean 【" + beanNameArray[i] + "】 init ok");
                } else {
                    logger.info("parent bean 【" + beanNameArray[i] + "】 init ok");
                }
            }
        } else {
            logger.info("child");
            ApplicationContext ac = event.getApplicationContext();
            String[] beanNameArray = ac.getBeanDefinitionNames();
            for (int i = 0; i < beanNameArray.length; i++) {
                if (logger.isInfoEnabled()) {
                    logger.info("mvc bean 【" + beanNameArray[i] + "】 init ok");
                }else {
                    logger.info("parent bean 【" + beanNameArray[i] + "】 init ok");
                }
            }
        }
        logger.info("spring bean 初始化完成");
    }
}