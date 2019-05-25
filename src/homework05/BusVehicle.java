package homework05;

public abstract class BusVehicle extends Vehicle {
    // вместимость
    protected int capacity;

    public BusVehicle(int speed, int price, int fuel, int capacity) {
        super(speed, price, fuel);
        this.capacity = capacity;
    }
}
