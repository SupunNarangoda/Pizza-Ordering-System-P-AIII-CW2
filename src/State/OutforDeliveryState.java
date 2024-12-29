package State;
import OrderObserver.*;


public class OutforDeliveryState implements OrderState {
    @Override
    public void handleState(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public String getStatus() {
        return "Out for Delivery";
    }
}