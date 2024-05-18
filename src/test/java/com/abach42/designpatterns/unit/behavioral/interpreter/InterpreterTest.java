package com.abach42.designpatterns.unit.behavioral.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.interpreter.ConsonantInterpreter;
import com.abach42.designpatterns.behavioral.interpreter.Context;
import com.abach42.designpatterns.behavioral.interpreter.Interpreter;
import com.abach42.designpatterns.behavioral.interpreter.VowelInterpreter;

public class InterpreterTest {

    @Test
    @DisplayName("should interpret a context as vowel")
    void testInterpreterVovel() {
        Context context = new Context('A');

        Interpreter vowelInterpreter = new VowelInterpreter();
        Interpreter consonantInterpreter = new ConsonantInterpreter();

        Character actualVowel = context.character();
        assertEquals("A is vowel", actualVowel + " is " + vowelInterpreter.interpret(context));
        assertEquals("A is not a consonant", actualVowel + " is " + consonantInterpreter.interpret(context));
    }

    @Test
    @DisplayName("should interpret a context as consonant")
    void testInterpreterConsonant() {
        Context context = new Context('B');

        Interpreter vowelInterpreter = new VowelInterpreter();
        Interpreter consonantInterpreter = new ConsonantInterpreter();

        Character actualConsonant = context.character();
        assertEquals("B is not a vowel", actualConsonant + " is " + vowelInterpreter.interpret(context));
        assertEquals("B is consonant", actualConsonant + " is " + consonantInterpreter.interpret(context));
    }
}