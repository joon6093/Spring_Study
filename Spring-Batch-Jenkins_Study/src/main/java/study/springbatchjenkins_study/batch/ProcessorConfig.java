package study.springbatchjenkins_study.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springbatchjenkins_study.domain.jpa.TechRoleStatistics;
import study.springbatchjenkins_study.domain.mongo.TechPreferenceTestResult;

@Configuration
public class ProcessorConfig {

    @Bean
    public ItemProcessor<TechPreferenceTestResult, TechRoleStatistics> techRoleStatisticsProcessor() {
        return item -> TechRoleStatistics.builder()
                .role(item.getResult())
                .count(1L)
                .matchesSelfAssessmentCount(item.isMatchesSelfAssessment() ? 1L : 0L)
                .build();
    }
}
