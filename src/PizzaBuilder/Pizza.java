package PizzaBuilder;


public interface Pizza {
    String getDescription();
    double getCost();

    default void setSauce(String sauce) {
        throw new UnsupportedOperationException("not supported.");
    }

    default void setCrust(String crust) {
        throw new UnsupportedOperationException("not supported.");
    }

    default void setTopping(String topping) {
        throw new UnsupportedOperationException("not supported.");
    }

    default void setCheese(String cheese) {
        throw new UnsupportedOperationException("not supported.");
    }

    default void setCustomName(String name) {
        throw new UnsupportedOperationException("not supported.");
    }
    default void setSize(String size) {
        throw new UnsupportedOperationException("not supported.");
    }
    default double getLoyaltyCost(int loyaltyPoints, double cost){
        throw new UnsupportedOperationException("not supported.");
    }
}

