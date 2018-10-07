package com.orjrs.spring.test.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author orjrs
 * @date 2018-10-06 20:10
 */
@RestController
public class TestController {
    @PostMapping("/unit/sayHello/{name}/{message}")
    public String sayHello(@PathVariable(value = "name") String name, @PathVariable(value = "message") String message) {
        return name + ": " + message;
    }
}
