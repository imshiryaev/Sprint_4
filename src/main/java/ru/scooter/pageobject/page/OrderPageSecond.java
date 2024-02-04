package ru.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPageSecond extends BasePage {
    public OrderPageSecond(WebDriver driver) {
        super(driver);
    }

    private final By orderInputDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By orderRentRime = By.className("Dropdown-root");
    private final By orderInputCourierComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By orderModalConfirmation = By.className("Order_ModalHeader__3FDaJ");
    private final By orderModalConfirmationButtonYes = By.xpath(".//button[text()='Да']");
    private final By orderModalConfirmed = By.className("Order_Modal__YZ-d3");

    public OrderPageSecond fillOrderInputDeliveryDate(String date) {
        driver.findElement(orderInputDeliveryDate).sendKeys(date);
        driver.findElement(orderInputDeliveryDate).sendKeys(Keys.ENTER);
        return this;
    }

    public void clickOnOrderRentTime() {
        driver.findElement(orderRentRime).click();
    }

    public OrderPageSecond fillOrderRentRime(String period) {
        clickOnOrderRentTime();
        String rentTime = String.format(".//div[@class='Dropdown-menu']//*[text()='%s']", period);
        driver.findElement(By.xpath(rentTime)).click();
        return this;
    }

    public OrderPageSecond fillOrderColor(String color) {
        String rentTime = String.format(".//div[@class='Order_Checkboxes__3lWSI']//*[text()='%s']", color);
        driver.findElement(By.xpath(rentTime)).click();
        return this;
    }

    public void fillOrderInputCourierComment(String comment) {
        driver.findElement(orderInputCourierComment).sendKeys(comment);
    }

    public OrderPageSecond fillOrderFormSecond(String date, String period, String color, String comment) {
        fillOrderInputDeliveryDate(date)
                .fillOrderRentRime(period)
                .fillOrderColor(color)
                .fillOrderInputCourierComment(comment);
        return this;
    }

    public OrderPageSecond clickOnOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPageSecond orderConfirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderModalConfirmation));
        driver.findElement(orderModalConfirmationButtonYes).click();
        return this;
    }

    public boolean isOrderModalConfirmed() {
        return driver.findElement(orderModalConfirmed).isDisplayed();
    }
}
