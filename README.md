# Pizza Ordering System  (CI6115 CW2)

This project is a comprehensive software solution designed to streamline the pizza ordering process for a pizza shop. It offers a seamless and intuitive experience for customers, allowing them to customize pizzas, track orders in real time, and enjoy exclusive promotions.  

## Key Features  
1. **Pizza Customization**  
   - Choose from various crusts, sauces, cheeses, and toppings.  
   - Create and name unique pizza combinations.  

2. **Intuitive Ordering Process**  
   - Step-by-step guidance for selecting ingredients and reviewing orders.  
   - Supports both pickup and delivery options with integrated delivery estimates.  

3. **User Profiles and Favorites**  
   - Save favorite pizza combinations for quick reordering.  
   - Personalized profiles enhance the user experience.  

4. **Real-Time Order Tracking**  
   - Track the status of your order from preparation to delivery.  
   - Get notifications for significant updates.  

5. **Payment and Loyalty Program**  
   - Mock payment processing with support for credit cards and digital wallets.  
   - Earn loyalty points for purchases and redeem them for discounts or free items.  

6. **Seasonal Specials and Promotions**  
   - Easily manage limited-time specials and promotional offers.  

7. **Feedback and Ratings**  
   - Provide feedback and ratings for orders.  
   - Highlight highly-rated combinations for inspiration.  

## Applied Design Patterns  
To ensure a robust and maintainable architecture, the following design patterns are implemented:  
- **Builder Pattern**: Simplifies the construction of complex pizza orders with customizations.  
- **Observer Pattern**: Enables real-time notifications for order status updates.  
- **Strategy Pattern**: Facilitates flexible integration of various payment methods and promotions.  
- **Chain of Responsibility Pattern**: Processes customization requests effectively with modular handlers.  
- **State Pattern**: Manages the lifecycle of an order (e.g., placed, prepared, out for delivery).  
- **Command Pattern**: Represents user actions like placing orders or giving feedback as reusable commands.  
- **Decorator Pattern**: Enhances orders with add-ons like extra toppings or special packaging.  

## Technology Stack  
- **Programming Language**: [Java]

## Get Started  
1. Clone this repository:  
   ```bash  
   git clone https://github.com/yourusername/pizza-ordering-system.git  
