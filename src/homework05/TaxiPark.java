package homework05;

import java.util.Arrays;

public class TaxiPark {
    private CarVehicle[] cars = new CarVehicle[0];

    public void setCars(CarVehicle[] cars) {
        this.cars = cars;
    }

    private void bubbleSortByFuel(CarVehicle[] cars) {
        for (int i = cars.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cars[j].getFuel() > cars[j + 1].getFuel()){
                    CarVehicle tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                }
            }
        }
    }

    public CarVehicle[] sortByFuel() {
        if (cars.length == 0) return cars;

        bubbleSortByFuel(cars);
        return cars;
    }

    public int calculateCost() {
        int cost = 0;

        if (cars.length == 0) return cost;

        for (CarVehicle car : cars) {
            cost += car.getPrice();
        }

        return cost;
    }

    private CarVehicle[] resizeAndPush(CarVehicle[] cars, CarVehicle car) {
        CarVehicle[] copy = new CarVehicle[cars.length + 1];

        for (int i = 0; i < cars.length; i++) {
            copy[i] = cars[i];
        }

        copy[copy.length - 1] = car;

        return copy;
    }

    public CarVehicle[] findBySpeedRange(int min, int max) {
        CarVehicle[] filtered = new CarVehicle[0];

        for (CarVehicle car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                filtered = resizeAndPush(filtered, car);
            }
        }

        return filtered;
    }
}
