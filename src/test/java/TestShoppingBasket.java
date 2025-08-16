import org.example.ShoppingBasket;
import org.example.Fruit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestShoppingBasket {

    @Test
    @DisplayName("Test to add item to basket.")
    void testAddItemToBasket() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = Fruit.APPLE;

        basket.addToBasket(apple);

        assertEquals(1, basket.getSize());
    }

    @Test
    @DisplayName("Test to see what items are in basket.")
    void testSeeBasket() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = Fruit.APPLE;
        Fruit banana = Fruit.BANANA;

        basket.addToBasket(apple);
        basket.addToBasket(banana);

        assertEquals("Apple Banana", basket.seeBasketItems());
    }

    @Test
    @DisplayName("Remove items from basket.")
    void testRemoveItemFromBasket() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = Fruit.APPLE;
        Fruit banana = Fruit.BANANA;

        basket.addToBasket(apple);
        basket.addToBasket(banana);
        basket.removeFromBasket(apple);

        assertEquals("Banana", basket.seeBasketItems());
    }

    @Test
    @DisplayName("Get sum of all items in basket.")
    void testGetBasketSum() {
        ShoppingBasket basket = new ShoppingBasket();

        Fruit apple = Fruit.APPLE;
        Fruit banana = Fruit.BANANA;

        basket.addToBasket(apple);
        basket.addToBasket(banana);

        assertEquals(apple.getPrice() + banana.getPrice(), basket.getBasketSum(), 0.001);

        Fruit cherry = Fruit.CHERRY;
        basket.addToBasket(cherry);

        assertEquals(apple.getPrice() + banana.getPrice() + cherry.getPrice(), basket.getBasketSum(), 0.001);
    }
}
