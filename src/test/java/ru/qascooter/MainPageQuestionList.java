package ru.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPageQuestionList {

    private final WebDriver driver;

    public MainPageQuestionList(WebDriver driver) {
        this.driver = driver;
    }

    private final By questionButton = By.className("accordion__item");
    private final By questionText = By.className("accordion__button");
    private final By answerText = By.className("accordion__panel");

    public void clickOnQuestionButton(int index) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionButton));
            driver.findElements(questionButton).get(index).click();
    }

    public String getTextQuestion(int index) {
        return driver.findElements(questionText).get(index).getText();
    }

    public String getTextAnswer(int index){
        return driver.findElements(answerText).get(index).getText();
    }
}
