package State;
import OrderObserver.*;

public interface OrderState {
    void handleState(Order order);
    String getStatus();
}