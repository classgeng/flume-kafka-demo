package com.syslog.demo.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

public class KafkaPartitioner implements Partitioner {
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        System.out.println(s+" -> "+o);
        List<PartitionInfo> partitions = cluster.partitionsForTopic(s);
        // 随机策略
        //return ThreadLocalRandom.current().nextInt(partitions.size());
        // 按key分配分区
        return Math.abs(o.hashCode()) % partitions.size();
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
