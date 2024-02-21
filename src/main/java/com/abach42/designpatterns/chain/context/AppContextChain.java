package com.abach42.designpatterns.chain.context;

/*
 * Client code of a simple chain of responsibility. 
 * The Chain of Responsibility pattern is a design pattern where a request is passed through a chain of handlers. 
 * Each handler decides either to process the request or pass it to the next handler in the chain. 
 * It promotes loose coupling between the sender and receiver of a request and is commonly used in scenarios 
 * like event handling or middleware processing in web applications.
 * 
 * Here data context is used, but handler needs knowledge of handling next handler. 
 */
public class AppContextChain {
    public static void main(String[] args) {
        AbstractHandler.MemberList list = new AbstractHandler.MemberList();
        list.add(new AbstractHandler.Member("John", 50));
        list.add(new AbstractHandler.Member("Doe", 62));
        list.add(new AbstractHandler.Member("Marilyn", 32));

        AbstractHandler.initializeChain(
            new FilterHandler(list, 30), 
            new SortByAgeHandler(list)
        ).handle();
    }
}
