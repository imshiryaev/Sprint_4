package ru.scooter.pageobject.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.scooter.pageobject.base.BasePage;
import ru.scooter.pageobject.page.OrderPageFirst;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    private final By headerOrderButton = By.className("Button_Button__ra12g");

    public OrderPageFirst clickOnHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return new OrderPageFirst(driver);
    }
}
