package State;
import OrderObserver.*;


public class PreparationState implements OrderState {
    @Override
    public void handleState(Order order) {
        order.setState(new OutforDeliveryState());
    }

    @Override
    public String getStatus() {
        return "In Preparation";
    }
}