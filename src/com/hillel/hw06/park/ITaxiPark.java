package com.hillel.hw06.park;

import com.hillel.hw06.vehicle.IVehicle;

import java.util.ArrayList;
import java.util.Comparator;

public interface ITaxiPark {
    int calculateCost();

    ArrayList<IVehicle> findBySpeedRange(int min, int max);

    ArrayList<IVehicle> sort(Comparator<? super IVehicle> comparator);
    ArrayList<IVehicle> sort(ArrayList<IVehicle> array, Comparator<? super IVehicle> comparator);

    void setCars(ArrayList<IVehicle> cars);
}
