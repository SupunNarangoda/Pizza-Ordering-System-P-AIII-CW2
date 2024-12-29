package PaymentStratergy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " using PayPal.");
        System.out.println("Payment successful!");
    }
}
