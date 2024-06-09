package study.elklogging_study;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
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
        throw new RuntimeException("Test Exception");
    }

    @NotLogging
    @GetMapping("/no-log")
    public String noLog() {
        return "This should not be logged";
    }
}
