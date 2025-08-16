package org.example;

public interface ProductRepository {

    Fruit getById(int id);            // Get a fruit by its ID
    Fruit getByName(String name);     // Get a fruit by its name
    Discount[] getAllDiscounts();     // Get all discounts
    Discount[] getDiscountsForFruit(Fruit fruit); // Get discounts for a specific fruit
}