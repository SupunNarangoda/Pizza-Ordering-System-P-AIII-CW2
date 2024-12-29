package State;
import OrderObserver.*;


public class DeliveredState implements OrderState {
    @Override
    public void handleState(Order order) {
        System.out.println("Order has already been delivered.");
    }

    @Override
    public String getStatus() {
        return "Delivered";
    }
}
