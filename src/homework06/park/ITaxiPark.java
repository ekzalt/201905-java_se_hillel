package homework06.park;

import homework06.vehicle.IVehicle;

public interface ITaxiPark {
    int calculateCost();

    IVehicle[] sortByFuel();
    IVehicle[] findBySpeedRange(int min, int max);

    void setCars(IVehicle[] cars);
}
