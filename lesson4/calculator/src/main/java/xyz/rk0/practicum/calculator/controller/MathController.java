package xyz.rk0.practicum.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private final IExpressionParser parser;
    private final IExpressionSolver solver;

    @Autowired
    public MathController(IExpressionParser parser, IExpressionSolver solver) {
        this.parser = parser;
        this.solver = solver;
    }

    @PostMapping("/calculate")
    public CalculationResult doCalculation(@RequestBody ExpressionRequest request) {
        String expression = request.getExpression();

        MathExpression mathExpression = this.parser.parse(expression);
        double result = this.solver.evaluate(mathExpression);
        return new CalculationResult(result);
    }

}
