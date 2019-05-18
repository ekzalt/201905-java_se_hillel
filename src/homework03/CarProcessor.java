package homework03;

/*
Создать класс по спецификации. Определить конструктор для всех полей. Создать отдельно класс процессор, который
будет выполнять определенные действия с объектами и содержать метод для печати объекта. В методе main создать массив
объектов и используя класс процессор выполнить необходимые операции.

Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.

Создать массив объектов. Вывести:
a) список автомобилей заданной марки;
b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
c) список автомобилей заданного года выпуска, цена которых больше указанной.
 */

import java.util.Calendar;
import java.util.Date;

public class CarProcessor {
    public void printByBrand(Car[] cars, String brand) {
        for (Car car : cars) {
            if (car.getBrand().equals(brand)) {
                System.out.println(car.toString());
            }
        }
    }

    public void printByModelAndOlderThan(Car[] cars, String model, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);

        for (Car car : cars) {
            if (car.getModel().equals(model) && car.getYear() <= (currentYear - years)) {
                System.out.println(car.toString());
            }
        }
    }

    public void printByYearAndPriceGreaterThan(Car[] cars, int year, int price) {
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() >= price) {
                System.out.println(car.toString());
            }
        }
    }
}
