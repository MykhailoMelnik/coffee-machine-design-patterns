# Coffee Machine System - Design Patterns Assignment

**Student:** Mykhailo Melnik  
**Course:** Java Design Patterns  
**Date:** January 2025

---

## Table of Contents

1. [Requirements](#requirements)
2. [Use Cases](#use-cases)
3. [CRC Cards](#crc-cards)
4. [Class Diagrams](#class-diagrams)
5. [Java Code Implementation](#java-code-implementation)

---

## Requirements

### Functional Requirements

#### 1. Drink Management
- The system must support different types of coffee (Espresso, Americano)
- The system must allow drink customization (milk, sugar)
- The system must display drink descriptions and costs

#### 2. Payment Processing
- The system must support different payment methods (cash, card)
- The system must process payments for drinks
- The system must validate payment amounts

#### 3. Order Processing
- The system must create drinks using factory pattern
- The system must apply decorators for customization
- The system must handle complete order workflow

### Non-Functional Requirements

#### 1. Performance
- The system must respond to input within 2 seconds
- The system must process payments within 5 seconds

#### 2. Reliability
- The system must handle errors gracefully
- The system must maintain data integrity

#### 3. Usability
- The interface must be intuitive
- Error messages must be clear

#### 4. Extensibility
- The system must support adding new drink types
- The system must support new payment methods

---

## Use Cases

### Use Case 1: Order Espresso with Milk and Card Payment

**Primary Actor:** Customer

**Goal:** Order an espresso with milk and pay by card

**Preconditions:** 
- Coffee machine is operational
- Customer has a valid card

**Main Flow:**
1. Customer selects "espresso" drink
2. Customer chooses to add milk
3. Customer chooses card payment
4. System creates espresso using CoffeeFactory
5. System applies MilkDecorator to the drink
6. System displays drink description
7. System processes card payment
8. System confirms order completion

**Alternative Flows:**
- If card payment fails, system displays error message
- If milk is not available, system offers drink without milk

**Postconditions:**
- Customer receives espresso with milk
- Payment is processed successfully

### Use Case 2: Order Americano with Sugar and Cash Payment

**Primary Actor:** Customer

**Goal:** Order an americano with sugar and pay by cash

**Preconditions:** 
- Coffee machine is operational
- Customer has sufficient cash

**Main Flow:**
1. Customer selects "americano" drink
2. Customer chooses to add sugar
3. Customer chooses cash payment
4. System creates americano using CoffeeFactory
5. System applies SugarDecorator to the drink
6. System displays drink description
7. System processes cash payment
8. System confirms order completion

**Alternative Flows:**
- If insufficient cash, system displays error message
- If sugar is not available, system offers drink without sugar

**Postconditions:**
- Customer receives americano with sugar
- Payment is processed successfully

### Use Case 3: Order Americano with Both Milk and Sugar

**Primary Actor:** Customer

**Goal:** Order an americano with both milk and sugar

**Preconditions:** 
- Coffee machine is operational

**Main Flow:**
1. Customer selects "americano" drink
2. Customer chooses to add both milk and sugar
3. Customer chooses payment method
4. System creates americano using CoffeeFactory
5. System applies MilkDecorator to the drink
6. System applies SugarDecorator to the drink
7. System displays drink description
8. System processes payment
9. System confirms order completion

**Alternative Flows:**
- If any ingredient is unavailable, system offers alternatives

**Postconditions:**
- Customer receives americano with milk and sugar
- Payment is processed successfully

---

## CRC Cards

### Class: CoffeeMachine
**Responsibilities:**
- Process drink orders
- Apply decorators to drinks
- Handle payment processing
- Display order information

**Collaborators:**
- CoffeeFactory
- DrinkDecorator
- PaymentStrategy

### Class: CoffeeFactory
**Responsibilities:**
- Create different types of drinks
- Validate drink types
- Return appropriate drink instances

**Collaborators:**
- Espresso
- Americano

### Class: Drink (Interface)
**Responsibilities:**
- Define drink interface
- Provide description method
- Provide cost calculation method

**Collaborators:**
- None (interface)

### Class: Espresso
**Responsibilities:**
- Implement espresso drink
- Provide espresso description
- Calculate espresso cost

**Collaborators:**
- Drink (implements)

### Class: Americano
**Responsibilities:**
- Implement americano drink
- Provide americano description
- Calculate americano cost

**Collaborators:**
- Drink (implements)

### Class: DrinkDecorator (Abstract)
**Responsibilities:**
- Define decorator pattern structure
- Hold reference to wrapped drink
- Delegate calls to wrapped drink

**Collaborators:**
- Drink

### Class: MilkDecorator
**Responsibilities:**
- Add milk to drinks
- Modify drink description
- Add milk cost to total

**Collaborators:**
- DrinkDecorator
- Drink

### Class: SugarDecorator
**Responsibilities:**
- Add sugar to drinks
- Modify drink description
- Add sugar cost to total

**Collaborators:**
- DrinkDecorator
- Drink

### Class: PaymentStrategy (Interface)
**Responsibilities:**
- Define payment interface
- Provide payment method

**Collaborators:**
- None (interface)

### Class: CashPayment
**Responsibilities:**
- Process cash payments
- Display cash payment message
- Handle cash payment logic

**Collaborators:**
- PaymentStrategy (implements)

### Class: CardPayment
**Responsibilities:**
- Process card payments
- Display card payment message
- Handle card payment logic

**Collaborators:**
- PaymentStrategy (implements)

### Class: Main
**Responsibilities:**
- Initialize coffee machine
- Demonstrate system usage
- Create example orders

**Collaborators:**
- CoffeeMachine
- CashPayment
- CardPayment

---

## Class Diagrams

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                              Coffee Machine System                          │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│      Main       │    │  CoffeeMachine  │    │  CoffeeFactory  │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ + main()        │    │ + processOrder()│    │ + createDrink() │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                              Payment Strategy                               │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│PaymentStrategy  │    │  CashPayment    │    │  CardPayment    │
│   (Interface)   │    │                 │    │                 │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ + pay(amount)   │    │ + pay(amount)   │    │ + pay(amount)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         ▲                       ▲                       ▲
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                              Drink Hierarchy                                │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│     Drink       │    │    Espresso     │    │   Americano     │
│   (Interface)   │    │                 │    │                 │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ + getDescription│    │ + getDescription│    │ + getDescription│
│ + cost()        │    │ + cost()        │    │ + cost()        │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         ▲                       ▲                       ▲
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                            Decorator Pattern                                │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ DrinkDecorator  │    │ MilkDecorator   │    │ SugarDecorator  │
│   (Abstract)    │    │                 │    │                 │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ # drink: Drink  │    │ + getDescription│    │ + getDescription│
│ + getDescription│    │ + cost()        │    │ + cost()        │
│ + cost()        │    └─────────────────┘    └─────────────────┘
└─────────────────┘
         ▲
         │
         └───────────────────────┼───────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                              Relationships                                  │
└─────────────────────────────────────────────────────────────────────────────┘

Main ───────────────► CoffeeMachine : uses
CoffeeMachine ──────► CoffeeFactory : creates drinks
CoffeeMachine ──────► PaymentStrategy : processes payments
CoffeeMachine ──────► DrinkDecorator : applies decorators
CoffeeFactory ──────► Drink : creates instances
DrinkDecorator ─────► Drink : wraps
MilkDecorator ──────► DrinkDecorator : extends
SugarDecorator ─────► DrinkDecorator : extends
CashPayment ────────► PaymentStrategy : implements
CardPayment ────────► PaymentStrategy : implements
Espresso ───────────► Drink : implements
Americano ──────────► Drink : implements
```

### Class Descriptions

#### 1. Main
- **Purpose:** Entry point of the program
- **Methods:** `main(String[] args)` - demonstrates system functionality
- **Relationships:** Uses CoffeeMachine, CashPayment, CardPayment

#### 2. CoffeeMachine
- **Purpose:** Main system class
- **Methods:** `processOrder(String, boolean, boolean, PaymentStrategy)` - processes orders
- **Relationships:** Uses CoffeeFactory, DrinkDecorator, PaymentStrategy

#### 3. CoffeeFactory (Factory Pattern)
- **Purpose:** Creates different types of drinks
- **Methods:** `createDrink(String)` - creates drink by type
- **Relationships:** Creates Espresso, Americano

#### 4. Drink (Interface)
- **Purpose:** Base interface for all drinks
- **Methods:** 
  - `getDescription()` - returns drink description
  - `cost()` - calculates cost
- **Relationships:** Implemented by Espresso, Americano

#### 5. Espresso
- **Purpose:** Concrete espresso drink
- **Methods:** Implements Drink interface
- **Relationships:** Implements Drink

#### 6. Americano
- **Purpose:** Concrete americano drink
- **Methods:** Implements Drink interface
- **Relationships:** Implements Drink

#### 7. DrinkDecorator (Decorator Pattern)
- **Purpose:** Base decorator
- **Fields:** `drink: Drink` - wrapped drink
- **Methods:** Delegates calls to wrapped drink
- **Relationships:** Wraps Drink, extended by MilkDecorator, SugarDecorator

#### 8. MilkDecorator
- **Purpose:** Adds milk to drinks
- **Methods:** Modifies description and cost
- **Relationships:** Extends DrinkDecorator

#### 9. SugarDecorator
- **Purpose:** Adds sugar to drinks
- **Methods:** Modifies description and cost
- **Relationships:** Extends DrinkDecorator

#### 10. PaymentStrategy (Strategy Pattern)
- **Purpose:** Interface for different payment methods
- **Methods:** `pay(double)` - processes payment
- **Relationships:** Implemented by CashPayment, CardPayment

#### 11. CashPayment
- **Purpose:** Processes cash payments
- **Methods:** Implements PaymentStrategy
- **Relationships:** Implements PaymentStrategy

#### 12. CardPayment
- **Purpose:** Processes card payments
- **Methods:** Implements PaymentStrategy
- **Relationships:** Implements PaymentStrategy

---

## Java Code Implementation

### Main.java
```java
public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();

        // Order 1: Espresso with milk, paid by card
        machine.processOrder("espresso", true, false, new CardPayment());

        // Order 2: Americano with sugar, paid by cash
        machine.processOrder("americano", false, true, new CashPayment());

        machine.processOrder("americano", true, true, new CashPayment());
    }
}
```

### CoffeeMachine.java
```java
class CoffeeMachine {
    public void processOrder(String drinkType, boolean addMilk, boolean addSugar, PaymentStrategy payment) {
        Drink drink = CoffeeFactory.createDrink(drinkType);

        if (addMilk) {
            drink = new MilkDecorator(drink);
        }

        if (addSugar) {
            drink = new SugarDecorator(drink);
        }

        System.out.println("Preparing: " + drink.getDescription());
        payment.pay(drink.cost());
    }
}
```

### CoffeeFactory.java
```java
class CoffeeFactory {
    public static Drink createDrink(String type) {
        return switch (type.toLowerCase()) {
            case "espresso" -> new Espresso();
            case "americano" -> new Americano();
            default -> throw new IllegalArgumentException("Unknown drink: " + type);
        };
    }
}
```

### Drink.java
```java
interface Drink {
    String getDescription();
    double cost();
}
```

### Espresso.java
```java
class Espresso implements Drink {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
```

### Americano.java
```java
class Americano implements Drink {
    @Override
    public String getDescription() {
        return "Americano";
    }

    @Override
    public double cost() {
        return 2.5;
    }
}
```

### DrinkDecorator.java
```java
abstract class DrinkDecorator implements Drink {
    protected Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String getDescription() {
        return drink.getDescription();
    }

    @Override
    public double cost() {
        return drink.cost();
    }
}
```

### MilkDecorator.java
```java
class MilkDecorator extends DrinkDecorator {
    public MilkDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + " + Milk";
    }

    @Override
    public double cost() {
        return drink.cost() + 0.5;
    }
}
```

### SugarDecorator.java
```java
class SugarDecorator extends DrinkDecorator {
    public SugarDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + " + Sugar";
    }

    @Override
    public double cost() {
        return drink.cost() + 0.2;
    }
}
```

### PaymentStrategy.java
```java
interface PaymentStrategy {
    void pay(double amount);
}
```

### CashPayment.java
```java
class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with cash");
    }
}
```

### CardPayment.java
```java
class CardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with card");
    }
}
```

---

## Design Patterns Implemented

### 1. Factory Pattern
- **Purpose:** Create objects without specifying their concrete classes
- **Implementation:** `CoffeeFactory` creates different types of drinks
- **Benefits:** Easy to add new drink types

### 2. Strategy Pattern
- **Purpose:** Define a family of algorithms and encapsulate each one
- **Implementation:** `PaymentStrategy` interface with different payment methods
- **Benefits:** Easy to change algorithms at runtime

### 3. Decorator Pattern
- **Purpose:** Add new functionality to objects
- **Implementation:** `DrinkDecorator` with different decorators
- **Benefits:** Flexibility without changing structure

---

## Conclusion

This coffee machine system demonstrates the practical application of three fundamental design patterns:

1. **Factory Pattern** for creating different types of drinks
2. **Strategy Pattern** for handling different payment methods
3. **Decorator Pattern** for customizing drinks with additional ingredients

The system is designed to be extensible, maintainable, and follows object-oriented principles. Each pattern serves a specific purpose and contributes to the overall flexibility and robustness of the system.

**Repository:** https://github.com/MykhailoMelnik/coffee-machine-design-patterns 