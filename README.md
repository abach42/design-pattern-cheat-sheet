# Java Design Patterns Cheat Sheet – Gang of Four (GoF) Examples

[![CI](https://github.com/abach42/design-pattern-cheat-sheet/actions/workflows/ci.yml/badge.svg)](https://github.com/abach42/design-pattern-cheat-sheet/actions/workflows/ci.yml)
[![Release](https://img.shields.io/github/v/release/abach42/design-pattern-cheat-sheet)](https://github.com/abach42/design-pattern-cheat-sheet/releases)
![Java 21](https://img.shields.io/badge/Java-21-blue)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)

A Java design patterns cheat sheet covering all 23 Gang of Four (GoF) patterns – creational, structural and behavioral – with short explanations, client code examples, runnable source code and JUnit tests.

Use it in your daily Java work to quickly decide which design pattern fits a problem – or whether you need a pattern at all. Every pattern comes with its intent, when to use it and when to avoid it, a client code example, a link to the Java source code and a link to a JUnit test that shows how the pattern works.

> Remark: The class names follow the roles of each pattern (e.g. `Creator`, `Adaptee`, `Visitor`) so you can recognize its structure. In practice, you would name classes after their function. The unit tests are not meant to be complete; they demonstrate how each pattern works. The focus of this cheat sheet is choosing a pattern quickly – or deliberately not choosing one – to avoid over-engineering.

## Table of Contents

| Creational Patterns | Structural Patterns | Behavioral Patterns |
| :--- | :--- | :--- |
| [Singleton](#singleton-pattern-in-java) | [Adapter](#adapter-pattern-in-java) | [Chain of Responsibility](#chain-of-responsibility-pattern-in-java) |
| [Factory Method](#factory-method-pattern-in-java) | [Bridge](#bridge-pattern-in-java) | [Command](#command-pattern-in-java) |
| [Abstract Factory](#abstract-factory-pattern-in-java) | [Composite](#composite-pattern-in-java) | [Interpreter](#interpreter-pattern-in-java) |
| [Builder](#builder-pattern-in-java) | [Decorator](#decorator-pattern-in-java) | [Iterator](#iterator-pattern-in-java) |
| [Prototype](#prototype-pattern-in-java) | [Facade](#facade-pattern-in-java) | [Mediator](#mediator-pattern-in-java) |
| | [Flyweight](#flyweight-pattern-in-java) | [Memento](#memento-pattern-in-java) |
| | [Proxy](#proxy-pattern-in-java) | [Observer](#observer-pattern-in-java) |
| | | [State](#state-pattern-in-java) |
| | | [Strategy](#strategy-pattern-in-java) |
| | | [Template Method](#template-method-pattern-in-java) |
| | | [Visitor](#visitor-pattern-in-java) |

**More:** [Run the examples](#run-the-examples) · [References](#references) · [License](#license)

## Creational Design Patterns in Java

Creational patterns abstract the instantiation process: they decide how, when and which objects are created.

### Singleton Pattern in Java

:pencil2: The Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. It's useful when exactly one object is needed to coordinate actions across the system.

**Use when:** exactly one shared instance is required, e.g. a configuration registry or a hardware access point.
**Avoid when:** you only want a convenient global variable – prefer dependency injection.

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

The lazy variant above is not thread-safe. In multi-threaded Java code, prefer the enum singleton or the initialization-on-demand holder idiom:

```java
public enum EnumSingleton {
    INSTANCE;
}
```

```java
public class HolderSingleton {
    private HolderSingleton() {}

    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

While the Singleton pattern can be useful in certain situations, it's also often considered an "anti-pattern" due to drawbacks like hidden dependencies, concurrency issues and testing challenges.

### Factory Method Pattern in Java

:pencil2: The Factory Method is a creational pattern that defines a method for creating an object. Which type is instantiated is decided by the concrete class that implements this method.

**Use when:** a class can't anticipate which concrete type it must create, and subclasses should decide.
**Avoid when:** there is only one product type – a constructor or static factory method is enough.

:bulb: [Factory Method Java source code](src/main/java/com/abach42/designpatterns/creational/factorymethod)

:pill: [Factory Method JUnit test](src/test/java/com/abach42/designpatterns/creational/factorymethod/FactoryMethodTest.java)

#### Factory Method client code example

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

### Abstract Factory Pattern in Java

:pencil2: The Abstract Factory pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It's useful when you need to ensure that the created objects are compatible with each other and when you want to hide the implementation details of the creation process.

**Use when:** several products must be created as a consistent family (e.g. UI widgets per theme).
**Avoid when:** you have a single product type – use a Factory Method instead.

:bulb: [Abstract Factory Java source code](src/main/java/com/abach42/designpatterns/creational/abstractfactory)

:pill: [Abstract Factory JUnit test](src/test/java/com/abach42/designpatterns/creational/abstractfactory/AbstractFactoryTest.java)

#### Abstract Factory client code example

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

### Builder Pattern in Java

:pencil2: The Builder pattern is a creational pattern that composes data in steps and separates the construction process from the representation. It allows you to produce different types and representations of an object using the same construction process. This pattern is particularly useful when dealing with objects that have numerous parameters or configurations, as it provides a clear way to separate the construction logic from the rest of the code. See variants in the [Builder JUnit test](src/test/java/com/abach42/designpatterns/creational/builder/BuilderTest.java).

**Use when:** an object has many (optional) parameters or must be assembled in steps.
**Avoid when:** an object has only a few required fields – a constructor or a Java `record` is clearer.

:bulb: [Builder Java source code](src/main/java/com/abach42/designpatterns/creational/builder)

:pill: [Builder JUnit test](src/test/java/com/abach42/designpatterns/creational/builder/BuilderTest.java)

#### Builder client code example

```java
Director director = new Director();

BareboneConcreteBuilder bareboneBuilder = new BareboneConcreteBuilder();
director.constructBasicComputer(bareboneBuilder);
BareboneProduct bareboneProduct = bareboneBuilder.build();

System.out.println(bareboneProduct.toString());
```

### Prototype Pattern in Java

:pencil2: The Prototype Pattern is a creational design pattern used to create objects based on a template of an existing object through cloning. It is particularly useful when creating a new instance by copying an existing one is more efficient than creating it from scratch.

**Use when:** object creation is expensive and many similar objects are needed.
**Avoid when:** objects hold deep or circular references that make cloning error-prone.

:bulb: [Prototype Java source code](src/main/java/com/abach42/designpatterns/creational/prototype)

:pill: [Prototype JUnit test](src/test/java/com/abach42/designpatterns/creational/prototype/PrototypeTest.java)

#### Prototype client code example

```java
CirclePrototype circlePrototype = new CirclePrototype();
circlePrototype.x = 1;
circlePrototype.y = 1;
circlePrototype.radius = 10;
circlePrototype.color = "blue";

CirclePrototype circle = (CirclePrototype) circlePrototype.clone();
```

## Structural Design Patterns in Java

Structural patterns describe how classes and objects are composed into larger structures.

### Adapter Pattern in Java

:pencil2: The Adapter pattern is a design pattern that adapts the interface of an existing object so that it can be used by a class that was originally incompatible with this object. The Adapter pattern is often used to integrate existing class libraries or external APIs without needing to change their codebase.

**Use when:** you need to use an existing class or external API whose interface doesn't match yours.
**Avoid when:** you control both sides – change the interface instead.

The Adapter pattern consists of three main components:
* A Target interface, which represents the interface that the client wants to use.
* An 'Adaptee' class, which is the class to be integrated but does not implement the Target interface.
* An Adapter class, which implements the Target interface and wraps the 'Adaptee'. The Adapter translates the method calls of the Target interface into method calls to the 'Adaptee'.

:bulb: [Adapter Java source code](src/main/java/com/abach42/designpatterns/structural/adapter)

:pill: [Adapter JUnit test](src/test/java/com/abach42/designpatterns/structural/adapter/AdapterTest.java)

#### Adapter client code example

```java
ApiAdaptee<String> fakeApiAdaptee = () -> "{\"id\": 42, \"name\": \"John Doe\"}";
Target<Record> apiTarget = new ApiAdapter(fakeApiAdaptee);
Record actualRecord = apiTarget.fetchData();
Record expeRecord = new Target.Record(42, "John Doe");
```
In this example `fakeApiAdaptee` represents external code or an API without code insight.

### Bridge Pattern in Java

:pencil2: The Bridge Pattern decouples an abstraction from its implementation so that the two can vary independently. Abstraction defines a high-level interface that uses an implementation object. Refined Abstraction extends the abstraction interface.
Implementor defines the interface for implementation classes. Concrete Implementors provide the specific implementation of the Implementor interface.

**Use when:** two dimensions (e.g. shape and renderer) would otherwise multiply into a class explosion.
**Avoid when:** there is only one implementation – the extra indirection adds nothing.

:bulb: [Bridge Java source code](src/main/java/com/abach42/designpatterns/structural/bridge/)

:pill: [Bridge JUnit test](src/test/java/com/abach42/designpatterns/structural/bridge/BridgeTest.java)

#### Bridge client code example

```java
Renderer2D renderer2D = new Renderer2D();
Circle circle = new Circle(renderer2D, 5.0, new Point2D.Double(10, 10));

Ellipse2D result = (Ellipse2D) circle.draw();
```

```java
Renderer3D renderer3D = new Renderer3D();
Circle circle = new Circle(renderer3D, 5.0, new Point2D.Double(10, 10));

Circle3DHelper result = (Circle3DHelper) circle.draw();
```

```java
Renderer3D renderer3D = new Renderer3D();
Rectangle rectangle = new Rectangle(renderer3D, 10.0, 5.0, new Point2D.Double(0, 0));

Rectangle3DHelper result = (Rectangle3DHelper) rectangle.draw();
```

### Composite Pattern in Java

:pencil2: The Composite Pattern is a structural design pattern used to represent part-whole hierarchies as tree structures. It lets clients treat individual objects (leaves) and compositions of objects (composites) uniformly.

**Use when:** you model trees such as file systems, menus or organization charts.
**Avoid when:** leaves and containers need very different interfaces.

:bulb: [Composite Java source code](src/main/java/com/abach42/designpatterns/structural/composite/)

:pill: [Composite JUnit test](src/test/java/com/abach42/designpatterns/structural/composite/CompositeTest.java)

#### Composite client code example

```java
File file1 = new File("file1.txt", 120);
File file2 = new File("file2.txt", 200);

Folder folder1 = new Folder("Folder1");
Folder folder2 = new Folder("Folder2");

folder1.addComponent(file1);
folder1.addComponent(file2);

folder2.addComponent(folder1);
```

### Decorator Pattern in Java

:pencil2: The Decorator pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

The Decorator pattern allows you to stack decorators on top of each other, each adding its own behavior, and provides a flexible way to modify the behavior of individual objects at runtime.

**Use when:** you need combinable extensions at runtime instead of a subclass for every combination.
**Avoid when:** the order of many small wrappers becomes hard to understand and debug.

:bulb: [Decorator Java source code](src/main/java/com/abach42/designpatterns/structural/decorator/)

:pill: [Decorator JUnit test](src/test/java/com/abach42/designpatterns/structural/decorator/DecoratorTest.java)

#### Decorator client code example

```java
Component order = new FoamMilkDecorator(
    new ChocolateDecorator(
        new EspressoComponent()
    )
);

System.out.println(String.format("%.2f", order.calculatePrice()));
```

### Facade Pattern in Java

:pencil2: The Facade pattern provides a simplified interface to a set of complex subsystems. It allows clients to interact with a single unified interface without needing to understand the inner workings of each subsystem.

**Use when:** clients need a simple entry point to a complex subsystem.
**Avoid when:** the facade grows into a "god object" that knows everything.

:bulb: [Facade Java source code](src/main/java/com/abach42/designpatterns/structural/facade)

:pill: [Facade JUnit test](src/test/java/com/abach42/designpatterns/structural/facade/FacadeTest.java)

#### Facade client code example

```java
OrderFacade facade = new OrderFacade();
String result = facade.placeOrder("Laptop", 2, 2000.0);
```
```java
public class OrderFacade {
    private final PaymentProcessor paymentProcessor;
    private final InventoryManager inventoryManager;
    private final ShippingService shippingService;
    
    // ... some constructor

    public String placeOrder(String product, int quantity, double amount) {
        // operations accessing fields of subsystems
        
        return // some value
    }
}
```
        
### Flyweight Pattern in Java

:pencil2: The Flyweight pattern is a structural design pattern that minimizes memory usage by sharing as much data as possible with similar objects. It separates **intrinsic state** (shared, immutable data) from **extrinsic state** (context-dependent, provided from outside).

The pattern is useful when a system needs to handle a large number of fine-grained objects efficiently, such as characters in a text editor, tiles in a game, or icons in a UI.

**Use when:** a huge number of similar objects causes memory pressure.
**Avoid when:** there are few objects – the added complexity doesn't pay off.

Components:

* **Flyweight**: declares interface for objects that can act as shared.
* **ConcreteFlyweight**: implements the Flyweight and stores intrinsic state.
* **UnsharedConcreteFlyweight**: objects that cannot be shared but may use Flyweights internally.
* **FlyweightFactory**: creates and manages Flyweight objects, ensuring they are reused.

:bulb: [Flyweight Java source code](src/main/java/com/abach42/designpatterns/structural/flyweight)

:pill: [Flyweight JUnit test](src/test/java/com/abach42/designpatterns/structural/flyweight/FlyweightTest.java)

#### Flyweight client code example

```java
FlyweightFactory factory = new FlyweightFactory();

Flyweight sharedA1 = factory.getFlyweight("A");
Flyweight sharedA2 = factory.getFlyweight("A");
Flyweight sharedB = factory.getFlyweight("B");

String first = sharedA1.operation("first");
// "Intrinsic: A, Extrinsic: first"
String second = sharedA2.operation("second");
// "Intrinsic: A, Extrinsic: second"
String context = sharedB.operation("context");
// "Intrinsic: B, Extrinsic: context"
```

To keep the interface for objects that are not shared:
```java
Flyweight unshared = new UnsharedConcreteFlyweight("CustomState");
String result = unshared.operation("external context");
// "Unshared: CustomState, Extrinsic: external context"
```

### Proxy Pattern in Java

:pencil2: The Proxy pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. This can be useful for lazy initialization, access control, logging, or caching. The Proxy implements the same interface as the RealSubject and delegates calls to it, while possibly adding extra behavior.

**Use when:** you need lazy loading, access control, caching or logging around an object.
**Avoid when:** a framework feature (e.g. Spring AOP, `java.lang.reflect.Proxy`) already covers it.

:bulb: [Proxy Java source code](src/main/java/com/abach42/designpatterns/structural/proxy)

:pill: [Proxy JUnit test](src/test/java/com/abach42/designpatterns/structural/proxy/ProxyTest.java)

#### Proxy client code example

```java
RealSubject real = new RealSubject();
Proxy proxy = new Proxy(real);

String result = proxy.getData();
```

## Behavioral Design Patterns in Java

Behavioral patterns describe how objects communicate and how responsibilities are distributed between them.

### Chain of Responsibility Pattern in Java

:pencil2: The Chain of Responsibility pattern is a design pattern where a request is passed through a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain. It promotes loose coupling between the sender and receiver of a request and is commonly used in scenarios like event handling or middleware processing in web applications.

**Use when:** a request runs through configurable processing steps (filters, middleware, validation).
**Avoid when:** the order is fixed and short – plain method calls are easier to follow.

:bulb: [Chain of Responsibility Java source code](src/main/java/com/abach42/designpatterns/behavioral/chain/context/)

:pill: [Chain of Responsibility JUnit test](src/test/java/com/abach42/designpatterns/behavioral/chain/context/ContextChainTest.java)

#### Chain of Responsibility client code example

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

#### Variant 1: Simple Chain of Responsibility

This example works without a data context, and handlers do not decide whether to process or pass the request.

:bulb: [Simple Chain of Responsibility Java source code](src/main/java/com/abach42/designpatterns/behavioral/chain/simple/)

:pill: [Simple Chain of Responsibility JUnit test](src/test/java/com/abach42/designpatterns/functional/chain/simple/behavioral/SimpleChainTest.java)

##### Client code example

```java
AbstractHandler firstHandler = new FirstHandler();
AbstractHandler secondHandler = new SecondHandler();
firstHandler.setNext(secondHandler);
firstHandler.handle();
```

#### Variant 2: Chain of Responsibility with delegated handling

Here the data context is passed through the process. Handlers don't care about calling the next handler or building the chain; the handling is steered from outside of the handle method.

:bulb: [Delegating Chain of Responsibility Java source code](src/main/java/com/abach42/designpatterns/behavioral/chain/delegation/)

:pill: [Delegating Chain of Responsibility JUnit test](src/test/java/com/abach42/designpatterns/behavioral/chain/delegation/DelegationChainTest.java)

##### Client code example

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

> Handling guard can vary in complexity...

```java
if (memberList.isEmpty()) {
    return memberList;
}
```

### Command Pattern in Java

:pencil2: The Command pattern encapsulates a request as an object, allowing other objects to be parameterized with different requests, to queue or log commands, or to support undo operations.
This behavioral pattern separates tasks into small steps, enables high reusability and can be used for asynchronous execution.

**Use when:** you need undo/redo, queues, logging or deferred execution of operations.
**Avoid when:** a simple method call or a lambda (`Runnable`) does the job.

:bulb: [Command Java source code](src/main/java/com/abach42/designpatterns/behavioral/command)

:pill: [Command JUnit test](src/test/java/com/abach42/designpatterns/behavioral/command/CommandTest.java)

In this example the receiver also acts as data storage; both could be separated. It hands out ids from a counter, so ids stay unique after updates and deletes. The invoker removes each command from its queue when it runs it.

#### Command client code example

```java
PersonInvoker invoker = new PersonInvoker();
PersonReceiver receiver = new PersonReceiver();

invoker.addCommand(new CreatePersonCommand(receiver, "John", 62));
invoker.addCommand(new CreatePersonCommand(receiver, "Peter", 43));
invoker.addCommand(new CreatePersonCommand(receiver, "James", 21));

invoker.addCommand(new UpdatePersonCommand(receiver, new Person(1L, "Paul", 34)));
invoker.addCommand(new DeletePersonCommand(receiver, 1L));

invoker.runCommands();
``` 

### Interpreter Pattern in Java

:pencil2: The **Interpreter Pattern** defines a grammar and provides an interpreter that evaluates sentences of that grammar.
Each rule or symbol of the grammar corresponds to a class implementing a common interface.

This pattern is suitable for small domain-specific languages, rule engines, and formula evaluators.

**Use when:** you evaluate a small, stable grammar (boolean rules, simple formulas).
**Avoid when:** the grammar is large or changes often – use a parser generator instead.

* `Expression` – defines the `interpret(Context)` interface.
* `VariableExpression` – represents variables (terminal symbols).
* `NonTerminalExpression` – represents grammar rules combining other expressions (`AND`, `OR`, `NOT`, etc.).
* `Context` – provides variable values.
* `Client` – builds and interprets expression trees.

:bulb: [Interpreter Java source code](src/main/java/com/abach42/designpatterns/behavioral/interpreter)

:pill: [Interpreter JUnit test](src/test/java/com/abach42/designpatterns/behavioral/interpreter/InterpreterTest.java)

#### Interpreter client code example

```java
Context context = new Context(Map.of(
        "a", true,
        "b", false,
        "c", true
));

// Expression: a AND NOT (b OR c)
Expression expr = new AndExpression(
        new VariableExpression("a"),
        new NotExpression(
                new OrExpression(
                        new VariableExpression("b"),
                        new VariableExpression("c")
                )
        )
);

boolean result = expr.interpret(context); // false
```

### Iterator Pattern in Java

:pencil2: The Iterator Pattern simplifies traversing collections without exposing their structure. With a custom iterator, you can tailor traversal to specific needs. Java's built-in iterators streamline iteration over standard collections, ensuring consistency and interoperability.

**Use when:** a custom data structure should be traversable without exposing its internals.
**Avoid when:** a standard Java collection or `Iterable` already provides what you need.

#### Variant 1: Using Java's built-in iterator

:bulb: [Simple Iterator Java source code](src/main/java/com/abach42/designpatterns/behavioral/iterator/simple)

:pill: [Simple Iterator JUnit test](src/test/java/com/abach42/designpatterns/behavioral/iterator/simple/SimpleIteratorTest.java)

#### Variant 2: Custom iterator

:bulb: [Custom Iterator Java source code](src/main/java/com/abach42/designpatterns/behavioral/iterator/customiterator)

:pill: [Custom Iterator JUnit test](src/test/java/com/abach42/designpatterns/behavioral/iterator/customiterator/CustomIteratorTest.java)

#### Iterator client code example

```java
List<Integer> numbers = new ArrayList<>(List.of(1, 2));
ConcreteAggregate<Integer> aggregate = new ConcreteAggregate<>(numbers);
Iterator<Integer> iterator = aggregate.createIterator();

List<Integer> result = new ArrayList<>();
while (iterator.hasNext()) {
    result.add(iterator.next());
}
```

### Mediator Pattern in Java

:pencil2: The Mediator pattern is a behavioral design pattern that allows objects to communicate with each other without needing to know each other's implementation.
When a 'colleague' sends a message through the mediator, the mediator distributes the message to all other 'colleagues' except the sender. This bidirectional communication demonstrates the Mediator pattern's central idea: decoupling the objects communicating with each other by introducing a mediator object. Instead of directly interacting with each other, objects communicate through the mediator, which encapsulates the communication logic and facilitates indirect communication between them.

**Use when:** many objects talk to each other and the dependencies become a tangled web.
**Avoid when:** only two objects interact – the mediator just adds indirection.

:bulb: [Mediator Java source code](src/main/java/com/abach42/designpatterns/behavioral/mediator/)

:pill: [Mediator JUnit test](src/test/java/com/abach42/designpatterns/behavioral/mediator/MediatorTest.java)

#### Mediator client code example

```java       
Mediator mediator = new Mediator();

ConcreteGermanColleague germanColleague = new ConcreteGermanColleague(mediator);
ConcretePolishColleague polishColleague = new ConcretePolishColleague(mediator);

mediator.addColleague(germanColleague);
mediator.addColleague(polishColleague);

germanColleague.send("Schönes Wetter!");
polishColleague.send("ładna pogoda!");

polishColleague.getLastReceivedMessage(); // "Witaj świecie: Schönes Wetter!"
germanColleague.getLastReceivedMessage(); // "Hallo Welt: ładna pogoda!"
```

### Memento Pattern in Java

:pencil2: The Memento pattern captures and externalizes an object's internal state without violating encapsulation. The object creates a memento that stores its state, which can later be restored. This pattern is particularly useful when the state of an object needs to be saved and restored, such as in undo mechanisms or checkpoints in an application.

**Use when:** you need undo, snapshots or checkpoints without exposing internal state.
**Avoid when:** the state is large and snapshots become too expensive in memory.

:bulb: [Memento Java source code](src/main/java/com/abach42/designpatterns/behavioral/memento/)

:pill: [Memento JUnit test](src/test/java/com/abach42/designpatterns/behavioral/memento/MementoTest.java)

#### Memento client code example

```java       
Originator originator = new Originator("foo");
Caretaker caretaker = new Caretaker();
originator.changeState("bar");
caretaker.addMemento(originator.createSnapshot());
originator.restoreSnapshot(caretaker.getMemento(0));
String actualFooBar = originator.getState();
```

### Observer Pattern in Java

:pencil2: The Observer Pattern is a design pattern where an object (the subject) maintains a list of its dependents (observers) and notifies them of any state changes. This allows for loose coupling between components, making it easier to maintain and extend the system.

**Use when:** several objects must react to state changes of another object (events, UI updates).
**Avoid when:** notification chains become hard to trace – consider explicit calls or an event bus.

:bulb: [Observer Java source code](src/main/java/com/abach42/designpatterns/behavioral/observer/simple/)

:pill: [Observer JUnit test](src/test/java/com/abach42/designpatterns/behavioral/observer/simple/ObserverSimpleTest.java)

#### Observer client code example

```java

ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
AbstractObserver.createAndAttach(new CalculateDistanceObserver(subject));
AbstractObserver.createAndAttach(new CalculateDurationObserver(subject));
        
RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));
//subject.detachObserver(/*some concrete observer*/);
subject.setStateEntity(route);

System.out.println(
    "You would have " 
    + new DecimalFormat("#0.00").format(route.getDuration()) 
    + " h to travel"
);

```

#### Variant: Observer with java.beans.PropertyChangeListener

This example uses the PropertyChangeListener API of the `java.beans` module. It delegates notification and the check for state changes to the module. PropertyChangeSupport also handles the registration of listeners.

The client code is the same as above – the interface did not change.

:bulb: [Observer with PropertyChangeListener Java source code](src/main/java/com/abach42/designpatterns/behavioral/observer/propertychange/)

:pill: [Observer with PropertyChangeListener JUnit test](src/test/java/com/abach42/designpatterns/behavioral/observer/propertychange/ObserverPropertyChangeTest.java)
 
### State Pattern in Java

:pencil2: The State pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. The object will appear to change its class. Instead of using conditional logic scattered across the code, states encapsulate behavior and transitions explicitly.

In practice, each State encapsulates rules of transitions, and the Context delegates behavior to its current state.

**Use when:** behavior depends on a state with clear transitions (workflows, documents, orders).
**Avoid when:** there are only two or three states with trivial logic – a `switch` over an `enum` is enough.

:bulb: [State Java source code](src/main/java/com/abach42/designpatterns/behavioral/state)

:pill: [State JUnit test](src/test/java/com/abach42/designpatterns/behavioral/state/StateTest.java)

#### State client code example

```java
Document document = new Document();
String firstState = document.getStateName();
// "Draft"

document.publish();
String secondState = document.getStateName();
// "Published"

document.archive();
String thirdState = document.getStateName();
// "Archived"
```

### Strategy Pattern in Java

:pencil2: The Strategy pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one of them, and make them interchangeable. It enables a client to choose a particular algorithm from the family of algorithms at runtime without altering the client's code.

The key idea behind the Strategy pattern is to encapsulate algorithms into separate classes and make them interchangeable. This allows the client to select the appropriate algorithm at runtime.

**Use when:** an algorithm must be exchangeable at runtime (pricing, sorting, calculation rules).
**Avoid when:** the algorithm never changes – or a lambda / functional interface is enough.

:bulb: [Strategy Java source code](src/main/java/com/abach42/designpatterns/behavioral/strategy/)

:pill: [Strategy JUnit test](src/test/java/com/abach42/designpatterns/behavioral/strategy/StrategyTest.java)

#### Strategy client code example

```java
CalculatorContext calculator = new CalculatorContext();
calculator.setBehavior(new AdditionStrategy());
calculator.calculate(2,6); // 8
calculator.setBehavior(new MultiplicationStrategy());
calculator.calculate(2,6); // 12
```

### Template Method Pattern in Java

:pencil2: Gang of Four describes the purpose of the "Template Method" pattern as [follows:](https://archive.org/details/designpatternsel00gamm/page/324/mode/2up)
"Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure."
It’s a way to outline the steps of a process while letting subclasses fill in the details. Think of it as a recipe: the main steps are fixed, but you can choose the ingredients for some parts.

**Use when:** several classes share the same process and differ only in individual steps.
**Avoid when:** deep inheritance hierarchies arise – prefer composition with a Strategy.

:bulb: [Template Method Java source code](src/main/java/com/abach42/designpatterns/behavioral/template)

:pill: [Template Method JUnit test](src/test/java/com/abach42/designpatterns/behavioral/template/TemplateMethodTest.java)

#### Template Method client code example

```java
UserProcessor userProcessor = new UserProcessor();
List<Data> dataList = userProcessor.fetchData();

ProductProcessor productProcessor = new ProductProcessor();
List<Data> dataList = productProcessor.fetchData();
```

### Visitor Pattern in Java

:pencil2: The Visitor pattern allows operations to be performed on elements of a structure without changing the classes of those elements. This is achieved by defining a separate "Visitor" class that provides specific operations for each element type. The elements implement an "accept" method, which allows the Visitor to perform its operations on the element.

The Visitor pattern is often used when you want to perform operations on various elements of a structure without changing their class hierarchy. It provides a way to add new behavior to elements of a structure without modifying the elements themselves.

**Use when:** you add many operations to a stable class hierarchy.
**Avoid when:** new element types are added often – every visitor has to change. In modern Java, sealed interfaces with pattern matching for `switch` are often simpler.

:bulb: [Visitor Java source code](src/main/java/com/abach42/designpatterns/behavioral/visitor)

:pill: [Visitor JUnit test](src/test/java/com/abach42/designpatterns/behavioral/visitor/VisitorTest.java)

#### Visitor client code example

The visitor methods in this example are overloaded for the different element types.
Naming each visit method after its element is possible, too.

```java
ObjectStructure zoo = new ObjectStructure();
zoo.addAnimal(new LionElement());
zoo.addAnimal(new ElephantElement());

Visitor feedingVisitor = new FeedingVisitor();
Visitor VeterinarianVisitor = new VeterinarianVisitor();
zoo.visitAnimals(feedingVisitor);
zoo.visitAnimals(VeterinarianVisitor);
```

You could use the functional interface `Consumer` instead of defining `accept` on your own:

```diff
+ import java.util.function.Consumer;

- public interface Element {
+ public interface Element extends Consumer<Visitor> {
-   void accept(Visitor visitor);
-
    boolean isFedUp();
    boolean isHealthChecked();
```

The loop in `ObjectStructure` would do the same job:
```diff
public void visitAnimals(Visitor visitor) {
    animals.forEach(element -> element.accept(visitor));
}
```

## Run the examples

Requirements: Java 21 and Maven.

```shell
git clone https://github.com/abach42/design-pattern-cheat-sheet.git
cd design-pattern-cheat-sheet
mvn test
```

Each pattern lives in its own package under `src/main/java/com/abach42/designpatterns/{creational|structural|behavioral}`, and the matching JUnit 5 tests are in `src/test/java`.

## References

* Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides: *Design Patterns: Elements of Reusable Object-Oriented Software* (Addison-Wesley, 1994) – the original "Gang of Four" book.

## License

This Java design patterns cheat sheet is licensed under the [GNU General Public License v3.0](LICENSE).
