package homework05;

public class ToyotaCarVehicle extends CarVehicle {
    private String brand = "Toyota";
    private String model;

    public ToyotaCarVehicle(int speed, int price, int fuel, int capacity, String model) {
        super(speed, price, fuel, capacity);
        this.model = model;
    }

    @Override
    public String toString() {
        return "ToyotaCarVehicle{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", comfort=" + getComfort() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                ", fuel=" + getFuel() +
                '}';
    }

    @Override
    public void go() {
        System.out.println("Toyota car is on the road");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
