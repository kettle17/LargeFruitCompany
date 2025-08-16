package org.example;

public class BuyXGetYFreeDiscount implements Discount {
    private final Fruit buyFruit;
    private final int buyQuantity;
    private final Fruit freeFruit;
    private final int freeQuantity;
    private final String description;

    public BuyXGetYFreeDiscount(Fruit buyFruit, int buyQuantity, Fruit freeFruit, int freeQuantity, String description) {
        this.buyFruit = buyFruit;
        this.buyQuantity = buyQuantity;
        this.freeFruit = freeFruit;
        this.freeQuantity = freeQuantity;
        this.description = description;
    }

    @Override
    public double apply(ShoppingBasket basket) {
        long bought = basket.getItems().stream().filter(i -> i == buyFruit).count();
        long freeItems = (bought / buyQuantity) * freeQuantity;

        // find number of freeFruit in basket
        long freeInBasket = basket.getItems().stream().filter(i -> i == freeFruit).count();
        long applicableFree = Math.min(freeItems, freeInBasket);

        return applicableFree * freeFruit.getPrice();
    }

    @Override
    public boolean appliesTo(Fruit fruit) {
        return fruit == buyFruit || fruit == freeFruit;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

