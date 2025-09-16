package org.example;

import java.time.Year;

public class Hyundai extends Car {
    public Hyundai(String name, String color, Year releaseDate, int price, String equipment, String gearbox) {
        super(name, color, releaseDate, price, equipment, gearbox);
    }

    @Override
    public String getInfo() {
        return "Hyundai. Model: " + model + ". Color: " + color + ". Release date: " + releaseDate + ". Equipment: " + equipment +
                ". Gearbox: " + gearbox + ". Price: " + price;
    }
}
