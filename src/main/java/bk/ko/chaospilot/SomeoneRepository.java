package bk.ko.chaospilot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SomeoneRepository {

    private static final Logger log = LoggerFactory.getLogger(SomeoneRepository.class);

    String doSomething() {
        return " / ok";
    }
}
