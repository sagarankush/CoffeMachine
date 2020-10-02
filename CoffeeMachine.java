package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int aWater = 400;
    static int aMilk = 540;
    static int aBeans = 120;
    static int aCups = 9;
    static int aMoney = 550;
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.initiate();
    }

    void initiate() {
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            String action = null;
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            // while (scanner.hasNextLine()){    
                action = scanner.next();
            // }
            switch (action) {
                case "buy" :
                    buy();
                    System.out.println();   
                    break;
                case "fill" :
                    fill();
                    System.out.println();
                    break;
                case "take" :
                    take();
                    System.out.println();
                    break;
                case "remaining" :
                    printAvail();
                    break;
                case "exit" :
                    bool = false;
                    break;
            }
        }
    }

    void fill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add: ");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int addCups = scanner.nextInt();

        aWater +=  addWater;
        aMilk += addMilk;
        aBeans += addBeans;
        aCups += addCups;
        // scanner.close();
    }

    void take() {
        System.out.println("I gave you " + aMoney);
        aMoney = 0;
    }

    void buy() {
        Scanner scanner = new Scanner(System.in);
        int type = 0;
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        if (!scanner.hasNextInt()) {
            type = 4;
        } else {
            type = scanner.nextInt();
        }
        switch (type) {
            case 1 :
                if (aWater < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (aBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (aCups < 1) {
                    System.out.println("Sorry, not enough cup!");
                    break;
                }
                System.out.println("I have enough resources, making you a coffee!");
                aWater -=  250;
                aBeans -= 16;
                aMoney +=  4;
                aCups -= 1;
                break;
            case 2 :
                if (aWater < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (aBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (aCups < 1) {
                    System.out.println("Sorry, not enough cup!");
                    break;
                }
                if (aMilk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }
                System.out.println("I have enough resources, making you a coffee!");
                aWater -=  350;
                aMilk -= 75;
                aBeans -= 20;
                aMoney +=  7;
                aCups -= 1;
                break;
            case 3 :
                if (aWater < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (aBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (aCups < 1) {
                    System.out.println("Sorry, not enough cup!");
                    break;
                }
                if (aMilk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }
                System.out.println("I have enough resources, making you a coffee!");
                aWater -=  200;
                aMilk -= 100;
                aBeans -= 12;
                aMoney +=  6;
                aCups -= 1;
                break;
            case 4 :
                break;
            
        }
        // scanner.close();
    }

    void printAvail() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(aWater + " of water");
        System.out.println(aMilk + " of milk");
        System.out.println(aBeans + " of coffee beans");
        System.out.println(aCups + " of disposable cups");
        System.out.println("$" + aMoney + " of money");
    }
}
