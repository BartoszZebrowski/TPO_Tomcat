package com.example.tomcat.models;

import java.util.Date;

public class Car {
    public int Id;
    public String Type;
    public String Brand;
    public int ProductionYear;
    public int LitersPerHundredKms;

    public Car(int id, String type, String brand, int productionYear, int litersPerHundredKms) {
        Id = id;
        Type = type;
        Brand = brand;
        ProductionYear = productionYear;
        LitersPerHundredKms = litersPerHundredKms;
    }
}
