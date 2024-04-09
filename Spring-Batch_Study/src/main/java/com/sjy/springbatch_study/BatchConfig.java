package com.sjy.springbatch_study;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.ExecutionContextSerializer;
import org.springframework.batch.core.repository.dao.Jackson2ExecutionContextStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing(executionContextSerializerRef = "jacksonSerializer")
public class BatchConfig {

    @Bean
    public ExecutionContextSerializer jacksonSerializer() {
        return new Jackson2ExecutionContextStringSerializer();
    }
}
