package xyz.rk0.practicum.calculator;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MathController {

    private final List<HistoryEntry> history = new ArrayList<>();

    @GetMapping("/add/{num1}/{num2}")
    public double addNumbers(
        @PathVariable double num1,
        @PathVariable double num2
    ) {
        history.add(new HistoryEntry(num1, num2, "+", System.currentTimeMillis()));
        return num1 + num2;
    }

    @GetMapping("/history")
    public List<HistoryEntry> getHistory() {
        return history;
    }

    @DeleteMapping("/history")
    public int clearHistory() {
        int numItems = history.size();
        history.clear();
        return numItems;
    }
}
