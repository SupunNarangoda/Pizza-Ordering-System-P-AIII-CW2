import OrderObserver.*;
import PizzaBuilder.*;


public class AppNotification implements OrderObserver {
    @Override
    public void update(String status, Pizza pizza) {
        System.out.println("Notification: Your pizza (" + pizza.getDescription() + ") is now " + status);
    }
}