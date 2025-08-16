package org.example;

public class Fruit implements Item{
    private String name;
    private double price;

    public Fruit(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
}
