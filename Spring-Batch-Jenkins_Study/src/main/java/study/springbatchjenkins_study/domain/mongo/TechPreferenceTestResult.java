package study.springbatchjenkins_study.domain.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import study.springbatchjenkins_study.domain.TechRole;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "tech_preference_test_results")
public class TechPreferenceTestResult {

    @Id
    private String id;
    private TechRole result; // 검사 결과 (예: 백엔드, 프론트엔드)
    private String createdAt; // 검사 수행 날짜 및 시간
    private boolean matchesSelfAssessment; // 검사 결과가 자신과 맞는지 여부

    @Builder
    public TechPreferenceTestResult(TechRole result, String createdAt, boolean matchesSelfAssessment) {
        this.result = result;
        this.createdAt = createdAt;
        this.matchesSelfAssessment = matchesSelfAssessment;
    }
}
