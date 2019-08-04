package com.hillel.hw06.vehicle;

public abstract class Bus extends Vehicle {
    // вместимость
    private int capacity;

    public Bus(int speed, int price, int fuel, int capacity) {
        super(speed, price, fuel);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
