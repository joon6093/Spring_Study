package study.springbatchjenkins_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "study.springbatchjenkins_study.repository.jpa")
@EnableMongoRepositories(basePackages = "study.springbatchjenkins_study.repository.mongo")
public class SpringBatchJenkinsStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchJenkinsStudyApplication.class, args);
    }

}
