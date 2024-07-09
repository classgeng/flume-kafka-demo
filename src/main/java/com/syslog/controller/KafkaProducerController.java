package com.syslog.controller;

import com.syslog.common.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("message/send")
    public String sendMsg(String msg){
        System.out.println(msg);
        //使用kafka模板发送信息
        kafkaTemplate.send(AppConstants.KAFKA_FLUME_TOPIC, msg);
        return "success";
    }

}
