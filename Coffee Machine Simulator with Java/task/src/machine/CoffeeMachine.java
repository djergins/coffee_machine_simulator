package machine;

import coffee.Cappuccino;
import coffee.Coffee;
import coffee.Espresso;
import coffee.Latte;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private int cupsSinceLastCleaning;

    public CoffeeMachine() {
        this.water = 400; //ml
        this.milk = 540; //ml
        this.money = 550; //$
        this.coffeeBeans = 120; //g
        this.disposableCups = 9; //number of cups
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner s = new Scanner(System.in);
        String input = "";
        while(!input.equals("exit")) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            input = s.nextLine();
            switch(input) {
                case "buy" -> machine.buyCoffee();
                case "fill" -> machine.fillIngredients();
                case "take" -> machine.takeMoney();
                case "remaining" -> machine.displayMachineState();
                case "clean" -> machine.cleanMachine();
                case "exit" -> {}
                default -> System.out.println("Unrecognized option selected.");
            }
        }

        s.close();
    }

    public void displayMachineState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.water);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.coffeeBeans);
        System.out.printf("%d disposable cups\n", this.disposableCups);
        System.out.printf("$%d of money\n", this.money);
    }

    public void buyCoffee() {
        if(this.cupsSinceLastCleaning >= 10) {
            System.out.println("I need cleaning!");
        } else {
            Scanner s = new Scanner(System.in);
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String selection = s.nextLine();
            switch(selection) {
                case "1" -> {
                    Espresso espresso = new Espresso();
                    this.makeCoffee(espresso);
                    this.cupsSinceLastCleaning += 1;
                }
                case "2" -> {
                    Latte latte = new Latte();
                    this.makeCoffee(latte);
                    this.cupsSinceLastCleaning += 1;
                }
                case "3" -> {
                    Cappuccino cappuccino = new Cappuccino();
                    this.makeCoffee(cappuccino);
                    this.cupsSinceLastCleaning += 1;
                }
                case "back" -> {}
                default -> System.out.println("Invalid option selected. Please select 1, 2, 3, or back.");
            }
            s.close();
        }
    }

    public void fillIngredients() {
        Scanner s = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.water += s.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        this.milk += s.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += s.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        this.disposableCups += s.nextInt();
    }

    public void takeMoney() {
        System.out.printf("I gave you %s\n", this.money);
        this.money = 0;
    }

    public void cleanMachine() {
        this.cupsSinceLastCleaning = 0;
        System.out.println("I have been cleaned!");
    }

    public void makeCoffee(Coffee coffee) {
        if(this.water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if(this.milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if(this.coffeeBeans < coffee.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if(this.disposableCups < coffee.getCup()) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= coffee.getWater();
            this.milk -= coffee.getMilk();
            this.coffeeBeans -= coffee.getCoffeeBeans();
            this.disposableCups -= coffee.getCup();
            this.money += coffee.getCost();
        }
    }
}