package homework05;

public class ManTruckVehicle extends TruckVehicle {
    private String brand = "Man";
    private String model;

    public ManTruckVehicle(int speed, int price, int fuel, int carrying, String model) {
        super(speed, price, fuel, carrying);
        this.model = model;
    }

    @Override
    public String toString() {
        return "ManTruckVehicle{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", carrying=" + getCarrying() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                ", fuel=" + getFuel() +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Man truck is on the road");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
