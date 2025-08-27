package coffee;

import machine.CoffeeMachine;

public class Espresso extends Coffee {
    private static final int WATER = 250;
    private static final int MILK = 0;
    private static final int COFFEE_BEANS = 16;
    private static final int CUPS = 1;
    private static final int COST = 4;

    public Espresso() {
        super(WATER, MILK, COFFEE_BEANS, CUPS, COST);
    }
}
