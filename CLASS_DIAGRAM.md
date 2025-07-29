# Coffee Machine System - Class Diagram

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

## Class Descriptions

### 1. Main
- **Purpose:** Entry point of the program
- **Methods:** `main(String[] args)` - demonstrates system functionality
- **Relationships:** Uses CoffeeMachine, CashPayment, CardPayment

### 2. CoffeeMachine
- **Purpose:** Main system class
- **Methods:** `processOrder(String, boolean, boolean, PaymentStrategy)` - processes orders
- **Relationships:** Uses CoffeeFactory, DrinkDecorator, PaymentStrategy

### 3. CoffeeFactory (Factory Pattern)
- **Purpose:** Creates different types of drinks
- **Methods:** `createDrink(String)` - creates drink by type
- **Relationships:** Creates Espresso, Americano

### 4. Drink (Interface)
- **Purpose:** Base interface for all drinks
- **Methods:** 
  - `getDescription()` - returns drink description
  - `cost()` - calculates cost
- **Relationships:** Implemented by Espresso, Americano

### 5. Espresso
- **Purpose:** Concrete espresso drink
- **Methods:** Implements Drink interface
- **Relationships:** Implements Drink

### 6. Americano
- **Purpose:** Concrete americano drink
- **Methods:** Implements Drink interface
- **Relationships:** Implements Drink

### 7. DrinkDecorator (Decorator Pattern)
- **Purpose:** Base decorator
- **Fields:** `drink: Drink` - wrapped drink
- **Methods:** Delegates calls to wrapped drink
- **Relationships:** Wraps Drink, extended by MilkDecorator, SugarDecorator

### 8. MilkDecorator
- **Purpose:** Adds milk to drinks
- **Methods:** Modifies description and cost
- **Relationships:** Extends DrinkDecorator

### 9. SugarDecorator
- **Purpose:** Adds sugar to drinks
- **Methods:** Modifies description and cost
- **Relationships:** Extends DrinkDecorator

### 10. PaymentStrategy (Strategy Pattern)
- **Purpose:** Interface for different payment methods
- **Methods:** `pay(double)` - processes payment
- **Relationships:** Implemented by CashPayment, CardPayment

### 11. CashPayment
- **Purpose:** Processes cash payments
- **Methods:** Implements PaymentStrategy
- **Relationships:** Implements PaymentStrategy

### 12. CardPayment
- **Purpose:** Processes card payments
- **Methods:** Implements PaymentStrategy
- **Relationships:** Implements PaymentStrategy 