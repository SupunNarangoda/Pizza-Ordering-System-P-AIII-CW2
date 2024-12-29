//package Command;
//import OrderObserver.Order;
//
//public class SubmitFeedbackCommand implements Command {
//    private Order order;
//    private String feedback;
//
//    public SubmitFeedbackCommand(Order order, String feedback) {
//        this.order = order;
//        this.feedback = feedback;
//    }
//
//    @Override
//    public void execute() {
//        System.out.println("Feedback submitted for order: " + order.getPizza().getDescription());
//        System.out.println("Feedback: " + feedback);
//        // Here you can add logic to save the feedback to a database or log.
//    }
//
//    @Override
//    public void undo() {
//        System.out.println("Feedback for order " + order.getPizza().getDescription() + " has been removed.");
//        // Here you can add logic to remove the feedback from the database or log.
//    }
//}

package Command;

import Feedback.*;
import OrderObserver.Order;

public class SubmitFeedbackCommand implements Command {
    private Order order;
    private String feedbackDescription;
    private int starRating;
    private FeedbackManager feedbackManager;

    public SubmitFeedbackCommand(Order order, String feedbackDescription, int starRating, FeedbackManager feedbackManager) {
        this.order = order;
        this.feedbackDescription = feedbackDescription;
        this.starRating = starRating;
        this.feedbackManager = feedbackManager;
    }

    @Override
    public void execute() {
        Feedback feedback = new Feedback(order.getPizza(), starRating, feedbackDescription);
        feedback.setStarRating(starRating);
        feedback.setDescription(feedbackDescription);
        feedbackManager.addFeedback(feedback);
        System.out.println("Feedback submitted for order: " + order.getPizza().getDescription());
    }

    @Override
    public void undo() {
        Feedback feedbackToRemove = null;

        // Find the feedback for the given order's pizza
        for (Feedback feedback : feedbackManager.getFeedbackList()) {
            if (feedback.getPizza().equals(order.getPizza()) && feedback.getDescription().equals(feedbackDescription)) {
                feedbackToRemove = feedback;
                break;
            }
        }

        if (feedbackToRemove != null) {
            feedbackManager.removeFeedback(feedbackToRemove);
            System.out.println("Feedback for order " + order.getPizza().getDescription() + " has been removed.");
        } else {
            System.out.println("No matching feedback found to undo.");
        }
    }
}

