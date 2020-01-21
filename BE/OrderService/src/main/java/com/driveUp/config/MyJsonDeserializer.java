package com.driveUp.config;

import org.springframework.kafka.support.serializer.JsonDeserializer;

public class MyJsonDeserializer<T> extends JsonDeserializer<T> {
    public MyJsonDeserializer(){
        super();
        this.addTrustedPackages("*");
    }
}