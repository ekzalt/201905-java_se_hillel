package com.hillel.archive.hw06.vehicle;

public abstract class Truck extends Vehicle {
    // грузоподъемность
    private int carrying;

    public Truck(int speed, int price, int fuel, int carrying) {
        super(speed, price, fuel);
        this.carrying = carrying;
    }

    public int getCarrying() {
        return carrying;
    }
}
