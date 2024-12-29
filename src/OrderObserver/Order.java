package OrderObserver;

import PizzaBuilder.Pizza;
import State.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private OrderState state; // Current state
    private Pizza pizza;

    public Order(Pizza pizza) {
        this.pizza = pizza;
        this.state = new PlacedState(); // Initial state
    }

    // Add an observer to the list
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    // Remove an observer from the list
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers about the status update
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(state.getStatus(), pizza);
        }
    }

    // Set a new state
    public void setState(OrderState state) {
        this.state = state;
        notifyObservers(); // Notify observers on state change
    }

    // Transition to the next state
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


