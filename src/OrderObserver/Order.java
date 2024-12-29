package OrderObserver;

import PizzaBuilder.Pizza;
import State.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private OrderState state;
    private Pizza pizza;

    public Order(Pizza pizza) {
        this.pizza = pizza;
        this.state = new PlacedState();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(state.getStatus(), pizza);
        }
    }

    public void setState(OrderState state) {
        this.state = state;
        notifyObservers();
    }

    public void nextState() {
        state.handleState(this);
    }

    public String getStatus() {
        return state.getStatus();
    }

    public Pizza getPizza() {
        return pizza;
    }
}


