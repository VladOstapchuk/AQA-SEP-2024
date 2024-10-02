package org.prog.homeworks.session4;

import org.prog.collections.CarOwner;

//Class for Cars - Getter, Setter, Constructor and overrided toString
public class Car {
    private String brand;
    private String color;
    private int modelNumber;
    private NewCarOwner carOwner;

    public Car(String brand, String color, int modelNumber) {
        this.brand = brand;
        this.color = color;
        this.modelNumber = modelNumber;
    }

    public Car(String brand, String color, int modelNumber, NewCarOwner carOwner) {
        this.brand = brand;
        this.color = color;
        this.modelNumber = modelNumber;
        this.carOwner = carOwner;
    }

    public NewCarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(NewCarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }



    public void setColor(String color) {
        this.color = color;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", modelNumber=" + modelNumber +
                '}';
    }
}
