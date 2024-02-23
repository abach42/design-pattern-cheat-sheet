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
### Abstract Factory Pattern
### Builder Pattern
### Prototype Pattern

## Structural Patterns:

### Adapter Pattern
### Bridge Pattern
### Composite Pattern
### Decorator Pattern

:pencil2: The Decorator pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

The Decorator pattern allows you to stack decorators on top of each other, each adding its own behavior, and providing a flexible way to modify the behavior of individual objects at runtime. 

:bulb: [Link to code example](src/main/java/com/abach42/designpatterns/structural/decorator)

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
### Command Pattern
### Interpreter Pattern
### Iterator Pattern
### Mediator Pattern
### Memento Pattern
### Observer Pattern
### State Pattern
### Strategy Pattern
### Template Method Pattern
### Visitor Pattern