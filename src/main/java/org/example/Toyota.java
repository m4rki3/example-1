package org.example;

import java.time.Year;

public class Toyota extends Car {
    public Toyota(String name, String color, Year releaseDate, int price, String equipment, String gearbox) {
        super(name, color, releaseDate, price, equipment, gearbox);
    }

    @Override
    public String getInfo() {
        return "Toyota. Model: " + model + ". Color: " + color + ". Release date: " + releaseDate + ". Equipment: " + equipment +
                ". Gearbox: " + gearbox + ". Price: " + price;
    }
}
