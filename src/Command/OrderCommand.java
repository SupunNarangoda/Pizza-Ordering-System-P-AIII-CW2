package Command;

import OrderObserver.Order;
import PaymentStratergy.LoyaltyProgram;
import PaymentStratergy.PaymentContext;
import PaymentStratergy.CreditCardPayment;
import PaymentStratergy.PayPalPayment;
import State.CancelledState;

import java.util.Scanner;

public class OrderCommand implements Command {
    private Order order;
    private double amountPaid;
    private LoyaltyProgram loyaltyProgram;
    private double finalCost;


    public OrderCommand(Order order,LoyaltyProgram loyaltyProgram) {
        this.order = order;
        this.loyaltyProgram = loyaltyProgram;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Check if the user wants to use loyalty points
        if(loyaltyProgram.getPoints() > 0) {
            System.out.println("You have " + loyaltyProgram.getPoints() + " loyalty points.");
            System.out.print("Would you like to use your loyalty points to reduce the cost? (yes/no): ");
            int loyaltyPointsUsed = 0;
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                loyaltyPointsUsed = Math.min(loyaltyProgram.getPoints(), (int) order.getPizza().getCost());
                loyaltyProgram.addPoints(-loyaltyPointsUsed); // Deduct points
            }
            // Calculates the final cost after applying loyalty points
             finalCost = order.getPizza().getLoyaltyCost(loyaltyPointsUsed,order.getPizza().getCost());
            System.out.println("Final Cost after applying loyalty points: $" + finalCost);
        }else{
            finalCost = order.getPizza().getCost();

        }


        System.out.println("Select Payment Method: 1. Credit Card 2. Digital Wallet");
        int paymentChoice = Integer.parseInt(scanner.nextLine());

        PaymentContext paymentContext = new PaymentContext();
        if (paymentChoice == 1) {
            paymentContext.setPaymentStrategy(new CreditCardPayment());
        } else if (paymentChoice == 2) {
            paymentContext.setPaymentStrategy(new PayPalPayment());
        }


        paymentContext.pay(order.getPizza().getCost());
//        paymentContext.pay(finalCost);


        System.out.println("Order placed successfully for: " + order.getPizza().getDescription());
//        order.setStatus("Placed");

        loyaltyProgram.addPoints((int) order.getPizza().getCost());
        System.out.println("Loyalty points added. Total points: " + loyaltyProgram.getPoints());

    }

    @Override
    public void undo() {
        System.out.println("Cancelling order for: " + order.getPizza().getDescription());
        System.out.println("Refunding amount: $" + finalCost);
        order.setState(new CancelledState());
    }
}
