package homework06.vehicle;

public abstract class Car extends Vehicle {
    // комфорт
    private int comfort;

    public Car(int speed, int price, int fuel, int comfort) {
        super(speed, price, fuel);
        this.comfort = comfort;
    }

    public int getComfort() {
        return comfort;
    }
}
