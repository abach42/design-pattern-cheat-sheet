package com.abach42.designpatterns.behavioral.interpreter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class InterpreterTest {

    @Test
    void testExpressionTreeWithNot() {
        Context context = new Context(Map.of("a", true, "b", false, "c", true));

        Expression expression = new AndExpression(
                new VariableExpression("a"),
                new NotExpression(
                        new OrExpression(
                                new VariableExpression("b"),
                                new VariableExpression("c")
                        )
                )
        );

        assertFalse(expression.interpret(context));
    }

    @Test
    void testOnlyNotExpression() {
        Context context = new Context(Map.of("a", false));

        Expression expression = new NotExpression(new VariableExpression("a"));
        assertTrue(expression.interpret(context));
    }
}