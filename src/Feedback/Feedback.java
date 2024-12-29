package Feedback;

import PizzaBuilder.Pizza;

public class Feedback {
    private Pizza pizza;
    private int starRating;
    private String description;

    public Feedback(Pizza pizza, int starRating, String description) {
        this.pizza = pizza;
        this.starRating = starRating;
        this.description = description;
    }

    // Getters and Setters
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        if (starRating < 1 || starRating > 5) {
            throw new IllegalArgumentException("Star rating must be between 1 and 5.");
        }
        this.starRating = starRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Feedback for Pizza: " + pizza.getDescription() +
                "\nStar Rating: " + starRating +
                "\nDescription: " + description;
    }
}
