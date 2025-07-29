# Coffee Machine System - Use Cases

## Use Case 1: Order Espresso with Milk and Card Payment

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

## Use Case 2: Order Americano with Sugar and Cash Payment

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

## Use Case 3: Order Americano with Both Milk and Sugar

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

