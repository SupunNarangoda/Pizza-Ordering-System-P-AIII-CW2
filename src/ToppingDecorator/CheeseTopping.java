package ToppingDecorator;
import PizzaBuilder.Pizza;

public class CheeseTopping extends Toppings {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5; // Cost of cheese
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

