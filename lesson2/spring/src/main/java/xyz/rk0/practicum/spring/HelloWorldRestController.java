package xyz.rk0.practicum.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping("/hello/{name}")
    public HelloResponse sayHello(@PathVariable(value = "name", required = false) String name) {
        return new HelloResponse("Ryan", 28, true);
    }
}
