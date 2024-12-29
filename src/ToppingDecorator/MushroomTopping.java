package ToppingDecorator;
import PizzaBuilder.Pizza;

public class MushroomTopping extends Toppings {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.0; // Cost of mushrooms
    }

    @Override
    public void setCustomName(String name) {
        pizza.setCustomName(name);
    }
    @Override
    public double getLoyaltyCost(int loyaltyPoints, double cost) {
        return pizza.getLoyaltyCost(loyaltyPoints, cost);
    }
}

