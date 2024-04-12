package com.sjy.springbatch_study.example.scheduler;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class FileSchJob extends QuartzJobBean{

	@Autowired
	private Job fileJob;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobExplorer jobExplorer;

	@SneakyThrows
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		String requestDate = (String)context.getJobDetail().getJobDataMap().get("requestDate");

		JobParameters jobParameters = new JobParametersBuilder()
									.addLong("id", new Date().getTime())
									.addString("requestDate", requestDate)
                                    .addLocalDateTime("LocalDateTime", LocalDateTime.now())
									.toJobParameters();
		jobLauncher.run(fileJob, jobParameters);
	}

}
