package ToppingDecorator;
import PizzaBuilder.Pizza;

public class PepperoniTopping extends Toppings {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.0; // Cost of pepperoni
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
