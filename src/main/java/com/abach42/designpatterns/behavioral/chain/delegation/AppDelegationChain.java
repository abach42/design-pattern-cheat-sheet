package com.abach42.designpatterns.behavioral.chain.delegation;

/*
 * Client code of a simple chain of responsibility. 
 * The Chain of Responsibility pattern is a design pattern where a request is passed through a chain of handlers. 
 * Each handler decides either to process the request or pass it to the next handler in the chain. 
 * It promotes loose coupling between the sender and receiver of a request and is commonly used in scenarios 
 * like event handling or middleware processing in web applications.
 * 
 * Here data context is passed on process and handler does not care about handling next. 
 */
public class AppDelegationChain {
    public static void main(String[] args) {
        Chain.MemberList list = new Chain.MemberList();
        list.add(new Chain.Member("John", 50));
        list.add(new Chain.Member("Doe", 62));
        list.add(new Chain.Member("Marilyn", 32));

        new Chain()
            .add(new FilterHandler(40))
            .add(new SortByAgeHandler())
            .process(list);
    }
}
