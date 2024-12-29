import java.util.ArrayList;
import java.util.List;
import PizzaBuilder.*;

class UserProfile {
    private List<Pizza> favoritePizzas = new ArrayList<>();

    public void setFavoritePizzas(Pizza pizza) {
        favoritePizzas.add(pizza);
        System.out.println("Favorite saved: " + pizza.getDescription());
    }

    public void viewFavorites() {
        if (favoritePizzas.isEmpty()) {
            System.out.println("You have no favorite pizzas saved!");
            return;
        }

        System.out.println("Your Favorite Pizzas:");
        for (int i = 0; i < favoritePizzas.size(); i++) {
            System.out.println((i + 1) + ". " + favoritePizzas.get(i).getDescription());
        }
    }

    public Pizza getFavoritePizza(int index) {
            return favoritePizzas.get(index);
    }

    public int getFavoriteCount() {
        return favoritePizzas.size();
    }
}
