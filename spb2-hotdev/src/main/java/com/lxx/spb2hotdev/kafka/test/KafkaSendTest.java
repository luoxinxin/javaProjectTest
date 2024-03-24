package com.lxx.spb2hotdev.kafka.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaSendTest {
    public static void main(String[] args) {
        sendMessagePartition("test", "hello world", 0);
//        sendMessagePartition("test", "hello world1", 1);
//        sendMessagePartition("test", "hello world2", 2);
    }


    /**
     * kafka发送消息，带分区参数
     * @param topic
     * @param message
     * @param partition
     */
    private static void sendMessagePartition(String topic, String message, int partition) {
        // 设置 Kafka 生产者的配置参数
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, "com.lxx.spb2hotdev.kafka.config.MyProducerInterceptor");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, partition, null, message);
        producer.send(record);
        producer.close();
    }

    /**
     * kafka发送消息，带key，同key还是会发送到同一分区
     * @param topic
     * @param message
     * @param key
     */
    private static void sendMessagePartition(String topic, String message, String key) {
        // 设置 Kafka 生产者的配置参数
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, "com.lxx.spb2hotdev.kafka.config.MyProducerInterceptor");


        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, null, key, message);
        producer.send(record);
        producer.close();
    }
}
