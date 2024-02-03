package ru.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;
    protected ChromeOptions options = new ChromeOptions();

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
    }

    private void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    @After
    public void browserQuit() {
        driver.quit();
    }
}
