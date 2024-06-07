package study.springbatchjenkins_study.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import study.springbatchjenkins_study.domain.mongo.TechPreferenceTestResult;

public interface TechPreferenceTestResultRepository extends MongoRepository<TechPreferenceTestResult, String> {
}
