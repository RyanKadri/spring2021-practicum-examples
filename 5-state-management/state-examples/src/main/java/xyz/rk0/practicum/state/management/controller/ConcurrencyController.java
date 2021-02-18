package xyz.rk0.practicum.state.management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ConcurrencyController {

    private int simpleCounter = 0;
    @PostMapping("/incrementSimple")
    public int incrementCounter() {
        return ++this.simpleCounter;
    }

    private final AtomicInteger safeCounter = new AtomicInteger(0);
    @PostMapping("/incrementSafe")
    public int incrementSafe() {
        return this.safeCounter.incrementAndGet();
    }

    private int slowCounter = 0;
    @PostMapping("/incrementSlow")
    public int incrementSlow() {
        int initValue = this.slowCounter;
        // Do some useless work
        int sum = 0;
        for(int i = 0; i < 1000; i ++) {
            sum += i;
        }
        System.out.println(sum);
        this.slowCounter = initValue + 1;
        return this.slowCounter;
    }

}
