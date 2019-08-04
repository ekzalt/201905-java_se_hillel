package com.hillel.hw07;

import com.hillel.hw07.beans.Lily;
import com.hillel.hw07.beans.Rose;
import com.hillel.hw07.beans.Tape;
import com.hillel.hw07.beans.Wrapper;
import com.hillel.hw07.exceptions.BouquetException;
import com.hillel.hw07.services.Bouquet;

import java.util.Scanner;

public class Application {
    public final int EXIT = 0;
    public final int CREATE = 1;
    public final int READ = 2;
    public final int ROSE = 3;
    public final int LILY = 4;
    public final int TAPE = 5;
    public final int WRAP = 6;
    public final int COST = 7;
    public final int FRESH = 8;
    public final int TALL = 9;

    private Scanner scanner = null;
    private Bouquet bouquet = null;

    public void run() {
        printMenu();
        scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int option = scanner.nextInt();

            if (option == EXIT) {
                System.out.println("Thanks for using our service");
                break;
            }

            try {
                switch (option) {
                    case CREATE:
                        bouquet = new Bouquet();
                        System.out.println("The bouquet has been created. It is empty");
                        printMenu();
                        break;
                    case READ:
                        bouquet.printBouquet();
                        printMenu();
                        break;
                    case ROSE:
                        bouquet.addFlower(new Rose(getRandomInt(), getRandomInt(), getRandomInt()));
                        printMenu();
                        break;
                    case LILY:
                        bouquet.addFlower(new Lily(getRandomInt(), getRandomInt(), getRandomInt()));
                        printMenu();
                        break;
                    case TAPE:
                        bouquet.addAccessory(new Tape(getRandomInt()));
                        printMenu();
                        break;
                    case WRAP:
                        bouquet.addAccessory(new Wrapper(getRandomInt()));
                        printMenu();
                        break;
                    case COST:
                        System.out.println("the bouquet costs: $" + bouquet.calculateCost());
                        printMenu();
                        break;
                    case FRESH:
                        printArray(bouquet.sortByFresh());
                        printMenu();
                        break;
                    case TALL:
                        throw new BouquetException("Not implemented yet");
                    default:
                        throw new BouquetException("Unsupported operation");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (scanner != null) {
            scanner.close();
        }
    }

    public void printMenu() {
        System.out.println("\nMake your custom Bouquet");
        System.out.println(EXIT + " - exit");
        System.out.println(CREATE + " - create a bouquet");
        System.out.println(READ + " - show a bouquet");
        System.out.println(ROSE + " - add rose");
        System.out.println(LILY + " - add lily");
        System.out.println(TAPE + " - add tape");
        System.out.println(WRAP + " - add wrapper");
        System.out.println(COST + " - calculate cost");
        System.out.println(FRESH + " - sort by freshness");
        System.out.println(TALL + " - find by tall range\n");
    }

    private int getRandomInt() {
        return (int) Math.round(Math.random() * 100);
    }

    public void printArray(Object[] objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
