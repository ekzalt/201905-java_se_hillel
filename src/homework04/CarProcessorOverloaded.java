package homework04;

import homework03.Car;
import homework03.CarProcessor;

import java.util.Calendar;
import java.util.Date;

public class CarProcessorOverloaded extends CarProcessor {
    private Car[] cars;

    public CarProcessorOverloaded(Car[] cars) {
        this.cars = cars;
    }

    public CarProcessorOverloaded() {
        this.cars = new Car[0];
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void printByBrand(String brand) {
        if (cars.length == 0) {
            return;
        }

        for (Car car : cars) {
            if (car.getBrand().equals(brand)) {
                System.out.println(car.toString());
            }
        }
    }

    public void printByModelAndOlderThan(String model, int years) {
        if (cars.length == 0) {
            return;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);

        for (Car car : cars) {
            if (car.getModel().equals(model) && car.getYear() <= (currentYear - years)) {
                System.out.println(car.toString());
            }
        }
    }

    public void printByYearAndPriceGreaterThan(int year, int price) {
        if (cars.length == 0) {
            return;
        }

        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() >= price) {
                System.out.println(car.toString());
            }
        }
    }
}
