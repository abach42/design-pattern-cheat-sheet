package com.abach42.designpatterns.functional.chain.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.chain.simple.AbstractHandler;
import com.abach42.designpatterns.chain.simple.FirstHandler;
import com.abach42.designpatterns.chain.simple.SecondHandler;

public class SimpleChainTest {
    
    @Test
    @DisplayName("Simple chain returns console output")
    public void testSimpleChainReturnsConsoleOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        AbstractHandler firstHandlerStub = new FirstHandler();
        AbstractHandler secondHandlerStub = new SecondHandler();
        firstHandlerStub.setNext(secondHandlerStub);
        firstHandlerStub.handle();

        System.setOut(originalOut);

        String actualPrintedContent = outputStream.toString();
        String expectedPrintedContent = "first handler\nsecond handler\n";
        assertEquals(expectedPrintedContent, actualPrintedContent);
    }
}
