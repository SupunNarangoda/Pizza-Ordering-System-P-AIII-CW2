package CustomizationHandler;
import PizzaBuilder.*;

public abstract class CustomizationHandler {
    protected CustomizationHandler nextHandler;

    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String customization, PizzaBuilder pizzaBuilder);
}
