package homework06.vehicle;

public abstract class Vehicle implements IVehicle {
    private int speed;
    private int price;
    private int fuel;

    public Vehicle(int speed, int price, int fuel) {
        this.speed = speed;
        this.price = price;
        this.fuel = fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }

    public int getFuel() {
        return fuel;
    }

    public abstract void go();
}
