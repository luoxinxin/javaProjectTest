package com.lxx.spb2hotdev.kafka.test;

import org.apache.kafka.clients.consumer.*;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerTest {
    public static void main(String[] args) {
        consumer();
    }

    public static void consumer(){
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "default-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, "com.lxx.spb2hotdev.kafka.config.MyConsumerInterceptor");

        // 创建 Kafka 消费者
        Consumer<String, String> consumer = new KafkaConsumer<>(props);


        // 订阅主题
        consumer.subscribe(Collections.singletonList("test"));

        // 消费消息
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("消费消息");
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
                consumer.commitSync();
            }
        } finally {
            // 关闭消费者
            consumer.close();
        }

    }
}
