package com.hillel.hw06.park;

import com.hillel.hw06.vehicle.IVehicle;

import java.util.Comparator;

public interface ITaxiPark {
    int calculateCost();

    IVehicle[] sortByFuel();
    IVehicle[] findBySpeedRange(int min, int max);

    IVehicle[] sort(Comparator<? super IVehicle> comparator);
    IVehicle[] sort(IVehicle[] array, Comparator<? super IVehicle> comparator);

    void setCars(IVehicle[] cars);
}
