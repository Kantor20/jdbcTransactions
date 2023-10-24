package pl.kurs.zadanieCarVol2.model;

import lombok.*;


@Getter
@Setter
@ToString
public class Car {
    private int id;
    private String brand;
    private String model;
    private double mileage;

    public Car(String brand, String model, double mileage) {
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
    }
}
