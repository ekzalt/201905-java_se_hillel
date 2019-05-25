package homework05;

public class IsuzuBusVehicle extends BusVehicle {
    protected String brand = "Isuzu";
    protected String model;

    public IsuzuBusVehicle(int speed, int price, int fuel, int capacity, String model) {
        super(speed, price, fuel, capacity);
        this.model = model;
    }

    @Override
    public String toString() {
        return "IsuzuBusVehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", price=" + price +
                ", fuel=" + fuel +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Isuzu bus is on the road");
    }
}
