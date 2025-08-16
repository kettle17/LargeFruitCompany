package org.example;

public enum Fruit implements Item {
    APPLE("Apple", 1.0),
    BANANA("Banana", 0.5),
    CHERRY("Cherry", 0.2),
    MANGO("Mango", 1.5);

    private final String name;
    private final double price;

    Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}