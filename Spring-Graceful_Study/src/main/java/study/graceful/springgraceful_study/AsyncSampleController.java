package study.graceful.springgraceful_study;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/async")
public class AsyncSampleController {

    private final AsyncSampleService asyncSampleService;

    @GetMapping("/long-task")
    public String triggerAsyncLongTask() {
        log.info(">>> 요청 수신됨 - 비동기 longTask 시작");
        asyncSampleService.longTask(Duration.ofSeconds(20));
        log.info(">>> 컨트롤러 반환 완료");
        return "longTask triggered";
    }
}
