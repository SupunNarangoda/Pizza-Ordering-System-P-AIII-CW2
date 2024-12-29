package CustomizationHandler;

import PizzaBuilder.PizzaBuilder;
import PizzaBuilder.*;


public class BasicToppingHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String customization, PizzaBuilder pizzaBuilder) {
        if (customization.equalsIgnoreCase("Olives") ||
                customization.equalsIgnoreCase("Capsicum") ||
                customization.equalsIgnoreCase("Pepperoni")) {
            pizzaBuilder.setTopping(customization);
            System.out.println("Topping set to: " + customization);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(customization, pizzaBuilder);
        }
    }
}
//src/
//        ├── ChainOfResponsibility/
//        │   ├── CustomizationHandler/
//        │   │   ├── BasicToppingHandler
//│   │   ├── CheeseHandler
//│   │   ├── CrustHandler
//│   │   ├── SauceHandler
//│   │   ├── SizeHandler
//│   │   └── ToppingHandler
//├── Command/
//        │   ├── Command/
//        │   │   ├── Command
//│   │   ├── CommandInvoker
//│   │   ├── OrderCommand
//│   │   └── SubmitFeedbackCommand
//├── Observer/
//        │   ├── OrderObserver/
//        │   │   ├── Order
//│   │   └── OrderObserver
//├── Strategy/
//        │   ├── PaymentStrategy/
//        │   │   ├── LoyaltyProgram
//│   │   ├── PaymentContext
//│   │   └── PaymentStrategy
//│   └── PaymentTypes/
//        │       ├── CreditCardPayment
//│       └── DigitalWalletPayment
//├── Decorator/
//        │   ├── ToppingDecorator/
//        │   │   └── Toppings
//│   └── Toppings/
//        │       ├── CheeseTopping
//│       ├── MushroomTopping
//│       └── PepperoniTopping
//├── State/
//        │   ├── CancelledState
//│   ├── DeliveredState
//│   ├── OrderState
//│   ├── OutforDeliveryState
//│   ├── PlacedState
//│   └── PreparationState
//├── Builder/
//        │   ├── PizzaBuilder/
//        │   │   ├── Pizza
//│   │   └── PizzaBuilder
//│   └── Pizza/
//        │       └── BasePizza
//├── Feedback/
//        │   ├── Feedback
//│   └── FeedbackManager
//├── AppCore/
//        │   ├── AppNotification
//│   ├── Main
//│   ├── SpecialPromotions
//│   └── UserProfile
//
//
