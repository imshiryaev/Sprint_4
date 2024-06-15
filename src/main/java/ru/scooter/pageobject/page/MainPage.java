package ru.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.scooter.pageobject.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By mainPageOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public OrderPageFirst clickOnMainPageOrderButton() {
        driver.findElement(mainPageOrderButton).click();
        return new OrderPageFirst(driver);
    }
}
