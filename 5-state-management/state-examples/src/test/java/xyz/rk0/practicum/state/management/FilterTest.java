package xyz.rk0.practicum.state.management;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {

    @Test
    public void testFilter() {
        var names = List.of("Alice", "Bob", "AJ", "Aang");
        var filteredNames = filterAnything(names, name -> name.startsWith("A"));
        Assertions.assertEquals(List.of("Alice", "AJ", "Aang"), filteredNames);
    }

    @Test
    public void tryFilteringAnything() {
        List<Integer> numbers = List.of(1,2,5,7,11,16);
        List<Integer> filtered = filterAnything(numbers, num -> num > 10);
        Assertions.assertEquals(List.of(11, 16), filtered);
    }

    @Test
    public void tryDoubling() {
        List<Integer> numberList = List.of(1,2,3);
        List<Integer> doubledNumbers = numberList.stream()
            .map(num -> num * 2)
            .collect(Collectors.toList());
        Assertions.assertEquals(List.of(2, 4, 6), doubledNumbers);
    }

    @Test
    public void describeDays() {
        List<String> daysOfTheWeek = Lists.newArrayList(
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        );
        List<String> weekend = extractWeekend(daysOfTheWeek);
        System.out.println("There are " + daysOfTheWeek.size() + " days of the week");
        System.out.println("... and " + weekend.size() + " days of the weekend");
    }

    private List<String> extractWeekend(List<String> allDays) {
        List<String> weekend = allDays;
        for(int i = weekend.size() - 1; i >= 0; i--) {
            if(!weekend.get(i).equals("Saturday") && !weekend.get(i).equals("Sunday")) {
                weekend.remove(i);
            }
        }
        return weekend;
    }

    private List<Double> resultHistory = new ArrayList<>();
    public double maybePure(double a, double b) {
        double sum = a + b;
        resultHistory.add(sum);
        return sum;
    }

    public <T> List<T> filterAnything(List<T> numbers, FilterDecider<T> decider) {
        List<T> filteredInts = new ArrayList<>();
        for(T num: numbers) {
            if(decider.shouldStay(num)) {
                filteredInts.add(num);
            }
        }
        return filteredInts;
    }

}
