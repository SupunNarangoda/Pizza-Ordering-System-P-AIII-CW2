package CustomizationHandler;
import PizzaBuilder.*;

public class ExtraToppingHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Cheese") ||
                customization.equalsIgnoreCase("Pepperoni") ||
                customization.equalsIgnoreCase("Mushrooms")) {
            pizzaBuilder.addTopping(customization);
            System.out.println("Added topping: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}
