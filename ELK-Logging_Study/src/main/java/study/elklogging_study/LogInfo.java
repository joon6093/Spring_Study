package study.elklogging_study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {
    private String url;
    private String name;
    private String method;
    private Map<String, String> header;
    private String parameters;
    private String body;
    private String ipAddress;
    private String exception;

    public LogInfo(String url, String name, String method, Map<String, String> header, String parameters, String body, String ipAddress) {
        this.url = url;
        this.name = name;
        this.method = method;
        this.header = header;
        this.parameters = parameters;
        this.body = body;
        this.ipAddress = ipAddress;
    }
}
