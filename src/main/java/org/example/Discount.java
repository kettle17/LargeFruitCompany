package org.example;

public interface Discount {
    double apply(ShoppingBasket basket);
    String getDescription();
    boolean appliesTo(Fruit fruit);
}