package ru.scooter.pageobject.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.scooter.pageobject.page.BasePage;
import ru.scooter.pageobject.page.OrderPageOne;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    private final By headerOrderButton = By.className("Button_Button__ra12g");

    public OrderPageOne clickOnHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return new OrderPageOne(driver);
    }
}
