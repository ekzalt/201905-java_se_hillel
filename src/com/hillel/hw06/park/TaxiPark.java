package com.hillel.hw06.park;

import com.hillel.hw06.vehicle.IVehicle;
import com.hillel.hw06.vehicle.Toyota;

import java.util.Arrays;
import java.util.Comparator;

public class TaxiPark implements ITaxiPark {
    private IVehicle[] cars;

    public TaxiPark() {
        this.cars = new Toyota[0];
    }

    public TaxiPark(IVehicle[] cars) {
        this.cars = cars;
    }

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

    @Override
    public IVehicle[] sortByFuel() {
        if (cars.length == 0) return cars;

        bubbleSortByFuel(cars);
        return cars;
    }

    @Override
    public IVehicle[] sort(Comparator<? super IVehicle> comparator) {
        Arrays.sort(cars, comparator);
        return cars;
    }

    @Override
    public IVehicle[] sort(IVehicle[] array, Comparator<? super IVehicle> comparator) {
        Arrays.sort(array, comparator);
        return array;
    }

    @Override
    public int calculateCost() {
        int cost = 0;

        if (cars.length == 0) return cost;

        for (IVehicle car : cars) {
            cost += car.getPrice();
        }

        return cost;
    }

    private IVehicle[] resizeAndPush(IVehicle[] cars, IVehicle car) {
        /*
        IVehicle[] copy = new Toyota[cars.length + 1];
        for (int i = 0; i < cars.length; i++) copy[i] = cars[i];
         */

        IVehicle[] copy = Arrays.copyOf(cars, cars.length + 1);
        copy[copy.length - 1] = car;

        return copy;
    }

    @Override
    public IVehicle[] findBySpeedRange(int min, int max) {
        IVehicle[] filtered = new Toyota[0];

        for (IVehicle car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                filtered = resizeAndPush(filtered, car);
            }
        }

        return filtered;
    }

    @Override
    public void setCars(IVehicle[] cars) {
        this.cars = cars;
    }
}
