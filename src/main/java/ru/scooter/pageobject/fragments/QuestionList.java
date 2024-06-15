package ru.scooter.pageobject.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.scooter.pageobject.base.BasePage;

public class QuestionList extends BasePage {
    public QuestionList(WebDriver driver) {
        super(driver);
    }

    private final By questionButton = By.className("accordion__item");
    private final By questionText = By.className("accordion__button");
    private final By answerText = By.className("accordion__panel");

    public QuestionList clickOnQuestionButton(int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(questionButton).get(index));
        driver.findElements(questionButton).get(index).click();
        return this;
    }

    public String getTextQuestion(int index) {
        return driver.findElements(questionText).get(index).getText();
    }

    public String getTextAnswer(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(answerText).get(index)));
        return driver.findElements(answerText).get(index).getText();
    }
}

