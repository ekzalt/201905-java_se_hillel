import homework02.HomeworkSecond;
import homework03.Car;
import homework03.CarProcessor;

public class Main {
    public static void main(String[] args) {
        // new HomeworkSecond().run();

        Car[] cars = {
                new Car(1, 2016, 23000, "Suzuki", "SX4", "blue", "AK9265AK"),
                new Car(2, 2017, 31000, "Mazda", "CX-3", "red", "AK1234AB"),
                new Car(3, 2018, 38000, "BMW", "X1", "white", "CA7890BT"),
        };

        CarProcessor carProcessor = new CarProcessor();

        System.out.println("\ntask a\n");
        carProcessor.printByBrand(cars, "Suzuki");

        System.out.println("\ntask b\n");
        carProcessor.printByModelAndOlderThan(cars, "CX-3", 2);

        System.out.println("\ntask c\n");
        carProcessor.printByYearAndPriceGreaterThan(cars, 2018, 35000);
    }
}
