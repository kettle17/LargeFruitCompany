package org.example;

public class Shop {

    private Fruit[] fruits;
    private Discount[] discounts;

    public Shop() {
        fruits = new Fruit[] {
                Fruit.APPLE,
                Fruit.CHERRY,
                Fruit.BANANA,
                Fruit.MANGO
        };

        discounts = new Discount[] {
                new PercentageDiscount(Fruit.APPLE, 0.10, "10% off Apples"),
                new FixedDiscount(Fruit.CHERRY, 4, 0.50, "50p off >4 Cherries"),
                new BuyXGetYFreeDiscount(Fruit.MANGO, 3, Fruit.APPLE, 1, "Buy 3+ Mangos, get 1 Apple free"),
                new BigSpenderDiscount(5.0, 0.02, "2% off if basket > £5")
        };
    }

    public Fruit getFruitByName(String name) {
        for (Fruit f : fruits) {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }
        }
        return null;
    }

    public Discount[] getAllDiscounts() {
        return discounts;
    }

    public Discount[] getDiscountsForFruit(Fruit fruit) {
        return java.util.Arrays.stream(discounts)
                .filter(d -> d.appliesTo(fruit))
                .toArray(Discount[]::new);
    }
}
