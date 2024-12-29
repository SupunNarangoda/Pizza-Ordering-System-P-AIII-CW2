package ToppingDecorator;

import PizzaBuilder.Pizza;

public abstract class Toppings implements Pizza {
    protected Pizza pizza;

    public Toppings(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

