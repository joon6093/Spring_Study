package study.elklogging_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.elklogging_study.aop.NotLogging;

@RestController
@RequestMapping("/api")
@Slf4j
public class SampleController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World!";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return message;
    }

    @PostMapping("/error")
    public String throwError(@RequestBody String message) {
        log.error("Error message: {}", message);
        throw new RuntimeException("Test Exception");
    }

    @NotLogging
    @GetMapping("/no-log")
    public String noLog() {
        return "This should not be logged";
    }
}
