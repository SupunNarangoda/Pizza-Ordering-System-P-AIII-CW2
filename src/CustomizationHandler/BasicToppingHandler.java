package CustomizationHandler;

import PizzaBuilder.PizzaBuilder;
import PizzaBuilder.*;


public class BasicToppingHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Olives") ||
                customization.equalsIgnoreCase("Capsicum") ||
                customization.equalsIgnoreCase("Pepperoni")) {
            pizzaBuilder.setTopping(customization);
            System.out.println("Topping set to: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}
