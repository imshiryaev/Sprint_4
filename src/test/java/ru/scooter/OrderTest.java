package ru.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.scooter.pageobject.fragments.Header;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryDate;
    private final int rentTime;
    private final int color;
    private final String courierComment;

    public OrderTest(String name, String lastName, String address, String metro, String phone, String deliveryDate, int rentTime, int color, String courierComment) {
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
                {"Имя", "Фамилия", "Адрес", "Преображенская площадь", "+72453456464", "23.02.2024", 3, 0, "Комментарий"},
                {"ИмяДва", "ФамилияДва", "АдресДва", "Речной вокзал", "34559876464", "15.02.2024", 2, 1, "КомментарийДва"}
        };
    }

    @Test
    public void orderTest() {
        boolean isOrderConfirmedDisplayed = new Header(driver).clickOnHeaderOrderButton().fillOrderFormOne(name, lastName, address, metro, phone).clickOnNextButton().fillOrderFormTwo(deliveryDate, rentTime, color, courierComment).clickOnOrderButton().orderConfirmation().isOrderModalConfirmed();
        assertTrue(isOrderConfirmedDisplayed);
    }
}
