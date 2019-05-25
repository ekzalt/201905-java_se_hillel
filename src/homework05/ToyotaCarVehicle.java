package homework05;

public class ToyotaCarVehicle extends CarVehicle {
    protected String brand = "Toyota";
    protected String model;

    public ToyotaCarVehicle(int speed, int price, int fuel, int capacity, String model) {
        super(speed, price, fuel, capacity);
        this.model = model;
    }

    @Override
    public String toString() {
        return "ToyotaCarVehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", comfort=" + comfort +
                ", speed=" + speed +
                ", price=" + price +
                ", fuel=" + fuel +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Toyota car is on the road");
    }
}
