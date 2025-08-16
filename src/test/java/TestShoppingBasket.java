import org.example.ShoppingBasket;
import org.example.Fruit;
import org.example.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestShoppingBasket {

    @Test
    @DisplayName("Test to add item to basket.")

    void testAddItemToBasket() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = new Fruit("Apple", 0.50);

        basket.addToBasket(apple);

        assertEquals(1,basket.getSize());
    }


    @Test
    @DisplayName("Test to see what items are in basket.")
    void testSeeBasket() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = new Fruit("Apple", 0.50);
        Fruit banana = new Fruit("Banana", 0.70);

        basket.addToBasket(apple);
        basket.addToBasket(banana);

        assertEquals("Apple Banana",basket.seeBasketItems());
    }

    @Test
    @DisplayName("Remove items from basket.")
    void testRemoveItemFromBasket() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = new Fruit("Apple", 0.50);
        Fruit banana = new Fruit("Banana", 0.70);

        basket.addToBasket(apple);
        basket.addToBasket(banana);
        basket.removeFromBasket(apple);

        assertEquals("Banana",basket.seeBasketItems());
    }

    @Test
    @DisplayName("Get sum of all items in basket.")
    void testGetBasketSum() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = new Fruit("Apple", 0.50);
        Fruit banana = new Fruit("Banana", 0.70);

        basket.addToBasket(apple);
        basket.addToBasket(banana);

        assertEquals(1.20,basket.getBasketSum());

        Fruit pear = new Fruit("Pear", 0.40);
        basket.addToBasket(pear);

        assertEquals(1.60,basket.getBasketSum());
    }
}