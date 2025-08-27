package coffee;

public class Cappuccino extends Coffee {
    private static final int WATER = 200;
    private static final int MILK = 100;
    private static final int COFFEE_BEANS = 12;
    private static final int CUPS = 1;
    private static final int COST = 6;

    public Cappuccino() {
        super(WATER, MILK, COFFEE_BEANS, CUPS, COST);
    }
}
