package bk.ko.chaospilot.fake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeRemoteService {

    private static final Logger log = LoggerFactory.getLogger(FakeRemoteService.class);

    @GetMapping("/{name}/length")
    public String getNameAndLength(@PathVariable String name) {
        return name.concat("[" + name.length() + "]");
    }
}
