package com.hillel.hw06.park;

import com.hillel.hw06.vehicle.IVehicle;

public interface ITaxiPark {
    int calculateCost();

    IVehicle[] sortByFuel();
    IVehicle[] findBySpeedRange(int min, int max);

    void setCars(IVehicle[] cars);
}
