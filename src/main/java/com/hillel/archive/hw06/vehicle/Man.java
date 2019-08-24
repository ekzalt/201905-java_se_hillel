package com.hillel.archive.hw06.vehicle;

public class Man extends Truck {
    private String brand = "Man";
    private String model;

    public Man(int speed, int price, int fuel, int carrying, String model) {
        super(speed, price, fuel, carrying);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Man{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", carrying=" + getCarrying() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                ", fuel=" + getFuel() +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Man truck is on the road");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
