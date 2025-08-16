package study.graceful.springgraceful_study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AsyncShutdownTest {

    @Test
    void GracefulAsync_대기_on이면_종료해도_작업이_완료된다() throws Exception {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(GracefulAsyncConfig.class, AsyncSampleService.class);

        final AsyncSampleService service = ctx.getBean(AsyncSampleService.class);
        final ThreadPoolTaskExecutor executor = ctx.getBean(ThreadPoolTaskExecutor.class);

        final CompletableFuture<String> future = service.longTask(Duration.ofSeconds(20));
        ctx.close();
        System.out.println("컨텍스트 종료 후");

        assertThat(executor.getThreadPoolExecutor()
                .isShutdown()).isTrue();
        assertEquals("done", future.get());
    }

    @Test
    void NonGracefulAsync_대기_off이면_종료시_진행중_작업이_인터럽트되어_예외로_끝난다() {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(NonGracefulAsyncConfig.class, AsyncSampleService.class);

        final AsyncSampleService service = ctx.getBean(AsyncSampleService.class);

        final CompletableFuture<String> future = service.longTask(Duration.ofSeconds(100));

        ctx.close();

        final ExecutionException execEx = assertThrows(ExecutionException.class, future::get);
        assertTrue(execEx.getCause() instanceof InterruptedException);
    }

    @Test
    void NonGracefulAsync_Bean미등록시_종료후_작업이_중단된다() throws InterruptedException {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(NonBeanAsyncConfig.class, AsyncSampleService.class);

        final AsyncSampleService service = ctx.getBean(AsyncSampleService.class);
        final CompletableFuture<String> future = service.longTask(Duration.ofSeconds(30));

        ctx.close();

        assertThrows(ExecutionException.class, future::get);
    }

    @Test
    void GracefulAsync_Bean등록시_shutdown된다() throws Exception {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(GracefulAsyncConfig.class);

        final ThreadPoolTaskExecutor executor = ctx.getBean(ThreadPoolTaskExecutor.class);
        final ThreadPoolExecutor nativeExecutor = extractNativeThreadPool(executor);

        ctx.close();

        assertThat(nativeExecutor.isShutdown())
                .isTrue();
    }

    @Test
    void NonBeanExecutor는_컨텍스트종료시_shutdown되지_않는다() throws Exception {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(NonBeanAsyncConfig.class);

        final ThreadPoolTaskExecutor executor = ctx.getBean(ThreadPoolTaskExecutor.class);
        final ThreadPoolExecutor nativeExecutor = extractNativeThreadPool(executor);

        ctx.close();

        assertThat(nativeExecutor.isShutdown())
                .isFalse();
    }

    private ThreadPoolExecutor extractNativeThreadPool(ThreadPoolTaskExecutor executor) throws Exception {
        Field field = ThreadPoolTaskExecutor.class.getDeclaredField("threadPoolExecutor");
        field.setAccessible(true);
        return (ThreadPoolExecutor) field.get(executor);
    }

    @Test
    void NonBeanExecutor는_awaitTermination_기다리지_않는다() throws InterruptedException {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(NonBeanAsyncConfig.class, AsyncSampleService.class);

        final AsyncSampleService service = ctx.getBean(AsyncSampleService.class);

        service.longTask(Duration.ofSeconds(100)); // 일부러 긴 작업 실행

        long start = System.currentTimeMillis();
        ctx.close();
        long end = System.currentTimeMillis();

        long elapsed = end - start;

        assertThat(elapsed)
                .as("비관리 Executor는 awaitTerminationSecs 적용 안 됨")
                .isLessThan(1000);
    }

    @Test
    void GracefulExecutor는_awaitTermination_동안_기다린다() throws InterruptedException {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(GracefulAsyncConfig.class, AsyncSampleService.class);

        final AsyncSampleService service = ctx.getBean(AsyncSampleService.class);

        service.longTask(Duration.ofSeconds(5));

        long start = System.currentTimeMillis();
        ctx.close();
        long end = System.currentTimeMillis();

        long elapsed = end - start;

        assertThat(elapsed)
                .as("GracefulExecutor는 awaitTerminationSecs 대기")
                .isGreaterThanOrEqualTo(4000);
    }

    @Test
    void 컨텍스트_종료후에는_새로운_작업_제출이_거절된다() {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(NonGracefulAsyncConfig.class);

        final ThreadPoolTaskExecutor executor = ctx.getBean(ThreadPoolTaskExecutor.class);
        ctx.close();

        assertThrows(
                TaskRejectedException.class, () -> executor.execute(() -> {
                })
        );
    }

    @Test
    void NonBeanExecutor는_컨텍스트_종료후에는_새로운_작업_제출이_거절되지_않는다() {
        // given
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(NonBeanAsyncConfig.class);

        final NonBeanAsyncConfig config = ctx.getBean(NonBeanAsyncConfig.class);
        final ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) config.getAsyncExecutor();

        // when
        ctx.close();

        // then
        assertDoesNotThrow(() ->
                executor.execute(() -> System.out.println(">>> 작업 제출 성공"))
        );
    }
}
