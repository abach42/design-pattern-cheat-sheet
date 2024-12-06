package com.abach42.designpatterns.unit.behavioral.strategy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.abach42.designpatterns.behavioral.strategy.AdditionStrategy;
import com.abach42.designpatterns.behavioral.strategy.CalculatorContext;
import com.abach42.designpatterns.behavioral.strategy.DivisionStrategy;
import com.abach42.designpatterns.behavioral.strategy.MultiplicationStrategy;
import com.abach42.designpatterns.behavioral.strategy.SubtractionStrategy;

public class StrategyTest {
    
    @ParameterizedTest(name = "{0} = {3}")
    @DisplayName("Should calculate the correct result")
    @MethodSource("decoratorProvider")
    public void testDecoratorCalculates(String name, CalculatorContext context, int[] operands, int expectedResult) {
        int actualResult = context.calculate(operands[0], operands[1]);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> decoratorProvider() {
        return Stream.of(
            Arguments.of(
                "1+1",
                new CalculatorContext() {{
                    setBehavior(new AdditionStrategy());
                }}, 
                new int[]{1,1},
                2
            ),
            Arguments.of(
                "1-1",
                new CalculatorContext() {{
                    setBehavior(new SubtractionStrategy());
                }}, 
                new int[]{1,1},
                0
            ),
            Arguments.of(
                "2*3",
                new CalculatorContext() {{
                    setBehavior(new MultiplicationStrategy());
                }}, 
                new int[]{2,3},
                6
            ),
            Arguments.of(
                "4/2",
                new CalculatorContext() {{
                    setBehavior(new DivisionStrategy());
                }}, 
                new int[]{4,2},
                2
            )
        );
    }

    @Test
    @DisplayName("Should throw custom exception when division by zero")
    public void testDivisionByZeroThrows() {
        CalculatorContext calculator = new CalculatorContext();
        calculator.setBehavior(new DivisionStrategy());
    
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(1,0);
        });
    }
}