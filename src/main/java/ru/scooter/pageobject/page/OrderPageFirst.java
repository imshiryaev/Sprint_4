package ru.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageFirst extends BasePage {
    public OrderPageFirst(WebDriver driver) {
        super(driver);
    }

    private final By orderInputName = By.xpath(".//input[@placeholder='* Имя']");
    private final By orderInputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By orderInputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By orderInputMetro = By.xpath("//input[@placeholder='* Станция метро']");
    private final By orderInputPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderPageFirst fillOrderInputName(String name) {
        driver.findElement(orderInputName).sendKeys(name);
        return this;
    }

    public OrderPageFirst fillOrderInputLastName(String lastName) {
        driver.findElement(orderInputLastName).sendKeys(lastName);
        return this;
    }

    public OrderPageFirst fillOrderInputAddress(String address) {
        driver.findElement(orderInputAddress).sendKeys(address);
        return this;
    }

    public OrderPageFirst fillOrderInputMetro(String metro) {
        driver.findElement(orderInputMetro).click();
        String selectMetro = String.format(".//div[@class='select-search__select']//*[text()='%s']", metro);
        driver.findElement(By.xpath(selectMetro)).click();
        return this;
    }

    public void fillOrderInputPhone(String phone) {
        driver.findElement(orderInputPhone).sendKeys(phone);
    }

    public OrderPageFirst fillOrderFormFirst(String name, String lastName, String address, String metro, String phone) {
        fillOrderInputName(name)
                .fillOrderInputLastName(lastName)
                .fillOrderInputAddress(address)
                .fillOrderInputMetro(metro)
                .fillOrderInputPhone(phone);
        return this;
    }

    public OrderPageSecond clickOnNextButton() {
        driver.findElement(nextButton).click();
        return new OrderPageSecond(driver);
    }
}