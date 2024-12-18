# Gang of Four (GoF) design patterns

A cheat sheet of design patterns for your daily Java work. 

Here are some hints and client codes to simplify decisions, links to example codes and tests to read function an meaning. 

> Remark: The class names are oriented towards patterns to recognize the structure. In practice, one would choose the names based on their function. As well unit tests are not fully covering, just showing function of patterns. It is a cheat sheet focussing fast election of patterns - or not - to avoid over engineering. 

## Creational Patterns

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

#### Client Code example

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

:pencil2:  The Prototype Pattern is a creational design pattern used to create objects based on a template of an existing object through cloning. It is particularly useful when the construction of a new instance is more efficient by copying an existing instance rather than creating it from scratch. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/creational/prototype)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/creational/prototype/PrototypeTest.java)

#### Client Code example

```java
CirclePrototype circlePrototype = new CirclePrototype();
circlePrototype.x = 1;
circlePrototype.y = 1;
circlePrototype.radius = 10;
circlePrototype.color = "blue";

CirclePrototype circle = (CirclePrototype) circlePrototype.clone();
```

## Structural Patterns

### Adapter Pattern
:pencil2: The Adapter pattern is a design pattern that allows adapting the interface of an existing object so that it can be used by a class that was originally incompatible with this object. The Adapter pattern is often used to integrate existing class libraries or other external APIs without needing to change their codebase.

The Adapter pattern consists of four main components:
* A Target interface, which represents the interface that the class using the Adapter pattern wants to use.
* An 'Adaptee' class, which is the class to be integrated but does not implement the Target interface.
* An Adapter class, which implements the 'Adaptee' class and the Target interface. The Adapter class then translates the method calls of the Target interface into method calls to the 'Adaptee' class.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/structural/adapter)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/structural/adapter/AdapterTest.java)

#### Client Code example

```java
ApiAdaptee<String> fakeApiAdaptee = () -> "{\"id\": 42, \"name\": \"John Doe\"}";
Target<Record> apiTarget = new ApiAdapter(fakeApiAdaptee);
Record actualRecord = apiTarget.fetchData();
Record expeRecord = new Target.Record(42, "John Doe");
```
In this example fakeApiAdaptee represents an external code or api without code insight. 

### Bridge Pattern

:pencil2: The Bridge Pattern decouples an abstraction from its implementation so that the two can vary independently. Abstraction defines a high-level interface that uses an implementation object. Refined Abstraction extends the abstraction interface.
Implementor defines the interface for implementation classes. Concrete Implementors provide the specific implementation of the Implementor interface.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/structural/bridge/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/structural/bridge/BridgeTest.java)

#### Client Code example

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

### Composite Pattern

:pencil2: The Composite Pattern is a structural design pattern used to treat individual objects and compositions of objects uniformly. It is commonly used when you want to represent part-whole hierarchies. The pattern lets clients treat both individual objects (leaves) and compositions of objects (composites) uniformly.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/structural/composite/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/structural/composite/CompositeTest.java)

#### Client Code example

```java
File file1 = new File("file1.txt", 120);
File file2 = new File("file2.txt", 200);

Folder folder1 = new Folder("Folder1");
Folder folder2 = new Folder("Folder2");

folder1.addComponent(file1);
folder1.addComponent(file2);

folder2.addComponent(folder1);
```

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

⌛

### Flyweight Pattern

⌛

### Proxy Pattern

⌛

## Behavioral Patterns

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

Here data context is passed on process and handler does not care about handling next, building chain, steering handle tasks from outside of handle method. 

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

> Handling guard can vary in complexity...

```java
if (memberList.isEmpty()) {
    return memberList;
}
```

### Command Pattern

:pencil2: The Command pattern encapsulates a request as an object, allowing other objects to parameterize with different requests, enqueue commands in queues, log them, or support undo operations.
This behavioral pattern separates tasks into small steps, enabling high reusability and can be used asynchronous concurrency.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/command)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/command/ComandTest.java)

In this example receiver gets together with data storage object, this even can be separated. Obvious `Person` type is immutable but not used as record to provide multiple constructors. 

#### Client Code example

```java
PersonInvoker invoker = new PersonInvoker();
PersonSetReceiver list = new PersonSetReceiver();

invoker.setCommand(new CreatePersonCommand(list, new Person("John", 62)));
invoker.setCommand(new CreatePersonCommand(list, new Person("Peter", 43)));
invoker.setCommand(new CreatePersonCommand(list, new Person("James", 21)));

invoker.setCommand(new UpdatePersonCommand(list, new Person(1L, "Paul", 34)));
invoker.setCommand(new DeletePersonCommand(list, new Person(1L)));

invoker.runCommand();
``` 

### Interpreter Pattern

:pencil2: The Interpreter Pattern defines a representation for a status and provides an interpreter to process it into another form. This pattern is useful for designing a syntax tree structure that can interpret sentences, commands, or expressions, allowing for language processing within the software. By encapsulating language-specific grammar and interpretation logic, the Interpreter Pattern simplifies the implementation of complex parsing and evaluation tasks, making it easier to maintain and extend language features.

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/interpreter)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/interpreter/InterpreterTest.java)

#### Client Code example

```java       
Context context = new Context('A');
Interpreter vowelInterpreter = new VowelInterpreter();

vowelInterpreter.interpret(context.character());
```

### Iterator Pattern

:pencil2: The Iterator Pattern simplifies traversing collections without exposing their structure. With a custom iterator, you can tailor traversal to specific needs. Java's built-in iterators streamline iteration over standard collections, ensuring consistency and interoperability. 

#### Variant 1: Example using simply Java's built-in iterator

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/iterator/simple)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/iterator/simple/SimpleIteratorTest.java)

#### Variant 2: Example using custom iterator

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/iterator/customiterator)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/iterator/customiterator/CustomIteratorTest.java)

#### Client Code example

```java
List<Integer> numbers = new ArrayList<>(List.of(1, 2));
ConcreteAggregate<Integer> aggregate = new ConcreteAggregate<>(numbers);
Iterator<Integer> iterator = aggregate.createIterator();

List<Integer> result = new ArrayList<>();
while (iterator.hasNext()) {
    result.add(iterator.next());
}
```

### Mediator Pattern

:pencil2: The Mediator pattern is a behavioral design pattern that allows objects to communicate with each other without needing to know each other's implementation. 
When a 'colleague' sends a message through the mediator, the mediator distributes the message to all other 'colleagues' except the sender. This bidirectional communication demonstrates the Mediator pattern's central idea: decoupling the objects communicating with each other by introducing a mediator object. Instead of directly interacting with each other, objects communicate through the mediator, which encapsulates the communication logic and facilitates indirect communication between them.
 
:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/mediator/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/mediator/MediatorTest.java)

#### Client Code example

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

### Memento Pattern

:pencil2: The Memento pattern enables the capture and externalization of an object's internal state, without violating encapsulation. It achieves this by allowing an object to create a memento object that stores its state, which can later be restored to the object. This pattern is particularly useful in scenarios where the state of an object needs to be saved and restored, such as in undo mechanisms or checkpoints in an application. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/memento/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/memento/MementoTest.java)

#### Client Code example

```java       
Originator originator = new Originator("foo");
Caretaker caretaker = new Caretaker();
originator.changeState("bar");
caretaker.addMemento(originator.createSnapshot());
originator.restoreSnapshot(caretaker.getMemento(0));
String actualFooBar = originator.getState();
```
### Observer Pattern

:pencil2: The Observer Pattern is a design pattern where an object (the subject) maintains a list of its dependents (observers) and notifies them of any state changes. This allows for loose coupling between components, making it easier to maintain and extend the system. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/observer/simple/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/observer/simple/ObserverSimpleTest.java)

#### Client Code example

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

#### Variant delegating event handling using java.beans.PropertyChangeListener

This example makes use of PropertyChangeListener-API of java.beans module. It delegates notification and verification of state change to module. Even registration of listeners will be supported in PropertyChangeListener. 

Client code example, see above - interface did not change. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/observer/propertychange/)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/observer/propertychange/ObserverPropertyChangeTest.java)
 
### State Pattern

⌛

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

:pencil2: Gang of Four describes the purpose of the "Template Method" pattern as [follows:](https://archive.org/details/designpatternsel00gamm/page/324/mode/2up)
"Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses define certain steps of an algorithm without changing the algorithm's structure". 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/template)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/template/TemplateMethodTest.java)

### Visitor Pattern

:pencil2: Visitor pattern allows operations to be performed on elements of a structure without knowing the elements themselves. This is achieved by defining a separate "Visitor" class that provides specific operations for each element of the structure. The elements of the structure then implement an "accept" method, which allows the Visitor to perform the operations on the element.

The Visitor pattern is often used in scenarios where one wants to perform operations on various elements of a structure without knowing the elements themselves or changing their class hierarchy. It provides a way to make behavioral changes to elements of a structure without modifying the elements themselves. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/behavioral/visitor)

:pill: [Link to test](src/test/java/com/abach42/designpatterns/unit/behavioral/visitor/VisitorTest.java)

#### Client Code example

Visitor methods in this example are divided by override of different element types. 
Element-visitation methods named by their certain element is possible, too. 

```java
ObjectStructure zoo = new ObjectStructure();
zoo.addAnimal(new LionElement());
zoo.addAnimal(new ElephantElement());

Visitor feedingVisitor = new FeedingVisitor();
Visitor VeterinarianVisitor = new VeterinarianVisitor();
zoo.visitAnimals(feedingVisitor);
zoo.visitAnimals(VeterinarianVisitor);
```

You could make use of functional interface of `Consumer` instead of defining accept on your own: 

```diff
+ import java.util.function.Consumer;

- public interface Element {
+ public interface Element extends Consumer<Visitor> {
-   void accept(Visitor visitor);
-
    boolean isFedUp();
    boolean isHealthChecked();
```

Loop in `ObjectStructure` would do same job: 
```diff
public void visitAnimals(Visitor visitor) {
    animals.forEach(element -> element.accept(visitor));
}
```