package coffee;

public class Latte extends Coffee {
    private static final int WATER = 350;
    private static final int MILK = 75;
    private static final int COFFEE_BEANS = 20;
    private static final int CUPS = 1;
    private static final int COST = 7;

    public Latte() {
        super(WATER, MILK, COFFEE_BEANS, CUPS, COST);
    }
}
