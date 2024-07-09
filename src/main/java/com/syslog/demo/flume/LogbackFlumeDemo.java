package com.syslog.demo.flume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class LogbackFlumeDemo implements InitializingBean {

    @PostConstruct
    public void postConstruct() throws InterruptedException {
        for (int i=0;i<10;i++) {
            log.info("[postConstruct]我是第 "+i+" 条消息！");
            //Thread.sleep(2000);
        }
    }

    @Override
    public void afterPropertiesSet() throws InterruptedException {
        for (int i=0;i<10;i++) {
            log.info("[afterPropertiesSet]我是第 "+i+" 条消息！");
            //Thread.sleep(2000);
        }
    }

    @Bean
    public void bean() throws InterruptedException {
        for (int i=0;i<10;i++) {
            log.info("[bean]我是第 "+i+" 条消息！");
            //Thread.sleep(2000);
        }
    }

}
