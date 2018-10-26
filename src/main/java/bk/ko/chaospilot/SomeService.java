package bk.ko.chaospilot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeService {

    private static final Logger log = LoggerFactory.getLogger(SomeService.class);

    private final RestTemplate restTemplate;
    private final SomeoneRepository someoneRepository;

    public SomeService(RestTemplate restTemplate,
                       SomeoneRepository someoneRepository) {
        this.restTemplate = restTemplate;
        this.someoneRepository = someoneRepository;
    }

    String getHello(String name) {
        String desc;
        try {
            desc = restTemplate.getForEntity("http://localhost:8080/" + name + "/length", String.class)
                               .getBody();
        } catch (Exception e) {
            desc = "you maybe something wrong - this is fallback";
        }

        return desc + someoneRepository.doSomething();
    }
}
