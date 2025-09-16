package org.example;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //it's Main origin

    public static void main(String[] args) {
        var cars = new ArrayList<>(
            Arrays.asList(
                new Toyota(
                    "Land Cruiser Prado", "White", Year.of(2015), 50000,
                    "Standard", "Automatic"
                ),
                new Lexus(
                    "RX 350", "Black", Year.of(2020), 90000,
                    "Premium", "Automatic"
                ),
                new Hyundai(
                    "Santa fe", "Grey", Year.of(2023), 20000,
                    "Standard", "Mechanical"
                ),
                new Toyota(
                    "Camry", "White", Year.of(2001), 3000,
                    "Standard", "Mechanical"
                ),
                new Kia(
                    "Rio", "White", Year.of(2002), 2000,
                    "Premium", "Mechanical"
                ),
                new Kia(
                    "Sportage", "Red", Year.of(2015), 10000,
                    "Comfort", "Mechanical"
                ),
                new Suzuki(
                    "SX4", "White", Year.of(2024), 20000,
                    "Standard", "Mechanical"
                ),
                new Lexus(
                    "LX 500", "Olive", Year.of(2020), 100000,
                    "Comfort", "Automatic"
                ),
                new Lexus(
                    "LC 500", "Black", Year.of(2024), 70000,
                    "Standard", "Automatic"
                ),
                new Hyundai(
                    "Solaris", "Gey", Year.of(2020), 15000,
                    "Standard", "Mechanical"
                )
            )
        );

        Car.actualize(
            cars,
            Year.of(2006),
            car -> System.out.println("Car is outdated"),
            System.out::println
        );
        Car.changeColor(cars, "Red", "Green");
        Car.reprice(cars, Year.of(2020));
        Car.print(cars);
    }
}