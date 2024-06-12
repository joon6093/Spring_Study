package study.elklogging_study.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Getter
public class RequestApiInfo {

    private final String url;
    private final String name;
    private final String method;
    private final Map<String, String> header;
    private final Map<String, Object> parameters;
    private final Object body;
    private final String ipAddress;

    public RequestApiInfo(ProceedingJoinPoint joinPoint, Class<?> targetClass) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        this.url = request.getRequestURL().toString();
        this.name = targetClass.getSimpleName() + "." + joinPoint.getSignature().getName();
        this.method = request.getMethod();
        this.header = extractHeaders(request);
        this.parameters = extractParameters(request);
        this.body = extractBody(joinPoint);
        this.ipAddress = request.getRemoteAddr();
    }

    private Map<String, String> extractHeaders(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;
    }

    private Map<String, Object> extractParameters(HttpServletRequest request) {
        Map<String, Object> parameters = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            parameters.put(paramName, request.getParameter(paramName));
        }
        return parameters;
    }

    private Object extractBody(ProceedingJoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg != null && !(arg instanceof HttpServletRequest)) {
                return arg;
            }
        }
        return null;
    }
}
