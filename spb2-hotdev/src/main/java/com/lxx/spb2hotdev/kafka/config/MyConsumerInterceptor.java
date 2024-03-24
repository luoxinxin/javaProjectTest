package com.lxx.spb2hotdev.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Map;

/**
 * kafka消费消息拦截器
 */
public class MyConsumerInterceptor implements ConsumerInterceptor<String, String> {

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        // 在消息被消费前进行拦截和处理
        // 可以对消息进行修改、过滤或记录
        System.out.println("Consuming records: " + records);
        return records;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
        // 在消息被消费者提交消费位移之后进行拦截和处理
        // 可以记录消费位移信息或执行其他操作
        System.out.println("Committing offsets: " + offsets);
    }

    @Override
    public void close() {
        // 关闭拦截器，执行一些清理工作
    }

    @Override
    public void configure(Map<String, ?> configs) {
        // 配置拦截器，可以从配置中获取一些参数
    }
}

