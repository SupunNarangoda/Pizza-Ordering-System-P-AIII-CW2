package CustomizationHandler;
import PizzaBuilder.*;


public class CrustHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Thin") ||
                customization.equalsIgnoreCase("Thick") ||
                customization.equalsIgnoreCase("Stuffed")) {
            pizzaBuilder.setCrust(customization);
            System.out.println("Crust set to: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}