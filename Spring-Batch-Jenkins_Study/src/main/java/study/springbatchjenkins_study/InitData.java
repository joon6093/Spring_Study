package study.springbatchjenkins_study;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.springbatchjenkins_study.domain.TechRole;
import study.springbatchjenkins_study.domain.mongo.TechPreferenceTestResult;
import study.springbatchjenkins_study.repository.mongo.TechPreferenceTestResultRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Profile("local")
@Slf4j
public class InitData {

    private final TechPreferenceTestResultRepository techPreferenceTestResultRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initData() {
        log.info("Initializing sample data...");

        List<TechPreferenceTestResult> sampleData = Arrays.asList(
                TechPreferenceTestResult.builder()
                        .result(TechRole.BACKEND_TRAFFIC_CONTROLLER)
                        .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .matchesSelfAssessment(true)
                        .build(),
                TechPreferenceTestResult.builder()
                        .result(TechRole.FRONTEND_UI_MAGICIAN)
                        .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .matchesSelfAssessment(false)
                        .build()
        );

        techPreferenceTestResultRepository.saveAll(sampleData);

        log.info("Sample data initialization completed.");
    }
}
