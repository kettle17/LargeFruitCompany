package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addToBasket(Fruit.APPLE);
        basket.addToBasket(Fruit.APPLE);
        basket.addToBasket(Fruit.CHERRY);
        basket.addToBasket(Fruit.CHERRY);
        basket.addToBasket(Fruit.CHERRY);
        basket.addToBasket(Fruit.CHERRY);
        basket.addToBasket(Fruit.CHERRY);

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new PercentageDiscount(Fruit.APPLE, 0.10, "10% off Apples"));
        discounts.add(new FixedDiscount(Fruit.CHERRY, 5, 0.50, "50p off >4 Cherries"));
        discounts.add(new BigSpenderDiscount(5.0, 0.02, "2% off if basket > £5"));

        double finalTotal = basket.calculateTotalWithDiscounts(discounts);
        System.out.println("Final basket total: £" + String.format("%.2f", finalTotal));
    }
}