package ru.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPageQuestionList {

    private final WebDriver driver;

    public MainPageQuestionList(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextAnswer(int index) {
        try {
            By question = By.xpath(".//div[@id='accordion__heading-" + index + "']");
            By answer = By.xpath(".//div[@id='accordion__panel-" + index + "']/p") ;

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question));
            driver.findElement(question).click();
            return driver.findElement(answer).getText();
        }

        catch (Exception e) {
            return null;
        }

    }
}
