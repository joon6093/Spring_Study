package study.springbatchjenkins_study.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoPagingItemReader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import study.springbatchjenkins_study.domain.jpa.TechRoleStatistics;
import study.springbatchjenkins_study.domain.mongo.TechPreferenceTestResult;

@Configuration
@RequiredArgsConstructor
public class TechRoleStatisticsJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final MongoPagingItemReader<TechPreferenceTestResult> techPreferenceTestResultReader;
    private final ItemProcessor<TechPreferenceTestResult, TechRoleStatistics> techRoleStatisticsProcessor;
    private final ItemWriter<TechRoleStatistics> techRoleStatisticsWriter;

    @Bean
    public Job techRoleStatisticsJob() {
        return new JobBuilder("techRoleStatisticsJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(techRoleStatisticsStep())
                .build();
    }

    @Bean
    public Step techRoleStatisticsStep() {
        return new StepBuilder("techRoleStatisticsStep", jobRepository)
                .<TechPreferenceTestResult, TechRoleStatistics>chunk(10, transactionManager)
                .reader(techPreferenceTestResultReader)
                .processor(techRoleStatisticsProcessor)
                .writer(techRoleStatisticsWriter)
                .build();
    }
}
