package State;

import OrderObserver.Order;

public class CancelledState implements OrderState{
    @Override
    public void handleState(Order order) {
        System.out.println("The order has been cancelled.");
    }

    @Override
    public String getStatus() {
        return "Cancelled";
    }
}
