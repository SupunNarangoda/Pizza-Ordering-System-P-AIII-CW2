package CustomizationHandler;
import PizzaBuilder.*;


public class SauceHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Tomato") ||
                customization.equalsIgnoreCase("Alfredo") ||
                customization.equalsIgnoreCase("Barbecue")) {
            pizzaBuilder.setSauce(customization);
            System.out.println("Sauce set to: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}
