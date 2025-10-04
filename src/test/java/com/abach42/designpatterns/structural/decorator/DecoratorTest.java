package com.abach42.designpatterns.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DecoratorTest {

    @DisplayName("Should calculate the correct sum")
    @MethodSource("decoratorProvider")
    @ParameterizedTest(name = "{0}: price = {2}")
    public void testDecoratorCalculates(String name, Component component,
            BigDecimal expectedPrice) {
        BigDecimal actualPrice = component.calculatePrice();
        assertEquals(expectedPrice, actualPrice);
    }

    private static Stream<Arguments> decoratorProvider() {
        return Stream.of(
                Arguments.of(
                        "Espresso+Chocolate+FoamMilk",
                        new FoamMilkDecorator(
                                new ChocolateDecorator(
                                        new EspressoComponent()
                                )
                        ),
                        new BigDecimal("7.87")
                ),
                Arguments.of(
                        "Soy+DarkRosted",
                        new Soy(
                                new DarkRostedComponent()
                        ),
                        new BigDecimal("7.78")
                ),
                Arguments.of(
                        "FoamMilk+HouseBlend",
                        new FoamMilkDecorator(
                                new HouseBlendComponent()
                        ),
                        new BigDecimal("5.38")
                )
        );
    }
}