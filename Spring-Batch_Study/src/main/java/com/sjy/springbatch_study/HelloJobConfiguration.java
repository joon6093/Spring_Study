package com.sjy.springbatch_study;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import java.util.Map;

@Configuration
public class HelloJobConfiguration {

    @Bean
    public Job helloJob(JobRepository jobRepository, Step helloStep1, Step helloStep2, Step helloStep3) {
        return new JobBuilder("helloJob", jobRepository)
                .start(helloStep1)
                .next(helloStep2)
                .next(helloStep3)
                .build();
    }

    @Bean
    @JobScope
    public Step helloStep1(JobRepository jobRepository, PlatformTransactionManager tx, @Value("#{jobParameters[name]}") String name) {
        return new StepBuilder( "helloStep1", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
//                    contribution.incrementReadCount();
//                    contribution.incre mentWriteCount(100);
//                    contribution.getStepExecution().apply(contribution);
                    ExecutionContext JobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
                    ExecutionContext StepExecutionContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();
                    String jobName = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName();
                    String stepName = chunkContext.getStepContext().getStepName();
                    if(JobExecutionContext.get("jobName") == null){
                        JobExecutionContext.put("jobName", jobName);
                    }
                    if(StepExecutionContext.get("stepName") == null){
                        StepExecutionContext.put("stepName", stepName);
                    }
                    System.out.println("====================================");
                    // System.out.println(jobParameters);
                    System.out.println(name);
                    System.out.println(JobExecutionContext.get("jobName"));
                    System.out.println(StepExecutionContext.get("stepName"));
                    System.out.println(" helloStep1 executed ");
                    System.out.println("====================================");

                    return RepeatStatus.FINISHED;
                }, tx).build();
    }

    @Bean
    public Step helloStep2(JobRepository jobRepository, PlatformTransactionManager tx) {
        return new StepBuilder( "helloStep2", jobRepository)
                .tasklet((contribution, chunkContext) -> {
//                    Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
                    ExecutionContext JobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
                    ExecutionContext StepExecutionContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();
                    String jobName = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName();
                    String stepName = chunkContext.getStepContext().getStepName();
                    if(StepExecutionContext.get("stepName") == null){
                        StepExecutionContext.put("stepName", stepName);
                    }
                    System.out.println("====================================");
//                    System.out.println(jobParameters);
                    System.out.println(JobExecutionContext.get("jobName"));
                    System.out.println(StepExecutionContext.get("stepName"));
                    System.out.println(" helloStep2 executed ");
                    System.out.println("====================================");
//                    throw new RuntimeException("helloStep2 Failed");
                    return RepeatStatus.FINISHED;
                }, tx).build();
    }

    @Bean
    public Step helloStep3(JobRepository jobRepository, PlatformTransactionManager tx) {
        return new StepBuilder( "helloStep3", jobRepository)
                .tasklet((contribution, chunkContext) -> {
//                    Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
                    ExecutionContext JobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
                    System.out.println("====================================");
//                    System.out.println(jobParameters);
                    System.out.println(JobExecutionContext.get("jobName"));
                    System.out.println(" helloStep3 executed ");
                    System.out.println("====================================");
//                    throw new RuntimeException("helloStep2 Failed");
                    return RepeatStatus.FINISHED;
                }, tx).build();
    }
}
