package com.sjy.springbatch_study.example.file2db;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class FileJobConfiguration {

    private final JobRepository jobRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Job fileJob(Step fileStep1) {
        return new JobBuilder("fileJob", jobRepository)
                .start(fileStep1)
                .build();
    }

    @Bean
    public Step fileStep1(FlatFileItemReader<ProductVO> fileItemReader,
                          ItemProcessor<ProductVO, Product> fileItemProcessor,
                          JpaItemWriter<Product> fileItemWriter) {
        TaskletStep step = new StepBuilder("fileStep1", jobRepository)
                .<ProductVO, Product>chunk(10, transactionManager)
                .reader(fileItemReader)
                .processor(fileItemProcessor)
                .writer(fileItemWriter)
                .build();
        return step;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<ProductVO> fileItemReader(@Value("#{jobParameters['requestDate']}") String requestDate) {
        return new FlatFileItemReaderBuilder<ProductVO>()
                .name("flatFile")
                .resource(new ClassPathResource("product_" + requestDate + ".csv"))
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ProductVO>() {{
                    setTargetType(ProductVO.class);
                }})
                .linesToSkip(1)
                .delimited().delimiter(",")
                .names(new String[]{"id", "name", "price", "type"})
                .build();
    }

    @Bean
    public ItemProcessor<ProductVO, Product> fileItemProcessor() {
        return new FileItemProcessor();
    }

    @Bean
    public JpaItemWriter<Product> fileItemWriter() {
        return new JpaItemWriterBuilder<Product>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }
}
