import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
//    1. Открывает главную страницу Google;
//    2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".;
//    3. В результатах поиска ищет ссылку на официальный сайт Selenium
//            (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
//            результатов поиска.
//            Вороновский Роман https://www.google.com/
//            Соболева Ольга <cite class="tjvcx GvPZzd cHaqb" role="text">https://www.selenium.dev</cite>
//            Вороновский Роман Organic-Subtitle Organic-Subtitle_isOverflow Organic-Subtitle_noWrap Typo Typo_type_greenurl organic__subtitle

    @Test
    public void testOpenSite(){
        WebDriver webDriver=new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement=webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();

        List<WebElement> result = webDriver.findElements(By.cssSelector("div"));

        boolean found=false;
        for (WebElement element : result) {
            if (element.getText().contains("selenium.dev")){
                found=true;
                break;
            }
        }
        Assertions.assertTrue(found);
        webDriver.quit();//закрыть
    }

    @Test
    public void test2() {
// Установка пути к драйверу Chrome
//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\");

// Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

// Открытие страницы https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

// Ввод логина и пароля
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

// Отправка формы авторизации
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.submit();

// Проверка успешной авторизации
        WebElement productsLabel = driver.findElement(By.className("title"));
        String label = productsLabel.getText();
        if (label.equals("Products")) {
            System.out.println("Авторизация прошла успешно. Отображаются товары.");
        } else {
            System.out.println("Ошибка авторизации. Товары не отображаются.");
        }
// Закрытие браузера
        driver.quit();
    }
}


