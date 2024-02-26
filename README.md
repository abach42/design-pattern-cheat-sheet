# Design patterns 

A cheat sheet in Java for daily work.

## Creational Patterns:

### Singleton Pattern

:pencil2: The Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. It's useful when exactly one object is needed to coordinate actions across the system.

```java
public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {}

    // Static method to provide access to the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

And here's how you would use the Singleton class:

```java
Singleton singleton = Singleton.getInstance();
```

While the Singleton pattern can be useful in certain situations, it's also often considered an "anti-pattern" due to some of its drawbacks like hidden dependencies, concurrency issues, testing challenges. 

### Factory Method Pattern

:pencil2: The Factory Method is a creational pattern that first defines a method that creates an object. Which type is instantiated is decided by the concrete class that implements this method.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/creational/factorymethod)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/creational/factorymethod/FactoryMethodTest.java)

```java
Creator creator = new CircleCreator();
Product product = creator.createProduct(new Point(100, 100));
Shape shape = product.getShape();
```
```java
Creator creator = new SquareCreator();
Product product = creator.createProduct(new Point(100, 100));
Shape shape =  product.getShape();
```

### Abstract Factory Pattern

:pencil2: The Abstract Factory pattern is another creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It's useful when you need to ensure that the created objects are compatible with each other and when you want to hide the implementation details of the creation process.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/creational/abstractfactory)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/creational/abstractfactory/AbstractFactoryTest.java)

#### Client Code example

```java
AbstractFactory firstFactory = new ConcreteFactory1();
String resultA = firstFactory.createProductA().toString(); //"Name:ProductA1"
String resultB = firstFactory.createProductB().toString(); //"Id:ProductB1"
```
```java
AbstractFactory secondFactory = new ConcreteFactory2();
String resultA = secondFactory.createProductA().toString(); //"Name:ProductA2"
String resultB = secondFactory.createProductB().toString(); //"Id:ProductB2"
```

### Builder Pattern

:pencil2: The Builder pattern is a creational pattern that composes data in steps and divides the build process from the presentation layer. It allows you to produce different types and representations of an object using the same construction process. This pattern is particularly useful when dealing with objects that have numerous parameters or configurations, as it provides a clear way to separate the construction logic from the rest of the code. See variants in [test](src/test/java/com/abach42/designpatterns/unit/creational/builder/BuilderTest.java).

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/creational/builder)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/creational/builder/BuilderTest.java)

#### Client Code example

```java
Director director = new Director();

BareboneConcreteBuilder bareboneBuilder = new BareboneConcreteBuilder();
director.constructBasicComputer(bareboneBuilder);
BareboneProduct bareboneProduct = bareboneBuilder.build();

System.out.println(bareboneProduct.toString());
```

### Prototype Pattern

## Structural Patterns:

### Adapter Pattern
### Bridge Pattern
### Composite Pattern
### Decorator Pattern

:pencil2: The Decorator pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

The Decorator pattern allows you to stack decorators on top of each other, each adding its own behavior, and providing a flexible way to modify the behavior of individual objects at runtime. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/structural/decorator/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/structural/decorator/DecoratorTest.java)

#### Client Code example

```java
Component order = new FoamMilkDecorator(
    new ChocolateDecorator(
        new EspressoComponent()
    )
);

System.out.println(String.format("%.2f", order.calculatePrice()));
```

### Facade Pattern
### Flyweight Pattern
### Proxy Pattern

## Behavioral Patterns:

### Chain of Responsibility Pattern

:pencil2: The Chain of Responsibility pattern is a design pattern where a request is passed through a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain. It promotes loose coupling between the sender and receiver of a request and is commonly used in scenarios like event handling or middleware processing in web applications.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/chain/context/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/chain/context/ContextChainTest.java)

#### Client Code example

```java
AbstractHandler.MemberList list = new AbstractHandler.MemberList();
list.add(new AbstractHandler.Member("John", 50));
list.add(new AbstractHandler.Member("Doe", 62));
list.add(new AbstractHandler.Member("Marilyn", 32));

AbstractHandler.initializeChain(
    new FilterHandler(list, 30), 
    new SortByAgeHandler(list)
).handle();
``` 

#### Variant 1: Very Simple example

This example does not work with a data context and no decision to process or pass. 

:bulb: [Link to very simple code example](src/main/java/com/abach42/designpatterns/behavioral/chain/simple/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/functional/chain/simple/behavioral/SimpleChainTest.java)

##### Client Code example

```java
AbstractHandler firstHandler = new FirstHandler();
AbstractHandler secondHandler = new SecondHandler();
firstHandler.setNext(secondHandler);
firstHandler.handle();
```

#### Variant 2: Example delegating handling tasks

Here data context is passed on process and handler does not care about handling next, building chain, stering handle tasks from outside of handle method. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/chain/delegation/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/chain/delegation/DelegationChainTest.java)

##### Client Code example

```java
Chain.MemberList list = new Chain.MemberList();
list.add(new Chain.Member("John", 50));
list.add(new Chain.Member("Doe", 62));
list.add(new Chain.Member("Marilyn", 32));

new Chain()
    .add(new FilterHandler(40))
    .add(new SortByAgeHandler())
    .process(list);
```

> Handling guard can vary in complexity can vary in complexity...

```java
if (memberList.isEmpty()) {
    return memberList;
}
```

### Command Pattern
### Interpreter Pattern
### Iterator Pattern
### Mediator Pattern
### Memento Pattern
### Observer Pattern

:pencil2: The Observer Pattern is a design pattern where an object (the subject) maintains a list of its dependents (observers) and notifies them of any state changes. This allows for loose coupling between components, making it easier to maintain and extend the system. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/observer/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/observer/ObserverTest.java)

#### Client Code example

```java

ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
new CalculateDistanceObserver(subject);
new CalculateDurationObserver(subject);
        
RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));

subject.setStateEntity(route);

System.out.println(
    "You would have " 
    + new DecimalFormat("#0.00").format(route.getDuration()) 
    + " h to travel"
);

```
 
### State Pattern
### Strategy Pattern

:pencil2: The Strategy pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one of them, and make them interchangeable. It enables a client to choose a particular algorithm from the family of algorithms at runtime without altering the client's code.

The key idea behind the Strategy pattern is to encapsulate algorithms into separate classes and make them interchangeable. This allows the client to select the appropriate algorithm at runtime.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/strategy/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/strategy/StrategyTest.java)

#### Client Code example

```java
CalculatorContext calculator = new CalculatorContext();
calculator.setBehavior(new AdditionStrategy());
calculator.calculate(2,6); // 8
calculator.setBehavior(new MultiplicationStrategy());
calculator.calculate(2,6); // 12
```
### Template Method Pattern
### Visitor Pattern