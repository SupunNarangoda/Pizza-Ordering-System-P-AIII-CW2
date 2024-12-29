package OrderObserver;
import  PizzaBuilder.*;

public interface OrderObserver {
    void update(String status, Pizza pizza);
}
