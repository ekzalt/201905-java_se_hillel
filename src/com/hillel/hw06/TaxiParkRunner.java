package com.hillel.hw06;

import java.util.Arrays;

import com.hillel.hw06.park.ITaxiPark;
import com.hillel.hw06.park.TaxiPark;
import com.hillel.hw06.vehicle.IVehicle;
import com.hillel.hw06.vehicle.Toyota;

public class TaxiParkRunner {
    public void run() {
        ITaxiPark park = new TaxiPark(Arrays.asList(
                new Toyota(200, 20000, 5, 2, "Auris"),
                new Toyota(150, 40000, 10, 7, "4 Runner"),
                new Toyota(250, 30000, 7, 5, "Camry")
        ));

        System.out.println(park.sort((IVehicle a, IVehicle b) -> (a.getFuel() - b.getFuel())));
        System.out.println(park.calculateCost());
        System.out.println(park.findBySpeedRange(200, 250));
    }
}
