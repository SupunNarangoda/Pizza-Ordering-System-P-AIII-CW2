package PizzaBuilder;
import ToppingDecorator.CheeseTopping;
import ToppingDecorator.MushroomTopping;
import ToppingDecorator.PepperoniTopping;

public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new BasePizza();
    }

    public PizzaBuilder setCrust(String crust) {
        this.pizza.setCrust(crust);
        System.out.println("Selected Crust: " + crust);
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.pizza.setSauce(sauce);
        System.out.println("Selected Sauce: " + sauce);
        return this;
    }

    public PizzaBuilder addTopping(String topping) {
        switch (topping.toLowerCase()) {
            case "cheese":
                this.pizza = new CheeseTopping(this.pizza);
                break;
            case "pepperoni":
                this.pizza = new PepperoniTopping(this.pizza);
                break;
            case "mushrooms":
                this.pizza = new MushroomTopping(this.pizza);
                break;
        }
        return this;
    }

    public PizzaBuilder setTopping(String topping) {
        this.pizza.setTopping(topping);
        System.out.println("Selected Topping: " + topping);
        return this;
    }

    public PizzaBuilder setCheese(String cheese) {
        this.pizza.setCheese(cheese);
        System.out.println("Selected Cheese: " + cheese);
        return this;
    }
    public PizzaBuilder setSize(String size) {
        this.pizza.setSize(size);
        System.out.println("Selected Size: " + size);
        return this;
    }

    public PizzaBuilder setCustomName(String name) {
        this.pizza.setCustomName(name);
        System.out.println("Pizza Named as: " + name);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}

