class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " by cash.");
    }
}
