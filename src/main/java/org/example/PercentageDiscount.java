package org.example;

public class PercentageDiscount implements Discount {
    private final Fruit fruit;
    private final double percentage;
    private final String description;

    public PercentageDiscount(Fruit fruit, double percentage, String description) {
        this.fruit = fruit;
        this.percentage = percentage;
        this.description = description;
    }

    public double apply(ShoppingBasket basket) {
        double total = 0;
        for (Item i : basket.getItems()) {
            if (i == fruit) {
                total += i.getPrice() * percentage;
            }
        }
        return total;
    }

    public boolean appliesTo(Fruit fruit) {
        return this.fruit == fruit;
    }

    public String getDescription() {
        return description;
    }
}
