import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTest2 {
    //Виктор Белоус public class SeleniumTest2 {
    public static void main(String[] args) {
// Установка пути к драйверу Chrome
//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\");

// Создание экземпляра WebDriver
        WebDriver driver = new EdgeDriver();

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
        WebElement productsLabel = driver.findElement(By.className("product_label"));
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
