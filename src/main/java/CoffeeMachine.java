import java.util.*;

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
