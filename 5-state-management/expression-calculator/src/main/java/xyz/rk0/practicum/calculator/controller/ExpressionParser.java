package xyz.rk0.practicum.calculator.controller;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ExpressionParser implements IExpressionParser {

    private final static Set<String> validOperators = Set.of(
        "+", "-", "*", "/"
    );

    @Override
    public MathExpression parse(String expression) {
        String firstOperand = "";
        String operator = null;
        String secondOperand = "";
        for(int i = 0; i < expression.length(); i++) {
            char currCharacter = expression.charAt(i);
            if(!validOperators.contains("" + currCharacter)) {
                firstOperand += currCharacter;
            } else {
                operator = "" + currCharacter;
                secondOperand = expression.substring(i + 1);
                break;
            }
        }
        double number1 = Double.parseDouble(firstOperand);
        double number2 = Double.parseDouble(secondOperand);
        return new MathExpression(number1, operator, number2);
    }
}
