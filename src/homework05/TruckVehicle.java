package homework05;

public abstract class TruckVehicle extends Vehicle {
    // грузоподъемность
    private int carrying;

    public TruckVehicle(int speed, int price, int fuel, int carrying) {
        super(speed, price, fuel);
        this.carrying = carrying;
    }

    public int getCarrying() {
        return carrying;
    }
}
