package org.example;

import java.time.Year;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;

public abstract class Car {
    protected String model;
    protected String color;
    protected final Year releaseDate;
    protected int price;
    protected String equipment;
    protected String gearbox;

    public Car(String name, String color, Year releaseDate, int price, String equipment, String gearbox) {
        this.model = name;
        this.color = color;
        this.releaseDate = releaseDate;
        this.price = price;
        this.equipment = equipment;
        this.gearbox = gearbox;
    }

    public String getModel() { return model; }

    public void setModel(String value) { this.model = value; }

    public String getColor() { return color; }

    public void setColor(String value) { this.color = value; }

    public Year getReleaseDate() { return releaseDate; }

    public int getPrice() { return price; }

    public void setPrice(int value) { price = value; }

    public abstract String getInfo();

    @Override
    public String toString() {
        return getInfo();
    }

    public static void actualize(List<Car> cars, Year year, Consumer<Car> beforeAction, Consumer<Car> afterAction) {
        for (var car : cars) {
            var before2006 = car.releaseDate.isBefore(year);
            if (before2006) {
                beforeAction.accept(car);
            }
            else {
                afterAction.accept(car);
            }
        }
    }

    public static void changeColor(List<Car> cars, String from, String to) {
        for (var car : cars) {
            if (car.getColor().equals(from)) {
                car.setColor(to);
            }
        }
    }

    public static void reprice(List<Car> cars, Year after) {
        for (var car : cars) {
            var isAfter2020 = car.releaseDate.isAfter(after);
            if (isAfter2020) {
                car.price = (int)(car.price * 1.2f);
            }
        }
    }

    public static void print(List<Car> cars) {
        for (var car : cars) {
            out.println(car);
        }
    }
}
