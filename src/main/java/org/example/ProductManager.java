package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ProductManager {
    private static final Logger logger = LoggerFactory.getLogger(ProductManager.class);

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
        double subtotal = basket.getBasketSum();
        logger.info("Initial basket total: £{}", String.format("%.2f", subtotal));

        double totalDiscount = 0.0;

        for (Discount discount : repository.getAllDiscounts()) {
            double discountAmount = discount.apply(basket);

            if (discountAmount > 0) {
                logger.info("Applied discount: {} -> -£{}",
                        discount.getDescription(),
                        String.format("%.2f", discountAmount));
                totalDiscount += discountAmount;
            } else {
                logger.info("Skipped discount: {}", discount.getDescription());
            }
        }

        double finalTotal = subtotal - totalDiscount;
        logger.info("Final basket total after discounts: £{}", String.format("%.2f", finalTotal));
        return finalTotal;
    }
}