package xyz.rk0.practicum.calculator;

public class HistoryEntry {
    public final double num1;
    public final double num2;
    public final String operator;
    public final long date;

    public HistoryEntry(double num1, double num2, String operator, long date) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.date = date;
    }
}
