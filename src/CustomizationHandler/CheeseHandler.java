package CustomizationHandler;

import PizzaBuilder.PizzaBuilder;

public class CheeseHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Mozzarella") ||
                customization.equalsIgnoreCase("Parmesan")){
            pizzaBuilder.setCheese(customization);
            System.out.println("Cheese set to: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}
