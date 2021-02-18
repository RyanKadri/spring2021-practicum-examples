package xyz.rk0.practicum.calculator.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import xyz.rk0.practicum.calculator.controller.CalculationResult;
import xyz.rk0.practicum.calculator.controller.ExpressionParser;
import xyz.rk0.practicum.calculator.controller.ExpressionRequest;
import xyz.rk0.practicum.calculator.controller.ExpressionSolver;
import xyz.rk0.practicum.calculator.controller.MathController;

public class StepDefinitions {

    private MathController controller;
    private CalculationResult result;

    @Given("that my server is started")
    public void serverIsStarted() {
        ExpressionParser parser = new ExpressionParser();
        ExpressionSolver solver = new ExpressionSolver();
        this.controller = new MathController(parser, solver);
    }

    @When("a user passes the expression {string}")
    public void somethingHappens(String expression) {
        this.result = this.controller.doCalculation(new ExpressionRequest(expression));
    }

    @Then("the result should be {}")
    public void testPasses(double expectedResult) {
        Assertions.assertEquals(expectedResult, this.result.result);
    }

}
