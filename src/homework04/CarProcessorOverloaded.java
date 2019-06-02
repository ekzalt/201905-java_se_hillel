package homework04;

import homework03.Car;
import homework03.CarProcessor;

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
        // delegation to the polymorphic overloaded method
        printByBrand(cars, brand);
    }

    public void printByModelAndOlderThan(String model, int years) {
        // delegation to the polymorphic overloaded method
        printByModelAndOlderThan(cars, model, years);
    }

    public void printByYearAndPriceGreaterThan(int year, int price) {
        // delegation to the polymorphic overloaded method
        printByYearAndPriceGreaterThan(cars, year, price);
    }
}
