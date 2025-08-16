package org.example;

public class FixedDiscount implements Discount {
    private final Fruit fruit;
    private final int minQuantity;
    private final double amount;
    private final String description;

    public FixedDiscount(Fruit fruit, int minQuantity, double amount, String description) {
        this.fruit = fruit;
        this.minQuantity = minQuantity;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public double apply(ShoppingBasket basket) {
        long count = basket.getItems().stream().filter(i -> i == fruit).count();
        if (count >= minQuantity) {
            return amount;
        }
        return 0;
    }

    @Override
    public boolean appliesTo(Fruit fruit) {
        return this.fruit == fruit;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
