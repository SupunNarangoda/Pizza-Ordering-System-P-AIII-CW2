package PaymentStratergy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " using Credit Card.");
        System.out.println("Payment successful!");
    }
}

