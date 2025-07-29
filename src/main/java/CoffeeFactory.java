class CoffeeFactory {
    public static Drink createDrink(String type) {
        return switch (type.toLowerCase()) {
            case "espresso" -> new Espresso();
            case "americano" -> new Americano();
            default -> throw new IllegalArgumentException("Unknown drink: " + type);
        };
    }
}
