package seminars.first.hw;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShopTest {
    public static void main(String[] args) {


    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("молоко", 52));
        products.add(new Product("хлеб", 22));
        products.add(new Product("сахар", 60));
        products.add(new Product("яблоки", 50));
        products.add(new Product("красная икра", 458));
        shop.setProducts(products);
        List<Product> gettedProducts = shop.getProducts();

        assertEquals(products.size(), gettedProducts.size());
        assertTrue(gettedProducts.containsAll(products));

        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertEquals(mostExpensiveProduct.getTitle(), "красная икра");
        assertEquals(mostExpensiveProduct.getCost(), 458);

        List<Product> sortedProducts = shop.getSortedListProducts();
        assertEquals(sortedProducts.get(0).getCost(), 22);
        assertEquals(sortedProducts.get(1).getCost(), 50);
        assertEquals(sortedProducts.get(2).getCost(), 52);
        assertEquals(sortedProducts.get(3).getCost(), 60);
        assertEquals(sortedProducts.get(4).getCost(), 458);
    }
}




