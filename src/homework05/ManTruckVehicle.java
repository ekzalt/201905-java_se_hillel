package homework05;

public class ManTruckVehicle extends TruckVehicle {
    protected String brand = "Man";
    protected String model;

    public ManTruckVehicle(int speed, int price, int fuel, int carrying, String model) {
        super(speed, price, fuel, carrying);
        this.model = model;
    }

    @Override
    public String toString() {
        return "ManTruckVehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carrying=" + carrying +
                ", speed=" + speed +
                ", price=" + price +
                ", fuel=" + fuel +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Man truck is on the road");
    }
}
