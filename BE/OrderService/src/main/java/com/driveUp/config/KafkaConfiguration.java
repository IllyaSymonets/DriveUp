package com.driveUp.config;

import com.driveUp.request.CreateBillRequest;
import com.driveUp.request.CreateTripRequest;
import com.driveUp.request.SetBillToOrderRequest;
import com.driveUp.request.SetTripToOrderRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public ProducerFactory producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory(config);
    }

    public KafkaTemplate<String, CreateTripRequest> kafkaCreateTripTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    public KafkaTemplate<String, CreateBillRequest> kafkaCreateBillTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConsumerFactory consumerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MyJsonDeserializer.class);

        return new DefaultKafkaConsumerFactory(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SetTripToOrderRequest> kafkaSetTripListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SetTripToOrderRequest> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SetBillToOrderRequest> kafkaSetBillListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SetBillToOrderRequest> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
