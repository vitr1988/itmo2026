package ru.itmo.spring.lesson2.old;

//@Data
public class Truck {

    private String brand;
    private Double tonnage;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getTonnage() {
        return tonnage;
    }

    public void setTonnage(Double tonnage) {
        this.tonnage = tonnage;
    }
}
