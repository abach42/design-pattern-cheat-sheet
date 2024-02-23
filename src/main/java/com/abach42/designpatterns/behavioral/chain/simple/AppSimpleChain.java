package com.abach42.designpatterns.behavioral.chain.simple;

/*
 * Client code of a simple chain of responsibility. 
 * The Chain of Responsibility pattern is a design pattern where a request is passed through a chain of handlers. 
 * Each handler decides either to process the request or pass it to the next handler in the chain. 
 * It promotes loose coupling between the sender and receiver of a request and is commonly used in scenarios 
 * like event handling or middleware processing in web applications.
 * 
 * This example does not work with a data context and no decision to process or pass. 
 */
public class AppSimpleChain {
    public static void main(String[] args) {
        AbstractHandler firstHandler = new FirstHandler();
        AbstractHandler secondHandler = new SecondHandler();
        firstHandler.setNext(secondHandler);
        firstHandler.handle();
    }
}
