package machine;

import java.util.Scanner;

class Espresso {
    int requireWater = 250;
    int requiredCoffeeBeans = 16;
    int cost = 4;
}

class Latte {
    int requiredWater = 350;
    int requiredMilk = 75;
    int requiredCoffeeBeans = 20;
    int cost = 7;
}

class Cappuccino {
    int requiredWater = 200;
    int requiredMilk = 100;
    int requiredCoffeeBeans = 12;
    int cost = 6;
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int remainingwater = 400;
        int remainingMilk = 540;
        int remainingCoffeeBeans = 120;
        int remainingCups = 9;
        int earnedMoney = 550;
        Espresso espresso = new Espresso();
        Latte latte = new Latte();
        Cappuccino cappuccino = new Cappuccino();
        boolean flag = true;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            scanner.nextLine();
            System.out.println();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String input = scanner.next();
                    int choice = Character.isDigit(input.charAt(0)) ? Integer.parseInt(input) : 4;
                    boolean requirements = true;
                    switch (choice) {
                        case 1:
                            /*_______________________espresso____________________*/
                            if (remainingwater <= espresso.requireWater) {
                                System.out.println("Sorry, not enough water!");
                                requirements = false;
                            } else if (remainingCoffeeBeans <= espresso.requiredCoffeeBeans) {
                                System.out.println("Sorry, not enough coffee beans!");
                                requirements = false;
                            }
                            if (requirements) {
                                System.out.println("I have enough resources, making you a coffee!");
                                remainingwater -= espresso.requireWater;
                                remainingCoffeeBeans -= espresso.requiredCoffeeBeans;
                                remainingCups -= 1;
                                earnedMoney += espresso.cost;
                            }
                            break;
                        case 2:
                            /*_______________________Latte____________________*/
                            if (remainingwater <= latte.requiredWater) {
                                System.out.println("Sorry, not enough water!");
                                requirements = false;
                            } else if (remainingCoffeeBeans <= latte.requiredCoffeeBeans) {
                                System.out.println("Sorry, not enough coffee beans!");
                                requirements = false;
                            } else if (remainingMilk <= latte.requiredMilk) {
                                System.out.println("Sorry, not enough Milk!");
                                requirements = false;
                            }
                            if (requirements) {
                                System.out.println("I have enough resources, making you a coffee!");
                                remainingwater -= latte.requiredWater;
                                remainingCoffeeBeans -= latte.requiredCoffeeBeans;
                                remainingCups -= 1;
                                remainingMilk -= latte.requiredMilk;
                                earnedMoney += latte.cost;
                            }
                            break;
                        case 3:
                            /*_______________________cappuccino____________________*/
                            if (remainingwater <= cappuccino.requiredWater) {
                                System.out.println("Sorry, not enough water!");
                                requirements = false;
                            } else if (remainingCoffeeBeans <= cappuccino.requiredCoffeeBeans) {
                                System.out.println("Sorry, not enough coffee beans!");
                                requirements = false;
                            } else if (remainingMilk <= cappuccino.requiredMilk) {
                                System.out.println("Sorry, not enough Milk!");
                                requirements = false;
                            }
                            if (requirements) {
                                System.out.println("I have enough resources, making you a Latte!");
                                remainingwater -= cappuccino.requiredWater;
                                remainingCoffeeBeans -= cappuccino.requiredCoffeeBeans;
                                remainingMilk -= cappuccino.requiredMilk;
                                remainingCups -= 1;
                                earnedMoney += cappuccino.cost;
                            }
                            System.out.println();
                            break;
                        case 4:
                            continue;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add: ");
                    remainingwater += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    remainingMilk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    remainingCoffeeBeans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    remainingCups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + earnedMoney);
                    earnedMoney = 0;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(remainingwater + " ml of water");
                    System.out.println(remainingMilk + " ml of milk");
                    System.out.println(remainingCoffeeBeans + " g of coffee beans");
                    System.out.println(remainingCups + " disposable cups");
                    System.out.println("$" + earnedMoney + " " + " of money\n");
                    break;
                case "exit":
                    flag = false;
            }
        } while (flag);
    }// END of Main
}//END of Class