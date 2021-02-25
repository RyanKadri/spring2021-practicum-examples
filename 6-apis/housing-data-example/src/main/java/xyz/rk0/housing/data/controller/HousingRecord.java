package xyz.rk0.housing.data.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HousingRecord {

    private final double price;
    private final double squareFeet;
    private final String zipCode;
    private final LocalDate saleDate;

    public HousingRecord(double price, double squareFeet, String zipCode, LocalDate saleDate) {
        this.price = price;
        this.squareFeet = squareFeet;
        this.zipCode = zipCode;
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }
}
