package com.hillel.archive.hw07.beans;

public abstract class Accessory implements PriceInterface {
    private int price;
    private String name = "accessory";

    public Accessory(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "price=" + getPrice() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
