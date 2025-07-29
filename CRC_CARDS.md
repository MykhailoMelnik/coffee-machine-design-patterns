# Coffee Machine System - CRC Cards

## Class: CoffeeMachine
**Responsibilities:**
- Process drink orders
- Apply decorators to drinks
- Handle payment processing
- Display order information

**Collaborators:**
- CoffeeFactory
- DrinkDecorator
- PaymentStrategy

---

## Class: CoffeeFactory
**Responsibilities:**
- Create different types of drinks
- Validate drink types
- Return appropriate drink instances

**Collaborators:**
- Espresso
- Americano

---

## Class: Drink (Interface)
**Responsibilities:**
- Define drink interface
- Provide description method
- Provide cost calculation method

**Collaborators:**
- None (interface)

---

## Class: Espresso
**Responsibilities:**
- Implement espresso drink
- Provide espresso description
- Calculate espresso cost

**Collaborators:**
- Drink (implements)

---

## Class: Americano
**Responsibilities:**
- Implement americano drink
- Provide americano description
- Calculate americano cost

**Collaborators:**
- Drink (implements)

---

## Class: DrinkDecorator (Abstract)
**Responsibilities:**
- Define decorator pattern structure
- Hold reference to wrapped drink
- Delegate calls to wrapped drink

**Collaborators:**
- Drink

---

## Class: MilkDecorator
**Responsibilities:**
- Add milk to drinks
- Modify drink description
- Add milk cost to total

**Collaborators:**
- DrinkDecorator
- Drink

---

## Class: SugarDecorator
**Responsibilities:**
- Add sugar to drinks
- Modify drink description
- Add sugar cost to total

**Collaborators:**
- DrinkDecorator
- Drink

---

## Class: PaymentStrategy (Interface)
**Responsibilities:**
- Define payment interface
- Provide payment method

**Collaborators:**
- None (interface)

---

## Class: CashPayment
**Responsibilities:**
- Process cash payments
- Display cash payment message
- Handle cash payment logic

**Collaborators:**
- PaymentStrategy (implements)

---

## Class: CardPayment
**Responsibilities:**
- Process card payments
- Display card payment message
- Handle card payment logic

**Collaborators:**
- PaymentStrategy (implements)

---

## Class: Main
**Responsibilities:**
- Initialize coffee machine
- Demonstrate system usage
- Create example orders

**Collaborators:**
- CoffeeMachine
- CashPayment
- CardPayment 