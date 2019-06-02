package homework05;

import java.util.Arrays;

public class TaxiPark {
    private CarVehicle[] cars = new CarVehicle[0];
    private CarVehicle[] temp;

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

    private CarVehicle[] resize(int capacity) {
        CarVehicle[] copy = new CarVehicle[capacity];

        for (int i = 0; i < temp.length; i++) {
            copy[i] = temp[i];
        }

        return copy;
    }

    private void push(CarVehicle car) {
        temp = resize(temp.length + 1);
        temp[temp.length -1] = car;
    }

    public CarVehicle[] findBySpeedRange(int min, int max) {
        temp = new CarVehicle[0];

        if (cars.length == 0) return temp;

        for (CarVehicle car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                push(car);
            }
        }

        return temp;
    }
}
