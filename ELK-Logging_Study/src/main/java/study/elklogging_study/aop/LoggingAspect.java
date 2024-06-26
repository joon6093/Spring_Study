package study.elklogging_study.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private final ObjectMapper objectMapper;

    @Pointcut("within(*..*Controller) && !@annotation(study.elklogging_study.aop.NotLogging)")
    public void onRequest() {}

    @Around("onRequest()")
    public Object requestLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        // API 요청 정보
        final RequestApiInfo apiInfo = new RequestApiInfo(joinPoint, joinPoint.getTarget().getClass());

        // 로그 정보
        final LogInfo logInfo = new LogInfo(
                apiInfo.getUrl(),
                apiInfo.getName(),
                apiInfo.getMethod(),
                apiInfo.getHeader(),
                objectMapper.writeValueAsString(apiInfo.getParameters()),
                objectMapper.writeValueAsString(apiInfo.getBody()),
                apiInfo.getIpAddress()
        );

        try {
            final Object result = joinPoint.proceed(joinPoint.getArgs());

            if (!logInfo.getMethod().equals("GET")) {
                final String logMessage = objectMapper.writeValueAsString(Map.entry("logInfo", logInfo));
                logger.info(logMessage);
            }

            return result;
        } catch (Exception e) {
            final StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            final String exceptionAsString = sw.toString();
            logInfo.setException(exceptionAsString);
            final String logMessage = objectMapper.writeValueAsString(logInfo);
            logger.error(logMessage);

            throw e;
        }
    }

}
