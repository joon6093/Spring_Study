package com.sjy.springbatch_study;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobRepositoryListener implements JobExecutionListener {

    private final JobRepository jobRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        JobParameters jobParameters = new JobParametersBuilder().addString("name", "song3").toJobParameters();
        JobExecution lastExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
        System.out.println("BatchStatus = " + (lastExecution != null ? lastExecution.getStatus().name() : null));
        if(lastExecution != null) {
            for (StepExecution execution : lastExecution.getStepExecutions()) {
                BatchStatus status = execution.getStatus();
                System.out.println("BatchStatus = " + status.isRunning());
                System.out.println("BatchStatus = " + status.name());
            }
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        JobParameters jobParameters = new JobParametersBuilder().addString("name", "song4").toJobParameters();
        JobExecution lastExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
        System.out.println("BatchStatus = " + (lastExecution != null ? lastExecution.getStatus().name() : null));
        if(lastExecution != null) {
            for (StepExecution execution : lastExecution.getStepExecutions()) {
                BatchStatus status = execution.getStatus();
                System.out.println("BatchStatus = " + status.isRunning());
                System.out.println("BatchStatus = " + status.name());
            }
        }
    }
}
