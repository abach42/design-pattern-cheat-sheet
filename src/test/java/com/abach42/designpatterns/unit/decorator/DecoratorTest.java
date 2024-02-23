package com.abach42.designpatterns.unit.decorator;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.abach42.designpatterns.decorator.Chocolate;
import com.abach42.designpatterns.decorator.Component;
import com.abach42.designpatterns.decorator.DarkRosted;
import com.abach42.designpatterns.decorator.Espresso;
import com.abach42.designpatterns.decorator.FoamMilk;
import com.abach42.designpatterns.decorator.HouseBlend;
import com.abach42.designpatterns.decorator.Soy;

public class DecoratorTest {

    @DisplayName("Should calculate the correct sum")
    @MethodSource("decoratorProvider")
    @ParameterizedTest(name = "{0}: price = {2}")
    public void testDecoratorCalculates(String name, Component component, BigDecimal expectedPrice) {
        BigDecimal actualPrice = component.calculatePrice();
        assertEquals(expectedPrice, actualPrice);
    }

    private static Stream<Arguments> decoratorProvider() {
        return Stream.of(
            Arguments.of(
                "Espresso+Chocolate+FoamMilk",
                new FoamMilk(
                    new Chocolate(
                        new Espresso()
                    )
                ), 
                new BigDecimal("7.87")
            ),
            Arguments.of(
                "Soy+DarkRosted",
                new Soy(
                    new DarkRosted()
                ),
                new BigDecimal("7.78")
            ),
            Arguments.of(
                "FoamMilk+HouseBlend",
                new FoamMilk(
                    new HouseBlend()
                ),
                new BigDecimal("5.38")
            )
        );
    }
}
