package ru.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.scooter.base.BaseTest;
import ru.scooter.pageobject.fragments.Header;
import ru.scooter.pageobject.page.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryDate;
    private final String rentTime;
    private final String color;
    private final String courierComment;

    public OrderTest(String name, String lastName, String address, String metro, String phone, String deliveryDate, String rentTime, String color, String courierComment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentTime = rentTime;
        this.color = color;
        this.courierComment = courierComment;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"Имя", "Фамилия", "Адрес", "Преображенская площадь", "+72453456464", "23.02.2024", "трое суток", "чёрный жемчуг", "Комментарий"},
                {"ИмяДва", "ФамилияДва", "АдресДва", "Речной вокзал", "34559876464", "15.02.2024", "семеро суток", "серая безысходность", "КомментарийДва"}
        };
    }

    @Test
    public void orderTestFirstButton() {
        boolean isOrderConfirmedDisplayed = new Header(driver)
                .clickOnHeaderOrderButton()
                .fillOrderFormFirst(name, lastName, address, metro, phone)
                .clickOnNextButton()
                .fillOrderFormSecond(deliveryDate, rentTime, color, courierComment)
                .clickOnOrderButton()
                .orderConfirmation()
                .isOrderModalConfirmed();
        assertTrue(isOrderConfirmedDisplayed);
    }

    @Test
    public void orderTestSecondButton() {
        boolean isOrderConfirmedDisplayed = new MainPage(driver)
                .clickOnMainPageOrderButton()
                .fillOrderFormFirst(name, lastName, address, metro, phone)
                .clickOnNextButton()
                .fillOrderFormSecond(deliveryDate, rentTime, color, courierComment)
                .clickOnOrderButton()
                .orderConfirmation()
                .isOrderModalConfirmed();
        assertTrue(isOrderConfirmedDisplayed);
    }
}
