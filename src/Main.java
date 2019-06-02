import homework06.vehicle.IVehicle;
import homework06.vehicle.Toyota;
import homework06.park.ITaxiPark;
import homework06.park.TaxiPark;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nhomework 6\n");

        IVehicle[] taxiCars = {
                new Toyota(200, 20000, 5, 2, "Auris"),
                new Toyota(150, 40000, 10, 7, "4 Runner"),
                new Toyota(250, 30000, 7, 5, "Camry"),
        };
        ITaxiPark park = new TaxiPark();
        park.setCars(taxiCars);

        System.out.println("\ncalculate cost\n");
        System.out.println(park.calculateCost());

        System.out.println("\nsort by fuel\n");
        IVehicle[] sorted = park.sortByFuel();
        for (IVehicle car : sorted) {
            System.out.println(car);
        }

        System.out.println("\nfind by speed range\n");
        IVehicle[] found = park.findBySpeedRange(200, 250);
        for (IVehicle car : found) {
            System.out.println(car);
        }
    }
}
