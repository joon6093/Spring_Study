package study.springbatchjenkins_study.domain.jpa;

import jakarta.persistence.*;
import lombok.*;
import study.springbatchjenkins_study.domain.TechRole;

@Getter
@Entity
@Table(name = "tech_role_statistics")
@NoArgsConstructor
public class TechRoleStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TechRole role;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private Long matchesSelfAssessmentCount;

    @Builder
    public TechRoleStatistics(TechRole role, Long count, Long matchesSelfAssessmentCount) {
        this.role = role;
        this.count = count;
        this.matchesSelfAssessmentCount = matchesSelfAssessmentCount;
    }

    public void updateCount(Long count) {
        this.count = count;
    }

    public void updateMatchesSelfAssessmentCount(Long matchesSelfAssessmentCount) {
        this.matchesSelfAssessmentCount = matchesSelfAssessmentCount;
    }
}
