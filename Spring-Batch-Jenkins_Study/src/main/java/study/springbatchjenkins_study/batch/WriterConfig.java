package study.springbatchjenkins_study.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springbatchjenkins_study.domain.jpa.TechRoleStatistics;
import study.springbatchjenkins_study.repository.jpa.TechRoleStatisticsRepository;

@Configuration
public class WriterConfig {

    private final TechRoleStatisticsRepository techRoleStatisticsRepository;

    public WriterConfig(TechRoleStatisticsRepository techRoleStatisticsRepository) {
        this.techRoleStatisticsRepository = techRoleStatisticsRepository;
    }

    @Bean
    public ItemWriter<TechRoleStatistics> techRoleStatisticsWriter() {
        return items -> {
            for (TechRoleStatistics item : items) {
                TechRoleStatistics existing = techRoleStatisticsRepository.findByRole(item.getRole())
                        .orElse(new TechRoleStatistics(item.getRole(), 0L, 0L));
                existing.updateCount(existing.getCount() + item.getCount());
                existing.updateMatchesSelfAssessmentCount(existing.getMatchesSelfAssessmentCount() + item.getMatchesSelfAssessmentCount());
                techRoleStatisticsRepository.save(existing);
            }
        };
    }
}
