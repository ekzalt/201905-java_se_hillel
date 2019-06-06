package com.hillel.hw07.services;

import com.hillel.hw07.beans.Accessory;
import com.hillel.hw07.beans.Flower;
import com.hillel.hw07.beans.PriceInterface;
import com.hillel.hw07.exceptions.BouquetException;

public class Bouquet implements BouquetInterface {
    Flower[] flowers = new Flower[0];
    Accessory[] accessories = new Accessory[0];

    @Override
    public void addFlower(Flower flower) {
        flowers = resizeAndPushFlower(flowers, flower);
    }

    @Override
    public void addAccessory(Accessory accessory) {
        accessories = resizeAndPushAccessory(accessories, accessory);
    }

    @Override
    public int calculateCost() {
        int cost = 0;

        for (PriceInterface item : flowers) {
            cost += item.getPrice();
        }
        for (PriceInterface item : accessories) {
            cost += item.getPrice();
        }

        return cost;
    }

    @Override
    public Flower[] sortByFresh() {
        bubbleSortByFresh(flowers);
        return flowers;
    }

    @Override
    public Flower[] findByTallRange(int min, int max) throws BouquetException {
        if (min < 0 || max < 0) {
            throw new BouquetException("Unsupported negative number");
        }

        Flower[] filtered = new Flower[0];

        for (Flower flower : flowers) {
            if (flower.getTall() >= min && flower.getTall() <= max) {
                filtered = resizeAndPushFlower(filtered, flower);
            }
        }

        return filtered;
    }

    public void printBouquet() {
        for (PriceInterface item : flowers) {
            System.out.println(item);
        }
        for (PriceInterface item : accessories) {
            System.out.println(item);
        }
    }

    private Flower[] resizeAndPushFlower(Flower[] list, Flower item) {
        Flower[] copy = new Flower[list.length + 1];

        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }

        copy[copy.length - 1] = item;
        return copy;
    }

    private Accessory[] resizeAndPushAccessory(Accessory[] list, Accessory item) {
        Accessory[] copy = new Accessory[list.length + 1];

        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }

        copy[copy.length - 1] = item;
        return copy;
    }

    private void bubbleSortByFresh(Flower[] flowers) {
        for (int i = flowers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (flowers[j].getFresh() > flowers[j + 1].getFresh()){
                    Flower tmp = flowers[j];
                    flowers[j] = flowers[j + 1];
                    flowers[j + 1] = tmp;
                }
            }
        }
    }
}
