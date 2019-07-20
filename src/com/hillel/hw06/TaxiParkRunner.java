package com.hillel.hw06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.hillel.hw06.park.ITaxiPark;
import com.hillel.hw06.park.TaxiPark;
import com.hillel.hw06.vehicle.IVehicle;
import com.hillel.hw06.vehicle.Toyota;
import com.hillel.hw12.VehicleComparator;

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

        List<IVehicle> cars = new ArrayList<>();
        cars.add(new Toyota(200, 20000, 5, 2, "Auris"));
        cars.add(new Toyota(150, 40000, 10, 7, "4 Runner"));
        cars.add(new Toyota(250, 30000, 7, 5, "Camry"));

        ITaxiPark park = new TaxiPark();

        System.out.println("\nsort with interface implementation\n");
        park.setCars(cars);
        System.out.println(park.sort(comparatorImp));

        System.out.println("\nsort with lambda\n");
        park.setCars(cars);
        System.out.println(park.sort(comparatorLambda));

        System.out.println("\nsort with link to method\n");
        park.setCars(cars);
        System.out.println(park.sort(VehicleComparator::compare));
    }
}
