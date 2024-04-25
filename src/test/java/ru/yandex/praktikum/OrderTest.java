package ru.yandex.praktikum;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentaPage;
import ru.yandex.praktikum.page.WebDriverFactory;

@RunWith(Parameterized.class)
public class OrderTest {
    private static final String BROWSER="chrome";// выбор драйвера
    private WebDriver webDriver;
    private String name;
    private String lastname;
    private String address;
    private String subwayTitle;
    private String phone;

    public OrderTest(String name, String lastname, String address, String subwayTitle, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.subwayTitle = subwayTitle;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Ольга", "Сорокина", "Цветной б-р 14", "Сокольники", "89272135977"},
                {"Алексей", "Шапеев", "Орджаникидзе б-р 15", "Красносельская", "89365984571"},
        };
    }

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void createOrder1() { // оформление Заказа по верзней кнопке
        MainPage mainPage=new MainPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.clicOrderButton1();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCusomerInfo(name, lastname, address, subwayTitle, phone);
        orderPage.clickNextButton();

        RentaPage rentaPage = new RentaPage(webDriver);
        rentaPage.rentaInfo("01.01.2025","двое суток");
        rentaPage.clicOrderButton();
        rentaPage.clickYesButton();
        Assert.assertTrue(rentaPage.issuedOrderText());// в chrome не появляется окно оформления Заказа
    }

    @Test
    public void createOrder2() { // оформление Заказа по нижней кнопке
        MainPage mainPage=new MainPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.clicOrderButton2();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCusomerInfo(name, lastname, address, subwayTitle, phone);
        orderPage.clickNextButton();

        RentaPage rentaPage = new RentaPage(webDriver);
        rentaPage.rentaInfo("02.02.2025","трое суток");
        rentaPage.clicOrderButton();
        rentaPage.clickYesButton();
        Assert.assertTrue(rentaPage.issuedOrderText());// в chrome не появляется окно оформления Заказа
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}


