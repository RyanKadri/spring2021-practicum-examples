package xyz.rk0.practicum.calculator.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {

    @Test
    void parsesMultiDigitDecimals() {
        ExpressionParser parser = new ExpressionParser();
        MathExpression expr = parser.parse("123.5-65");
        assertEquals("-", expr.getOperator());
        assertEquals(123.5, expr.getOperand1());
        assertEquals(65, expr.getOperand2());
    }

    @Test
    void parsesSpaces() {
        ExpressionParser parser = new ExpressionParser();
        MathExpression expr = parser.parse("1 +  2");
        assertEquals("+", expr.getOperator());
        assertEquals(1, expr.getOperand1());
        assertEquals(2, expr.getOperand2());
    }
}