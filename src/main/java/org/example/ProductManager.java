package org.example;

import java.util.Arrays;

public class ProductManager {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Fruit getFruitByName(String name) {
        return repository.getByName(name);
    }

    public Fruit getFruitById(int id) {
        return repository.getById(id);
    }

    public Discount[] getDiscountsForFruit(Fruit fruit) {
        return repository.getDiscountsForFruit(fruit);
    }

    public double calculateTotalWithDiscounts(ShoppingBasket basket) {
        double total = basket.getBasketSum();

        for (Item item : basket.getItems()) {
            if (item instanceof Fruit fruit) {
                Discount[] discounts = getDiscountsForFruit(fruit);
                for (Discount d : discounts) {
                    total -= d.apply(basket);
                }
            }
        }

        for (Discount d : repository.getAllDiscounts()) {
            if (d instanceof BigSpenderDiscount) {
                total -= d.apply(basket);
            }
        }

        return total;
    }
}