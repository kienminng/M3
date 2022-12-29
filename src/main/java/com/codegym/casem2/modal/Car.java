package com.codegym.casem2.modal;

public class Car {
    private int carID;
    private String carName;
    private double price;
    private String color;
    private String img;
    private String branch;

    public Car() {
    }

    public Car(int carID,String carName, double price, String color,String img, String branch) {
        this.carID =carID;
        this.carName = carName;
        this.price = price;
        this.color = color;
        this.img = img;
        this.branch = branch;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
