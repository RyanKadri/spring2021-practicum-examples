package xyz.rk0.practicum.calculator.controller;

import org.springframework.stereotype.Component;

@Component
public class ExpressionSolver implements IExpressionSolver {

    @Override
    public double evaluate(MathExpression expression) {
        String operator = expression.getOperator();
        double number1 = expression.getOperand1();
        double number2 = expression.getOperand2();

        switch("" + operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
