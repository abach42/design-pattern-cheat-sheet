package com.abach42.designpatterns.behavioral.interpreter;

public class ConsonantInterpreter implements Interpreter {
    
    @Override
    public String interpret(Context context) {
        if ("aeiouAEIOU".indexOf(context.character()) < 0 && Character.isAlphabetic(context.character())) {
            return "consonant";
        } else {
            return "not a consonant";
        }
    }
}