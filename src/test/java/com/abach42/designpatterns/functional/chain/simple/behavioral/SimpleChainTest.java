package com.abach42.designpatterns.functional.chain.simple.behavioral;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.abach42.designpatterns.behavioral.chain.simple.AbstractHandler;
import com.abach42.designpatterns.behavioral.chain.simple.FirstHandler;
import com.abach42.designpatterns.behavioral.chain.simple.SecondHandler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        String expectedPrintedContent = "first handler\r\nsecond handler\r\n";
        assertEquals(expectedPrintedContent, actualPrintedContent);
    }
}
