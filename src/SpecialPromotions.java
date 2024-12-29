import PizzaBuilder.Pizza;
import java.util.List;

public class SpecialPromotions {
    public boolean checkIfEntitlesForPromotion(List<Pizza> orderedPizzas) {
        return orderedPizzas.size() >= 2;
    }


    public void applyPromotion(List<Pizza> orderedPizzas) {
        if (checkIfEntitlesForPromotion(orderedPizzas)) {
            System.out.println("Promotion Applied: You get a free extra topping!");
        } else {
            System.out.println("Promotion not applicable. Order at least 2 pizzas to get a free extra topping.");
        }
    }

}
