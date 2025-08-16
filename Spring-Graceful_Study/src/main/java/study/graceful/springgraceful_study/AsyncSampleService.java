package study.graceful.springgraceful_study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncSampleService {

    private static final Logger log = LoggerFactory.getLogger(AsyncSampleService.class);

    @Async
    public CompletableFuture<String> longTask(final Duration duration) {
        log.info(">>> longTask 시작 - {}ms", duration.toMillis());

        try {
            Thread.sleep(duration.toMillis());
            log.info("<<< longTask 정상 종료");
            return CompletableFuture.completedFuture("done");
        } catch (InterruptedException e) {
            log.warn("xxx longTask 인터럽트됨");
            Thread.currentThread()
                    .interrupt();
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }
}
