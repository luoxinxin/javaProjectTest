package com.lxx.spb2hotdev.kafka.config;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import java.util.Map;

/**
 * kafka发送消息拦截器
 */
public class MyProducerInterceptor implements ProducerInterceptor<String, String> {

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        // 在消息发送前对消息进行拦截和修改
        String modifiedValue = "Modified-" + record.value();
        return new ProducerRecord<>(record.topic(), record.partition(), record.timestamp(), record.key(), modifiedValue);
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        // 在消息发送成功后的回调方法，可以记录日志等操作
        if (exception == null) {
            System.out.println("Message sent successfully: " + metadata);
        } else {
            System.out.println("Message sent failed: " + exception.getMessage());
        }
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

