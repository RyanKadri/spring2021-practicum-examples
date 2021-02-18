package xyz.rk0.practicum.calculator.controller;

public class ExpressionRequest {
    private String expression;

    public ExpressionRequest() { }

    public ExpressionRequest(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
