package study.springbatchjenkins_study.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springbatchjenkins_study.domain.TechRole;
import study.springbatchjenkins_study.domain.jpa.TechRoleStatistics;

import java.util.Optional;

public interface TechRoleStatisticsRepository extends JpaRepository<TechRoleStatistics, Long> {
    Optional<TechRoleStatistics> findByRole(TechRole role);
}
