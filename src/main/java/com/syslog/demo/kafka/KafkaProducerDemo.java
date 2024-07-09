package com.syslog.demo.kafka;

import com.syslog.common.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutionException;

@Component
public class KafkaProducerDemo {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void send() throws ExecutionException, InterruptedException {
        //使用kafka模板发送信息
        for(int i=0;i<100;i++){
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(AppConstants.KAFKA_FLUME_TOPIC, 1,i+"", "Holle Word！");
            System.out.println("[send result]" + result.get().toString());
        }
    }

}
