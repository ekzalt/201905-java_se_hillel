package com.hillel.archive.hw06.park;

import java.util.*;
import java.util.stream.Collectors;

import com.hillel.archive.hw06.vehicle.IVehicle;

public class TaxiPark implements ITaxiPark {
    private List<IVehicle> cars;

    public TaxiPark() {
        this.cars = new ArrayList<>();
    }

    public TaxiPark(List<IVehicle> cars) {
        this.cars = cars;
    }

    @Override
    public List<IVehicle> sort(Comparator<? super IVehicle> comparator) {
        return cars
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public int calculateCost() {
        return cars
                .stream()
                .map((IVehicle car) -> car.getPrice())
                .reduce(0, (Integer a, Integer b) -> a + b);
    }

    @Override
    public List<IVehicle> findBySpeedRange(int min, int max) {
        return cars
                .stream()
                .filter((IVehicle car) -> (car.getSpeed() >= min && car.getSpeed() <= max))
                .collect(Collectors.toList());
    }

    @Override
    public void setCars(List<IVehicle> cars) {
        this.cars = cars;
    }

    /*
    private IVehicle[] resizeAndPush(IVehicle[] cars, IVehicle car) {
        // custom resize and copy
        // IVehicle[] copy = new Toyota[cars.length + 1];
        // for (int i = 0; i < cars.length; i++) copy[i] = cars[i];

        IVehicle[] copy = Arrays.copyOf(cars, cars.length + 1);
        copy[copy.length - 1] = car;

        return copy;
    }

    private void bubbleSortByFuel(IVehicle[] cars) {
        for (int i = cars.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cars[j].getFuel() > cars[j + 1].getFuel()) {
                    IVehicle tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                }
            }
        }
    }
     */
}
