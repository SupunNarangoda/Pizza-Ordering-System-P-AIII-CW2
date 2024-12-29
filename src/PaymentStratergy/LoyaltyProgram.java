package PaymentStratergy;

public class LoyaltyProgram {
    private int points = 0;

    public void addPoints(int amount) {
        points += (int) (amount*0.4);
    }

    public int getPoints() {
        return points;
    }
}
