package CustomizationHandler;
import PizzaBuilder.*;


public class SizeHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Regular") ||
                customization.equalsIgnoreCase("Medium") ||
                customization.equalsIgnoreCase("Large")) {
            pizzaBuilder.setSize(customization);
            System.out.println("Sauce set to: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}
