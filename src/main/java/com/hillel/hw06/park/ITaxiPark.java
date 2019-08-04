package com.hillel.hw06.park;

import com.hillel.hw06.vehicle.IVehicle;

import java.util.Comparator;
import java.util.List;

public interface ITaxiPark {
    int calculateCost();

    List<IVehicle> findBySpeedRange(int min, int max);

    List<IVehicle> sort(Comparator<? super IVehicle> comparator);

    void setCars(List<IVehicle> cars);
}
