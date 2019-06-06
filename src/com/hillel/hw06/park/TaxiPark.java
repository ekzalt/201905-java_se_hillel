package com.hillel.hw06.park;

import com.hillel.hw06.vehicle.IVehicle;
import com.hillel.hw06.vehicle.Toyota;

public class TaxiPark implements ITaxiPark {
    private IVehicle[] cars = new Toyota[0];

    private void bubbleSortByFuel(IVehicle[] cars) {
        for (int i = cars.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cars[j].getFuel() > cars[j + 1].getFuel()){
                    IVehicle tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                }
            }
        }
    }

    public IVehicle[] sortByFuel() {
        if (cars.length == 0) return cars;

        bubbleSortByFuel(cars);
        return cars;
    }

    public int calculateCost() {
        int cost = 0;

        if (cars.length == 0) return cost;

        for (IVehicle car : cars) {
            cost += car.getPrice();
        }

        return cost;
    }

    private IVehicle[] resizeAndPush(IVehicle[] cars, IVehicle car) {
        IVehicle[] copy = new Toyota[cars.length + 1];

        for (int i = 0; i < cars.length; i++) {
            copy[i] = cars[i];
        }

        copy[copy.length - 1] = car;

        return copy;
    }

    public IVehicle[] findBySpeedRange(int min, int max) {
        IVehicle[] filtered = new Toyota[0];

        for (IVehicle car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                filtered = resizeAndPush(filtered, car);
            }
        }

        return filtered;
    }

    public void setCars(IVehicle[] cars) {
        this.cars = cars;
    }
}
