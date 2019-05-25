import homework03.Car;
import homework04.*;
import homework05.CarVehicle;
import homework05.TaxiPark;
import homework05.ToyotaCarVehicle;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nhomework 4\n");

        Car[] cars = {
                new Car(1, 2016, 23000, "Suzuki", "SX4", "blue", "AK9265AK"),
                new Car(2, 2017, 31000, "Mazda", "CX-3", "red", "AK1234AB"),
                new Car(3, 2018, 38000, "BMW", "X1", "white", "CA7890BT"),
        };
        CarProcessorOverloaded processor = new CarProcessorOverloaded(cars);

        processor.printByBrand(cars, "Suzuki");
        processor.printByBrand("Suzuki");

        processor.printByModelAndOlderThan(cars, "CX-3", 2);
        processor.printByModelAndOlderThan("CX-3", 2);

        processor.printByYearAndPriceGreaterThan(cars, 2018, 35000);
        processor.printByYearAndPriceGreaterThan(2018, 35000);

        Recursion recursion = new Recursion();
        recursion.printIntegers(5);
        System.out.println(recursion.sumIntegers(1234));

        Triangle[] triangles = {
                new Triangle(new TrianglePoint(2, 2), new TrianglePoint(8, 2), new TrianglePoint(5, 4)), // isosceles
                new Triangle(new TrianglePoint(1, 1), new TrianglePoint(5, 1), new TrianglePoint(5, 8)), // rectangular
                new Triangle(new TrianglePoint(3, 3), new TrianglePoint(4, 1), new TrianglePoint(10, 6)), // random
        };
        TriangleStatistics statistics = new TriangleStatistics();

        statistics.countEquilateral(triangles);
        statistics.countIsosceles(triangles); // found
        statistics.countRectangular(triangles); // found
        statistics.countRandom(triangles); // found

        System.out.println("\nhomework 5\n");

        CarVehicle[] taxiCars = {
                new ToyotaCarVehicle(200, 20000, 5, 2, "Auris"),
                new ToyotaCarVehicle(150, 40000, 10, 7, "4 Runner"),
                new ToyotaCarVehicle(250, 30000, 7, 5, "Camry"),
        };
        TaxiPark park = new TaxiPark();
        park.setCars(taxiCars);

        System.out.println("\ncalculate cost\n");
        System.out.println(park.calculateCost());

        System.out.println("\nsort by fuel\n");
        CarVehicle[] sorted = park.sortByFuel();
        for (CarVehicle car : sorted) {
            System.out.println(car);
        }

        System.out.println("\nfind by speed range\n");
        CarVehicle[] found = park.findBySpeedRange(200, 250);
        for (CarVehicle car : found) {
            System.out.println(car);
        }
    }
}
