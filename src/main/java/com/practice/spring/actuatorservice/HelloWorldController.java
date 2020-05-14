package com.practice.spring.actuatorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWorldController {

    private final String template = "Hello, %s!";

    //AtomicLong : 원자적 갱신이 가능한 long, 값을 증가하거나 감소하거나 값을 변경 및 형변환이 가능하다.
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
