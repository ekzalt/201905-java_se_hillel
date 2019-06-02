package homework05;

public class IsuzuBusVehicle extends BusVehicle {
    private String brand = "Isuzu";
    private String model;

    public IsuzuBusVehicle(int speed, int price, int fuel, int capacity, String model) {
        super(speed, price, fuel, capacity);
        this.model = model;
    }

    @Override
    public String toString() {
        return "IsuzuBusVehicle{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                ", fuel=" + getFuel() +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Isuzu bus is on the road");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
