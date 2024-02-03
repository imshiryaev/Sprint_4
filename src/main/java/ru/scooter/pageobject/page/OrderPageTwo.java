package ru.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPageTwo extends BasePage {
    public OrderPageTwo(WebDriver driver) {
        super(driver);
    }

    private final By orderInputDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By orderRentRime = By.className("Dropdown-root");
    private final By orderCheckBoxList = By.className("Checkbox_Label__3wxSf");
    private final By orderInputCourierComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By rentTimeList = By.className("Dropdown-option");
    private final By orderModalConfirmation = By.className("Order_ModalHeader__3FDaJ");
    private final By orderModalConfirmationButtonYes = By.xpath(".//button[text()='Да']");
    private final By orderModalConfirmed = By.className("Order_Modal__YZ-d3");

    public OrderPageTwo fillOrderInputDeliveryDate(String date) {
        driver.findElement(orderInputDeliveryDate).sendKeys(date);
        driver.findElement(orderInputDeliveryDate).sendKeys(Keys.ENTER);
        return this;
    }

    public void clickOnOrderRentTime() {
        driver.findElement(orderRentRime).click();
    }

    public OrderPageTwo fillOrderRentRime(int period) {
        clickOnOrderRentTime();
        driver.findElements(rentTimeList).get(period).click();
        return this;
    }

    public OrderPageTwo fillOrderColor(int color) {
        driver.findElements(orderCheckBoxList).get(color).click();
        return this;
    }

    public void fillOrderInputCourierComment(String comment) {
        driver.findElement(orderInputCourierComment).sendKeys(comment);
    }

    public OrderPageTwo fillOrderFormTwo(String date, int period, int color, String comment) {
        fillOrderInputDeliveryDate(date).fillOrderRentRime(period).fillOrderColor(color).fillOrderInputCourierComment(comment);
        return this;
    }

    public OrderPageTwo clickOnOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPageTwo orderConfirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderModalConfirmation));
        driver.findElement(orderModalConfirmationButtonYes).click();
        return this;
    }

    public boolean isOrderModalConfirmed() {
        return driver.findElement(orderModalConfirmed).isDisplayed();
    }
}
