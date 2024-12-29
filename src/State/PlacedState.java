package State;
import OrderObserver.*;

public class PlacedState implements OrderState {
    @Override
    public void handleState(Order order) {
        order.setState(new PreparationState());
    }

    @Override
    public String getStatus() {
        return "Placed";
    }
}