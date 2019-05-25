package homework05;

public abstract class CarVehicle extends Vehicle {
    // комфорт
    protected int comfort;

    public CarVehicle(int speed, int price, int fuel, int comfort) {
        super(speed, price, fuel);
        this.comfort = comfort;
    }
}
