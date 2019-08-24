package com.hillel.archive.hw03;

public class Car {
    private int id;
    private int year;
    private int price;

    private String brand;
    private String model;
    private String color;
    private String registration;

    public Car(int id, int year, int price, String brand, String model, String color, String registration) {
        this.id = id;
        this.year = year;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
