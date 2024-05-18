package com.abach42.designpatterns.behavioral.interpreter;

public class VowelInterpreter implements Interpreter {

    @Override
    public String interpret(Context context) {
        if ("aeiouAEIOU".indexOf(context.character()) >= 0) {
            return "vowel";
        } else {
            return "not a vowel";
        }
    }
}