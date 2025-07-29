class SugarDecorator extends DrinkDecorator {
    public SugarDecorator(Drink drink) {
        super(drink);
    }

    public String getDescription() {
        return drink.getDescription() + ", Sugar";
    }

    public double cost() {
        return drink.cost() + 5;
    }
}
