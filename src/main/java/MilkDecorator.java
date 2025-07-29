class MilkDecorator extends DrinkDecorator {
    public MilkDecorator(Drink drink) {
        super(drink);
    }

    public String getDescription() {
        return drink.getDescription() + ", Milk";
    }

    public double cost() {
        return drink.cost() + 10;
    }
}
