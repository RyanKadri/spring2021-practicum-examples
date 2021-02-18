package xyz.rk0.practicum.calculator.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathControllerTest {

    private MathController mathController;

    @BeforeEach
    public void setupController() {
        ExpressionParser parser = new ExpressionParser();
        ExpressionSolver solver = new ExpressionSolver();
        mathController = new MathController(parser, solver);
    }

    /*
     * These tests could be moved to the ExpressionParserTest if we want to test the parsing logic in more detail.
     * If we want some integration tests, they can stay here but it might make sense to separate integration tests from
     * unit tests
     * */
    @Test
    public void testSimpleAddition() {
        CalculationResult res = mathController.doCalculation(new ExpressionRequest("5+2"));
        Assertions.assertEquals(7, res.result);
    }

    @Test
    public void handlesOperations() {
        CalculationResult res = mathController.doCalculation(new ExpressionRequest("5-2"));
        Assertions.assertEquals(3, res.result);
    }

    /*
     * This is not really a super useful test. It pretty much just tests the trivial
     * control flow in the controller. But it's an example of mocking dependencies
     * */
    @Test
    public void testConnections() {
        IExpressionParser fakeParser = (expr) -> new MathExpression(1,"+",2);
        IExpressionSolver fakeSolver = (expr) -> 3;
        MathController mockedController = new MathController(fakeParser, fakeSolver);
        CalculationResult result = mockedController.doCalculation(new ExpressionRequest("1+2"));
        Assertions.assertEquals(3, result.result);
    }
}
