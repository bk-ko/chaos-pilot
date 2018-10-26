package bk.ko.chaospilot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private final SomeService someService;

    public ApiController(SomeService someService) {
        this.someService = someService;
    }

    @GetMapping("/hello/{name}")
    public String getHello(@PathVariable String name) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String hello = someService.getHello(name);
        stopWatch.stop();
        return hello + " / " + stopWatch.getTotalTimeMillis();
    }
}
