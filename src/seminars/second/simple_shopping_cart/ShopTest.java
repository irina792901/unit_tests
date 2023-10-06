package seminars.second.simple_shopping_cart;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ShopTest {

    // Создаем набор продуктов для магазина:
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        // Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }

        // тоже самое
        // Product product = new Product(1,"bacon", 170.00d, 10);
        // products.add(product);
        return products;
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private Shop shop;
    private Cart cart;

    @BeforeEach
    void setup() {
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }


/*
            ID | Название  | Цена, р. | Кол-во в магазине, шт.
            1  | bacon     | 170.0    | 10
            2  | beef      | 250.0    | 10
            3  | ham       | 200.0    | 10
            4  | salmon    | 150.0    | 10
            5  | carrot    | 15.0     | 10
            6  | potato    | 30.0     | 10
            7  | onion     | 20.0     | 10
            8  | apple     | 59.0     | 70
            9  | melon     | 88.0     | 13
            10 | rice      | 100.0    | 30
            11 | eggs      | 80.0     | 40
            12 | yogurt    | 55.0     | 60
*/

    /**
     * 2.1. Разработайте модульный тест для проверки, что общая стоимость
     * корзины с разными товарами корректно рассчитывается
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartIsCorrectCalculated() {
        // Arrange (Подготовка)
        // Act (Выполнение)
        cart.addProductToCartByID(1); // 170 +
        cart.addProductToCartByID(2); // 250 +
        cart.addProductToCartByID(3); // 200 = 620
        // Assert (Проверка утверждения)
        assertThat(cart.getTotalPrice()).isEqualTo(620);
    }

    /**
     * 2.2. Создайте модульный тест для проверки, что общая стоимость
     * корзины с множественными экземплярами одного и того же продукта корректно рассчитывается.
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */


    @Test
    // Вариант Виктора Белоуса
    void priceCartProductsSameTypeIsCorrectCalculated() {
// Arrange
        int productId = 1;
        int quantity = 3;
// Act
// Add the product to the cart multiple times
        for (int i = 0; i < quantity; i++) {
            cart.addProductToCartByID(productId);
        }
        double expectedTotalPrice = cart.getProductByProductID(productId).getPrice() * quantity;
        double actualTotalPrice = cart.getTotalPrice();
// Assert
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    void priceCartProductsSameTypeIsCorrectCalculated2() {
        // Arrange

        // Act
        cart.addProductToCartByID(1); // 170 +
        cart.addProductToCartByID(1); // 170 +
        cart.addProductToCartByID(1); // 170 +
        cart.addProductToCartByID(2); // 250 +
        cart.addProductToCartByID(2); // 250 +
        cart.addProductToCartByID(2); // 250 =
        // Assert
        org.assertj.core.api.Assertions.assertThat(cart.getTotalPrice()).isEqualTo(1260);
    }


    /**
     * 2.3. Напишите модульный тест для проверки, что при удалении
     * товара из корзины происходит перерасчет общей стоимости корзины.
     * <br><b>Ожидаемый результат:</b>
     * Вызывается метод пересчета стоимости корзины, стоимость корзины меняется
     */
    @Test
    void whenChangingCartCostRecalculationIsCalled() {
        // Arrange

        // Act
        cart.addProductToCartByID(1); // 170 +
        cart.addProductToCartByID(2); // 250 +
        cart.addProductToCartByID(3); // 200 +
        cart.addProductToCartByID(2); // 250 = 870
        //assertThat(cart.getTotalPrice()).isEqualTo(870);
        cart.removeProductByID(2); // 870 - 250 = 620
        // Assert
        assertThat(cart.getTotalPrice()).isEqualTo(620);
    }

    @Test
    void quantityProductsStoreChanging() {
// Arrange (Подготовка)
       int quantity = 5;
// Act (Выполнение)
        for (int i = 0; i < quantity; i++) {
            cart.addProductToCartByID(1);
        }
// Assert (Проверка утверждения)
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(5);
    }

//    @Test
//    void quantityProductsStoreChanging() {
//        // Arrange
//
//        // Act
//        cart.addProductToCartByID(1); // 1
//        cart.addProductToCartByID(1); // 2
//        cart.addProductToCartByID(1); // 3
//        cart.addProductToCartByID(1); // 4
//        cart.addProductToCartByID(1); // 5
//        // Assert
//        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(5); // index = id - 1
//    }


    /**
     * 2.5. Создайте модульный тест для проверки, что если пользователь забирает все имеющиеся продукты о
     * пределенного типа из магазина, эти продукты больше не доступны для заказа.
     * <br><b>Ожидаемый результат:</b>
     * Больше такой продукт заказать нельзя, он не появляется на полке
     */

    @Test
    void lastProductsDisappearFromStore() {
// Arrange (Подготовка)
       int quantity = shop.getProductsShop().get(0).getQuantity();
// Act (Выполнение)
        for (int i = 0; i < quantity; i++) {
            cart.addProductToCartByID(1);
        }
        System.setOut(new PrintStream(output));
        cart.addProductToCartByID(1);

// Assert (Проверка утверждения)
        assertThat(output.toString().trim()).isEqualTo("Этого товара нет в наличии");
    }

//    @Test
//    void lastProductsDisappearFromStore() {
//        // Arrange
//
//        // Act
//        cart.addProductToCartByID(1); // 1
//        cart.addProductToCartByID(1); // 2
//        cart.addProductToCartByID(1); // 3
//        cart.addProductToCartByID(1); // 4
//        cart.addProductToCartByID(1); // 5
//        cart.addProductToCartByID(1); // 6
//        cart.addProductToCartByID(1); // 7
//        cart.addProductToCartByID(1); // 8
//        cart.addProductToCartByID(1); // 9
//        cart.addProductToCartByID(1); // 10
//
//        cart.addProductToCartByID(1); // 11  0_0
//        // cart.addProductToCartByID(1); // 12
//
//        // Assert
//        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(10);
//        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(0);
//        // 2
//        //System.setOut(new PrintStream(output));
//        //cart.addProductToCartByID(1);
//        //assertEquals("Этого товара нет в наличии", output.toString().trim());
//        //System.setOut(null);
//    }
    /**
     * 2.6. Напишите модульный тест для проверки, что при удалении товара из корзины,
     * общее количество этого товара в магазине соответствующим образом увеличивается.
     * <br><b>Ожидаемый результат:</b>
     * Количество продуктов этого типа на складе увеличивается на число удаленных из корзины продуктов
     */
    @Test
    void deletedProductIsReturnedToShop() {
        // Arrange

        // Act
        cart.addProductToCartByID(1); // 1
        cart.addProductToCartByID(1); // 2
        cart.addProductToCartByID(1); // 3
        cart.addProductToCartByID(1); // 4
        cart.addProductToCartByID(1); // 5
        cart.addProductToCartByID(1); // 6
        // Сейчас в корзине должно быть 6 продуктов с id 1(0), в магазине - 4
        //assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(6); // index = id - 1
        //assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(4); // index = id - 1
        cart.removeProductByID(1);
        cart.removeProductByID(1);
        cart.removeProductByID(1); // корзина - 3, магазин - 7
        // Assert
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(3); // index = id - 1
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(7); // index = id - 1
    }


    /**
     * 2.7. Разработайте параметризованный модульный тест для проверки,
     * что при вводе неверного идентификатора товара генерируется исключение RuntimeException.
     * <br><b>Ожидаемый результат:</b>
     * Исключение типа RuntimeException и сообщение Не найден продукт с id
     * *Сделать тест параметризованным
     */
    @ParameterizedTest
    @ValueSource(ints = {-100, 100})
    void incorrectProductSelectionCausesException(int num) {
// Arrange (Подготовка)

// Act (Выполнение)

// Assert (Проверка утверждения)
        assertThrows(RuntimeException.class, () -> cart.addProductToCartByID(num));
    }

//    @ParameterizedTest
//    @ValueSource(ints = {-100, 100})
//    void incorrectProductSelectionCausesException(int i) {
//
//        // Сначала показать пример в CalculatorTest - expectedIllegalStateExpressionToo - 117
//
//        // Arrange
//        int id = i;
//        // Act
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//            cart.addProductToCartByID(id);
//        });
//        // Assert
//        String expectedMessage = "Не найден продукт с id: " + id;
//        String actualMessage = exception.getMessage();
//
//        assertEquals(expectedMessage, actualMessage);
//    }


    /**
     * 2.8. Создайте модульный тест для проверки, что при попытке удалить из корзины больше товаров,
     * чем там есть, генерируется исключение RuntimeException.удаляет продукты до того, как их добавить)
     * <br><b>Ожидаемый результат:</b> Исключение типа NoSuchFieldError и сообщение "В корзине не найден продукт с id"
     */
    @Test
    void incorrectProductRemoveCausesException() {
// Arrange (Подготовка)
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        int quantity = 3;

// Act (Выполнение)
        for (int i = 0; i < quantity; i++) {
            cart.addProductToCartByID(1);
        }
        for (int i = 0; i < quantity; i++) {
            cart.removeProductByID(1);
        }

// Assert (Проверка утверждения)
        assertThrows(NoSuchFieldError.class, () -> cart.removeProductByID(1));
    }

    /**
     * 2.9. Нужно восстановить тест
     */
    // boolean Сломанный-Тест() {
    //          // Assert (Проверка утверждения)
    //          assertThat(cart.getTotalPrice()).isEqualTo(cart.getTotalPrice());
    //          // Act (Выполнение)
    //          cart.addProductToCartByID(2); // 250
    //          cart.addProductToCartByID(2); // 250
    //          // Arrange (Подготовка)
    //          Shop shop = new Shop(getStoreItems());
    //          Cart cart = new Cart(shop);
    //      }
    @Test
    void incorrectProductRemoveCausesException2() {
// Arrange (Подготовка)
        int quantity = 3;
// Act (Выполнение)
        for (int i = 0; i < quantity; i++) {
            cart.addProductToCartByID(1);
        }
        for (int i = 0; i < quantity; i++) {
            cart.removeProductByID(1);
        }

// Assert (Проверка утверждения)
        assertThrows(NoSuchFieldError.class, () -> cart.removeProductByID(1));
    }

    @Test
    void testSUM() {
        // Arrange (Подготовка)

        // Act (Выполнение)
        cart.addProductToCartByID(2); // 250
        cart.addProductToCartByID(2); // 250
        // Assert (Проверка утверждения)
        assertThat(cart.getTotalPrice()).isEqualTo(500);
    }




    /**
     * 2.10. Нужно оптимизировать тестовый метод, согласно следующим условиям:
     * <br> 1. Отображаемое имя - "Advanced test for calculating TotalPrice"
     * <br> 2. Тест повторяется 10 раз
     * <br> 3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
     * <br> 4. После проверки работоспособности теста, его нужно выключить
     */
    @DisplayName("Advanced test for calculating TotalPrice")
    @RepeatedTest(10)
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    @Disabled
    void priceCartIsCorrectCalculatedExt() {
// Arrange (Подготовка)
//        Shop shop = new Shop(getStoreItems());
//        Cart cart = new Cart(shop);

// Act (Выполнение)
        cart.addProductToCartByID(1);
        cart.removeProductByID(1);

// Assert (Проверка утверждения)
        assertThat(cart.getTotalPrice()).isEqualTo(0);
    }
}