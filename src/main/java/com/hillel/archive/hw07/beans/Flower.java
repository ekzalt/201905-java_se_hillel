package com.hillel.archive.hw07.beans;

public abstract class Flower implements FlowerInterface, PriceInterface {
    private int price;
    private int tall;
    private int fresh;
    private String name = "flower";

    public Flower(int price, int tall, int fresh, String name) {
        this.price = price;
        this.tall = tall;
        this.fresh = fresh;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "price=" + getPrice() +
                ", tall=" + getTall() +
                ", fresh=" + getFresh() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getTall() {
        return tall;
    }

    @Override
    public int getFresh() {
        return fresh;
    }

    public String getName() {
        return name;
    }
}
