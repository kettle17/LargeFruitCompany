package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Item> basketInv;

    public ShoppingBasket() {
        this.basketInv = new ArrayList<Item>(5);
    }

    public void addToBasket(Item item){
        this.basketInv.add(item);
    }

    public void removeFromBasket(Item item){
        this.basketInv.remove(item);
    }

    public int getSize(){
        return this.basketInv.size();
    }

    public double getBasketSum(){
        double total = 0.0;
        for (Item i : basketInv){
            total += i.getPrice();
        }
        return total;
    }

    public String seeBasketItems(){
        String stringItems = "";
        for (Item i : basketInv){
            stringItems += i.getName() + " ";
        }
        stringItems = stringItems.substring(0, stringItems.length() - 1);

        System.out.println(stringItems);
        return stringItems;
    }
}
