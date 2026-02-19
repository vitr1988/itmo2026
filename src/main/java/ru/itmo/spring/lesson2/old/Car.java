package ru.itmo.spring.lesson2.old;

public class Car {

    private String model;
    private String brand;
    private int year;

    private double engineVolume;

    public void setModel(String model) {
        if ("Octavia".equals(model)) {
            this.model = "Default";
        } else {
            this.model = model;
        }
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
}
