package com.sjy.springbatch_study;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.repository.ExecutionContextSerializer;
import org.springframework.batch.core.repository.dao.Jackson2ExecutionContextStringSerializer;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class BatchConfig extends DefaultBatchConfiguration {
//
//    @Override
//    protected ExecutionContextSerializer getExecutionContextSerializer() {
//        return new Jackson2ExecutionContextStringSerializer();
//    }
//}
