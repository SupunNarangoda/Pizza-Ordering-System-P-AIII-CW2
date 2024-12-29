import PizzaBuilder.*;
import PaymentStratergy.*;
import OrderObserver.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Command.*;
import  CustomizationHandler.*;
import Feedback.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserProfile userProfile = new UserProfile();
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        CommandInvoker commandInvoker = new CommandInvoker();
        FeedbackManager feedbackManager = new FeedbackManager();


        System.out.println("Welcome to Pizza Shop!");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Customize and Order Pizza");
            System.out.println("2. View Favorites");
            System.out.println("3. Reorder Favorite");
            System.out.println("4. View Loyalty Points");
            System.out.println("5. Order Top Rated Pizza Combinations");
            System.out.println("6. Check for promotions");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:
                    orderCustomPizza(scanner, userProfile, commandInvoker, loyaltyProgram, feedbackManager);
                    break;

                case 2:
                    userProfile.viewFavorites();
                    break;

                case 3:
                    orderFavouritePizza(userProfile, commandInvoker, scanner, loyaltyProgram);
                    break;

                case 4:
                    System.out.println("Loyalty Points: " + loyaltyProgram.getPoints());
                    break;

                case 5:
                    orderTopPizza(scanner, feedbackManager, commandInvoker, loyaltyProgram);
                    break;

                case 6:
                    orderPromotionPizza(scanner, commandInvoker, loyaltyProgram);
                    break;
                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();

    }
    private static Pizza buildPizza(Scanner scanner){
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        //Chain of Responsibility
        CustomizationHandler crustHandler = new CrustHandler();
        CustomizationHandler sauceHandler = new SauceHandler();
        CustomizationHandler extraToppingHandler = new ExtraToppingHandler();
        CustomizationHandler basicToppingHandler = new BasicToppingHandler();
        CustomizationHandler cheeseHandler = new CheeseHandler();
        CustomizationHandler sizeHandler = new SizeHandler();


        crustHandler.setNextHandler(sauceHandler);
        sauceHandler.setNextHandler(basicToppingHandler);
        basicToppingHandler.setNextHandler(cheeseHandler);
        cheeseHandler.setNextHandler(extraToppingHandler);
        extraToppingHandler.setNextHandler(sizeHandler);

        //crust handler
        System.out.println("Select crust (Thin, Thick, Stuffed): ");
        String crust = scanner.nextLine();
        crustHandler.handleRequest(crust, pizzaBuilder);

        //sauce handler
        System.out.println("Select sauce (Tomato, Alfredo, Barbecue): ");
        String sauce = scanner.nextLine();
        crustHandler.handleRequest(sauce, pizzaBuilder);

        //Basic Topings handler
        System.out.println("Select Topping (Olives, Capsicum, Pepperoni): ");
        String toppings = scanner.nextLine();
        basicToppingHandler.handleRequest(toppings, pizzaBuilder);

        //cheese handler
        System.out.println("Select cheese (Mozzarella, Parmesan): ");
        String cheese = scanner.nextLine();
        cheeseHandler.handleRequest(cheese, pizzaBuilder);

        //size handler
        System.out.println("Select size (Regular, Medium,Large): ");
        String size = scanner.nextLine();
        sizeHandler.handleRequest(size, pizzaBuilder);

        //extra topping handler
        System.out.println("Would you like some extra toppings (yes/no): ");
        String extraTopping = scanner.nextLine();
        if(extraTopping.equalsIgnoreCase("yes")) {
            boolean addingToppings = true;
            while (addingToppings) {
                System.out.println("Select a topping (Cheese, Pepperoni, Mushrooms) or type 'done': ");
                String topping = scanner.nextLine();
                if (topping.equalsIgnoreCase("done")) {
                    addingToppings = false;
                } else {
                    extraToppingHandler.handleRequest(topping, pizzaBuilder);
                }
            }
        }

        System.out.println("Name you customization: ");
        String name = scanner.nextLine();
        pizzaBuilder.setCustomName(name);


        Pizza customPizza = pizzaBuilder.build();
        System.out.println("Order Summary:");
        System.out.println(customPizza.getDescription());
        System.out.println("Total Cost: $" + customPizza.getCost());
        return customPizza;

    }
    private static void orderCustomPizza(Scanner scanner, UserProfile userProfile, CommandInvoker commandInvoker, LoyaltyProgram loyaltyProgram, FeedbackManager feedbackManager){
        Pizza customPizza = buildPizza(scanner);



        System.out.print("Save this pizza as favorite? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            userProfile.setFavoritePizzas(customPizza);
        }


        Order order = new Order(customPizza);
        order.addObserver(new AppNotification());
        commandInvoker.executeCommand(new OrderCommand(order,loyaltyProgram));

        System.out.print("Would you like to process with the order? (yes/no): ");
        String cancel =  scanner.nextLine();
        if (cancel.equalsIgnoreCase("no")) {
            commandInvoker.undoLastCommand();
        } else if (cancel.equalsIgnoreCase("yes")) {
            simulateTracking(order);
        }

        getFeedback(scanner,commandInvoker, order, feedbackManager);
    }
    private static void orderFavouritePizza(UserProfile userProfile, CommandInvoker commandInvoker, Scanner scanner, LoyaltyProgram loyaltyProgram){
        userProfile.viewFavorites();
        System.out.print("Select favorite pizza number to reorder: ");
        int favoriteIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Pizza favoritePizza = userProfile.getFavoritePizza(favoriteIndex);

        if (favoritePizza != null) {
            System.out.println("Reordering favorite pizza: " + favoritePizza.getDescription());
            System.out.println("Total Cost: $" + favoritePizza.getCost());


            Order orderFav = new Order(favoritePizza);
            orderFav.addObserver(new AppNotification());

            commandInvoker.executeCommand(new OrderCommand(orderFav,loyaltyProgram));

            System.out.print("Would you like to proceed with the order? (yes/no): ");
            String cancel2 = scanner.nextLine();
            if (cancel2.equalsIgnoreCase("no")) {
                commandInvoker.undoLastCommand();
            }else if(cancel2.equalsIgnoreCase("yes")){
                simulateTracking(orderFav);
            }


        } else {
            System.out.println("Invalid selection.");
        }
    }
    private static void orderPromotionPizza(Scanner scanner,CommandInvoker commandInvoker, LoyaltyProgram loyaltyProgram){
        System.out.println("\n**** Promotion: Buy 2 pizzas, get 1 extra topping for free! ****");

        List<Pizza> cart = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("\nCustomize pizza " + (i + 1) + ":");
            Pizza pizza = buildPizza(scanner);
            cart.add(pizza);
        }

        System.out.println("\nAdding a free topping to each pizza as part of the promotion.");
        for (Pizza pizza : cart) {
            System.out.println("Select your free topping (Cheese, Mushrooms, Pepperoni): ");
            String freeTopping = scanner.nextLine();
//            pizza.addTopping(freeTopping);
        }

        System.out.println("\nYour cart:");
        double totalCost = 0;
        for (Pizza pizza : cart) {
            System.out.println(pizza.getDescription() + " - Cost: $" + pizza.getCost());
            totalCost += pizza.getCost();
        }
        System.out.println("Total Cost: $" + totalCost);

        System.out.print("Would you like to place the order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            for (Pizza pizza : cart) {
                Order order = new Order(pizza);
                order.addObserver(new AppNotification());
                commandInvoker.executeCommand(new OrderCommand(order, loyaltyProgram));
                simulateTracking(order);
            }
        } else {
            System.out.println("Order has been canceled.");
        }
    }

    private static void orderTopPizza(Scanner scanner, FeedbackManager feedbackManager, CommandInvoker commandInvoker, LoyaltyProgram loyaltyProgram){
        List<Pizza> topRatedPizzas = feedbackManager.getTopRatedPizzas();

        if (topRatedPizzas.isEmpty()) {
            System.out.println("No top rated pizzas available at the moment.");
            return;
        }

        System.out.println("\nTop Rated Pizzas:");
        for (int i = 0; i < topRatedPizzas.size(); i++) {
            System.out.println((i + 1) + ". " + topRatedPizzas.get(i).getDescription());
        }

        System.out.print("Choose a pizza to order (Select Number): ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice < 1 || choice > topRatedPizzas.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Pizza selectedPizza = topRatedPizzas.get(choice - 1);
        Order order = new Order(selectedPizza);
        order.addObserver(new AppNotification());
        commandInvoker.executeCommand(new OrderCommand(order, loyaltyProgram));

        simulateTracking(order);
        getFeedback(scanner,commandInvoker, order, feedbackManager);
    }

    private static void simulateTracking(Order order) {
        order.nextState();
        delay(2000);

        order.nextState();
        delay(2000);

        order.nextState();
        delay(2000);

        order.nextState();
    }
    private static void getFeedback(Scanner scanner, CommandInvoker commandInvoker,Order order,FeedbackManager feedbackManager){
        System.out.print("Would you like to provide feedback on your pizza? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Please provide your feedback: ");
            String feedback = scanner.nextLine();
            System.out.print("Please provide a overall star (1 to 5) for your pizza: ");
            int star = scanner.nextInt();


            SubmitFeedbackCommand feedbackCommand = new SubmitFeedbackCommand(order, feedback,star,feedbackManager);


            commandInvoker.executeCommand(feedbackCommand);
        }
        System.out.print("Would you proceed with the given feedback (yes/no): ");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        String decision = scanner.nextLine();
        if (decision.equalsIgnoreCase("no")) {
            commandInvoker.undoLastCommand();
        }
    }

    private static void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
