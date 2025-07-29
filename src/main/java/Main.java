public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();

        machine.processOrder("espresso", true, false, new CardPayment());

        machine.processOrder("americano", false, true, new CashPayment());

        machine.processOrder("americano", true, true, new CashPayment());
    }
}

