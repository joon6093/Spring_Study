package com.sjy.springbatch_study.http;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class JobLauncherController {
    private final Job job;
    private final JobLauncher jobLauncher;

    @PostMapping("/batch/default")
    public String launchDefault(@RequestBody Member member) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", member.getId())
                .addString("name", "default")
                .addLocalDateTime("date", LocalDateTime.now())
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        System.out.println(jobExecution.getExecutionContext().get("jobName"));
        return "batch completed";
    }

    @PostMapping("/batch/async")
    public String launchAsync(@RequestBody Member member) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", member.getId())
                .addString("name", "async")
                .addLocalDateTime("date", LocalDateTime.now())
                .toJobParameters();
        TaskExecutorJobLauncher taskExecutorJobLauncher = (TaskExecutorJobLauncher)jobLauncher;
        taskExecutorJobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        JobExecution jobExecution = taskExecutorJobLauncher.run(job, jobParameters);
        System.out.println(jobExecution.getExecutionContext().get("jobName"));
        return "batch completed";
    }
}
