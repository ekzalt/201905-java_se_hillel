package com.hillel.archive.hw06.vehicle;

public class Toyota extends Car {
    private String brand = "Toyota";
    private String model;

    public Toyota(int speed, int price, int fuel, int capacity, String model) {
        super(speed, price, fuel, capacity);
        this.model = model;
    }

    @Override
    public String toString() {
        /*
        return "Toyota{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", comfort=" + getComfort() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                ", fuel=" + getFuel() +
                '}';
         */

        StringBuilder builder = new StringBuilder();
        builder
                .append(getSpeed()+",")
                .append(getPrice()+",")
                .append(getFuel()+",")
                .append(getComfort()+",")
                .append(getModel()+",")
                .append(getClass().getSimpleName()+";");

        return builder.toString();
    }

    @Override
    public void go() {
        System.out.println("Toyota car is on the road");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
