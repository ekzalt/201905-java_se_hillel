package com.hillel.hw06.park;

import java.util.*;

import com.hillel.hw06.vehicle.IVehicle;

public class TaxiPark implements ITaxiPark {
    private List<IVehicle> cars;

    public TaxiPark() {
        this.cars = new ArrayList<>();
    }

    public TaxiPark(IVehicle[] cars) {
        this();
        this.cars.addAll(Arrays.asList(cars));
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
    public List<IVehicle> sort(Comparator<? super IVehicle> comparator) {
        cars.sort( comparator);
        return cars;
    }

    @Override
    public List<IVehicle> sort(List<IVehicle> array, Comparator<? super IVehicle> comparator) {
        Collections.sort(array, comparator);
        return array;
    }

    @Override
    public int calculateCost() {
        int cost = 0;

        for (IVehicle car : cars) {
            cost += car.getPrice();
        }

        return cost;
    }

    private IVehicle[] resizeAndPush(IVehicle[] cars, IVehicle car) {
        /*
        // custom resize and copy
        IVehicle[] copy = new Toyota[cars.length + 1];
        for (int i = 0; i < cars.length; i++) copy[i] = cars[i];
         */

        IVehicle[] copy = Arrays.copyOf(cars, cars.length + 1);
        copy[copy.length - 1] = car;

        return copy;
    }

    @Override
    public List<IVehicle> findBySpeedRange(int min, int max) {
        List<IVehicle> filtered = new ArrayList<>();

        for (IVehicle car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                filtered.add(car);
            }
        }

        return filtered;
    }

    @Override
    public void setCars(List<IVehicle> cars) {
        this.cars = cars;
    }
}
