package coffee;

public abstract class Coffee {
    protected int water;
    protected int milk;
    protected int coffeeBeans;
    protected int cup;
    protected int cost;

    public Coffee(int water, int milk, int coffeeBeans, int cup, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cup = cup;
        this.cost = cost;
    }


    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCup() {
        return cup;
    }

    public int getCost() {
        return cost;
    }
}
