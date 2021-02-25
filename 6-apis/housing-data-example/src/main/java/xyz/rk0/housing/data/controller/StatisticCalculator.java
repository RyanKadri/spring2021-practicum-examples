package xyz.rk0.housing.data.controller;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StatisticCalculator {

    public double calculateStatistic(List<Double> values, String statistic) {

        switch(statistic) {
            case "min":
                return Collections.min(values);
            case "max":
                return Collections.max(values);
            case "average":
                return values.stream()
                    .mapToDouble(record -> record)
                    .average()
                    .orElse(0);
            case "sum":
                return values.stream()
                    .mapToDouble(record -> record)
                    .sum();
            case "range":
                return Collections.max(values) - Collections.min(values);
            default:
                throw new IllegalArgumentException("Did not know how to calculate " + statistic);
        }
    }
}
