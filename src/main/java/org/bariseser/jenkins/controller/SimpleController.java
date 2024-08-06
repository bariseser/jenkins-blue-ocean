package org.bariseser.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("{message}")
    public String getMessage(@PathVariable String message) {
        return message;
    }


    @GetMapping("hello/{username}")
    public String getHelloMessage(@PathVariable String username) {
        return String.format("hello, %s", username);
    }
}
