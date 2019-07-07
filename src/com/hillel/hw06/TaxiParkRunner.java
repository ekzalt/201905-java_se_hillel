package com.hillel.hw06;

import com.hillel.hw06.park.ITaxiPark;
import com.hillel.hw06.park.TaxiPark;
import com.hillel.hw06.vehicle.IVehicle;
import com.hillel.hw06.vehicle.Toyota;
import com.hillel.hw12.VehicleComparator;

import java.util.Arrays;
import java.util.Comparator;

public class TaxiParkRunner {
    public void run() {
        Comparator<IVehicle> comparatorImp = new Comparator<>() {
            @Override
            public int compare(IVehicle o1, IVehicle o2) {
                if (o1.getFuel() > o2.getFuel()) {
                    return 1;
                } else if (o1.getFuel() < o2.getFuel()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        Comparator<IVehicle> comparatorLambda = (IVehicle o1, IVehicle o2) -> {
            if (o1.getFuel() > o2.getFuel()) {
                return 1;
            } else if (o1.getFuel() < o2.getFuel()) {
                return -1;
            } else {
                return 0;
            }
        };

        IVehicle[] cars = {
                new Toyota(200, 20000, 5, 2, "Auris"),
                new Toyota(150, 40000, 10, 7, "4 Runner"),
                new Toyota(250, 30000, 7, 5, "Camry"),
        };
        ITaxiPark park = new TaxiPark();

        System.out.println("\nsort with interface implementation\n");
        park.setCars(Arrays.copyOf(cars, cars.length));
        System.out.println(Arrays.toString(park.sort(comparatorImp)));

        System.out.println("\nsort with lambda\n");
        park.setCars(Arrays.copyOf(cars, cars.length));
        System.out.println(Arrays.toString(park.sort(comparatorLambda)));

        System.out.println("\nsort with link to method\n");
        park.setCars(Arrays.copyOf(cars, cars.length));
        System.out.println(Arrays.toString(park.sort(VehicleComparator::compare)));
    }
}
