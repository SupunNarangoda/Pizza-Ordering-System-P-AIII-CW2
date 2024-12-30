package Feedback;

import PizzaBuilder.Pizza;
import java.util.ArrayList;
import java.util.*;

public class FeedbackManager {
    private List<Feedback> feedbackList;

    public FeedbackManager() {
        this.feedbackList = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        System.out.println("Feedback added: " + feedback);
    }

    public void removeFeedback(Feedback feedback) {
        feedbackList.remove(feedback);
        System.out.println("Feedback removed: " + feedback);
    }


    public List<Feedback> getFeedbackForPizza(Pizza pizza) {
        List<Feedback> result = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (feedback.getPizza().equals(pizza)) {
                result.add(feedback);
            }
        }
        return result;
    }
    public double getAverageRating(Pizza pizza) {
        List<Feedback> feedbacks = getFeedbackForPizza(pizza);
        if (feedbacks.isEmpty()) return 0.0;
        return feedbacks.stream().mapToInt(Feedback::getStarRating).average().orElse(0.0);
    }
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }


    public void displayAllFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            for (Feedback feedback : feedbackList) {
                System.out.println(feedback);
            }
        }
    }
    public List<Map.Entry<Pizza, Double>>getTopRatedPizzas() {
        Map<Pizza, Double> pizzaRatings = new HashMap<>();

        for (Feedback feedback : feedbackList) {
            Pizza pizza = feedback.getPizza();
            pizzaRatings.put(pizza, getAverageRating(pizza));
        }


        List<Map.Entry<Pizza, Double>> sortedList = new ArrayList<>(pizzaRatings.entrySet());

        // bubble sort which lists top pizza from highest to lowest rating
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getValue() < sortedList.get(j).getValue()) {
                    Map.Entry<Pizza, Double> temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }

        return sortedList;
    }
}
