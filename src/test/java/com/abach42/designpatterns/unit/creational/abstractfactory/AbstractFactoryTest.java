package com.abach42.designpatterns.unit.creational.abstractfactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.abach42.designpatterns.creational.abstractfactory.ConcreteFactory1;
import com.abach42.designpatterns.creational.abstractfactory.ConcreteFactory2;

public class AbstractFactoryTest {
    
    @ParameterizedTest(name = "{0}")
    @DisplayName("Should return the correct string")
    @MethodSource("abstractFactoryProvider")
    public void testAbstractFactoryReturnsProductString(String expectedResult, String actualResult) {   
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> abstractFactoryProvider() {
        return Stream.of(
            Arguments.of(
                "Name:ProductA1",
                new ConcreteFactory1().createProductA().toString()
            ),
            Arguments.of(
                "Name:ProductA2",
                new ConcreteFactory2().createProductA().toString()
            ),
            Arguments.of(
                "Id:ProductB1",
                new ConcreteFactory1().createProductB().toString()
            ),
            Arguments.of(
                "Id:ProductB2",
                new ConcreteFactory2().createProductB().toString()
            )
        );
    }
}
