package com.shriyasht.sqlitedbroomlib.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "car")
public class Car implements Serializable {
    @PrimaryKey
    private int carNo;
    private String carName;
    private double price;

    public Car() {
    }

    public Car(int carNo, String carName, double price) {
        this.carNo = carNo;
        this.carName = carName;
        this.price = price;
    }

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
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

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "carNo=" + carNo +
                ", carName='" + carName + '\'' +
                ", price=" + price +
                '}';
    }
}
