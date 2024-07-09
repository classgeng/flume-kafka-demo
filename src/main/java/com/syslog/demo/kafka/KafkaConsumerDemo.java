package com.syslog.demo.kafka;

import com.syslog.common.AppConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerDemo {

    /**
     * 配置topic和分区,可以配置多个
     * topic为队列名称
     * partitions表示值的的分区，这里指定了0和2分区
     * partitionOffsets表示详细的指定分区，partition表示那个分区，initialOffset表示Offset的初始位置
     */
    @KafkaListener(topicPartitions ={@TopicPartition(topic = AppConstants.KAFKA_FLUME_TOPIC,partitions = { "0","1","2","3" })})
    public void consumer(ConsumerRecord<?, ?> record) {
        System.out.printf("topic is %s, partition is %d, offset is %d, value is %s \n", record.topic(), record.partition(),record.offset(), record.value());
        //Thread.sleep(10*1000);
    }

}
