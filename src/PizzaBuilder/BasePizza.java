package PizzaBuilder;

import java.util.HashMap;
import java.util.Map;

public class BasePizza implements Pizza {
    private String crust;
    private String sauce;
    private String topping;
    private String cheese;
    private String customName;
    private String size;


    private static final Map<String, Double> crustPrices = new HashMap<>();
    private static final Map<String, Double> saucePrices = new HashMap<>();
    private static final Map<String, Double> toppingPrices = new HashMap<>();
    private static final Map<String, Double> cheesePrices = new HashMap<>();
//    private static final double BASE_PRICE = 5.0;
//    private static final double CHEESE_PRICE = 1.5;

    static {

        crustPrices.put("thin", 2.0);
        crustPrices.put("thick", 2.5);
        crustPrices.put("stuffed", 3.0);

        saucePrices.put("tomato", 1.0);
        saucePrices.put("alfredo", 1.2);
        saucePrices.put("barbecue", 1.5);

        toppingPrices.put("pepperoni", 1.5);
        toppingPrices.put("capsicum", 1.2);
        toppingPrices.put("olives", 1.3);

        cheesePrices.put("mozzarella",1.0);
        cheesePrices.put("parmesan",2.5);
    }

    public BasePizza() {
    }

    public String getDescription() {
        String description = (customName != null ? customName : "Basic Pizza") + " " +  size + " "+
                " with " + crust +
                ", " + sauce +
                ", " + cheese + "," + topping;

        return description;
    }

    @Override
    public double getCost() {
        double cost = 5.0;
        cost += crust != null && crustPrices.containsKey(crust.toLowerCase()) ? crustPrices.get(crust.toLowerCase()) : 0;
        cost += sauce != null && saucePrices.containsKey(sauce.toLowerCase()) ? saucePrices.get(sauce.toLowerCase()) : 0;
        cost += topping != null && toppingPrices.containsKey(topping.toLowerCase()) ? toppingPrices.get(topping.toLowerCase()):0;
        cost += cheese != null && cheesePrices.containsKey(cheese.toLowerCase()) ? cheesePrices.get(cheese.toLowerCase()):0;

        return cost;
    }

    @Override
    public void setCrust(String crust) {
        this.crust = crust;
    }

    @Override
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    @Override
    public void setCustomName(String name) {
        this.customName = name;
    }

    @Override
    public void setSize(String size) {
//        Pizza.super.setSize(size);
        this.size = size;
    }
    public double getLoyaltyCost(int loyaltyPoints,double cost) {
        double loyaltyPointsRound = Math.round((cost - loyaltyPoints) * 100.0) / 100.0;
    return Math.max(0, loyaltyPointsRound);
}
}

