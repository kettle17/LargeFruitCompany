package org.example;

public class BigSpenderDiscount implements Discount {
    private final double threshold;
    private final double percentage;
    private final String description;

    public BigSpenderDiscount(double threshold, double percentage, String description) {
        this.threshold = threshold;
        this.percentage = percentage;
        this.description = description;
    }

    @Override
    public double apply(ShoppingBasket basket) {
        double total = basket.getBasketSum(); // total before discounts
        if (total > threshold) {
            return total * percentage;
        }
        return 0;
    }

    @Override
    public boolean appliesTo(Fruit fruit) {
        return true; // applies to whole basket, not a single fruit
    }

    @Override
    public String getDescription() {
        return description;
    }
}