package com.hillel.hw10;

import com.hillel.hw06.vehicle.IVehicle;
import com.hillel.hw06.vehicle.Toyota;

public class VehicleFactory {
    public Toyota createToyota(String[] arguments) {
        int speed = Integer.parseInt(arguments[0]);
        int price = Integer.parseInt(arguments[1]);
        int fuel = Integer.parseInt(arguments[2]);
        int capacity = Integer.parseInt(arguments[3]);
        String model = arguments[4];

        return new Toyota(speed, price, fuel, capacity, model);
    }

    public IVehicle create(String[] arguments) {
        String type = arguments[arguments.length - 1];

        switch (type) {
            case "Toyota":
                return createToyota(arguments);
            default:
                throw new UnsupportedOperationException("No such type");
        }
    }
}
