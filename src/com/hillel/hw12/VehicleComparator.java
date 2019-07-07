package com.hillel.hw12;

import com.hillel.hw06.vehicle.IVehicle;

public class VehicleComparator {
    public static int compare(IVehicle o1, IVehicle o2) {
        if (o1.getFuel() > o2.getFuel()) {
            return 1;
        } else if (o1.getFuel() < o2.getFuel()) {
            return -1;
        } else {
            return 0;
        }
    }
}
