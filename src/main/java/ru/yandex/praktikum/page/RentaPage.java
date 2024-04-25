package ru.yandex.praktikum.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


import java.util.Date;

public class RentaPage {
    private final WebDriver webDriver;
    private final By dateInputLocator = By.xpath(".//*[@placeholder='* Когда привезти самокат']"); //Кнопка для введения даты
    private final By rentPeriodInputLocator=By.xpath(".//*[text()='* Срок аренды']");//Кнопка Срок аренды
    // private final By rentPeriodMenuItemLocator=By.xpath(".//div[text()='двое суток']");//Кнопка выбора срока аренды
    private final By orderButtonLocator=By.xpath(".//div[contains(@class,'Button')]/button[text()='Заказать']");//Кнопка Заказть
    private final By yesButtonLocator=By.xpath(".//div[contains(@class,'Button')]/button[text()='Да']");//Кнопка подтверждения заказа
    private final By issuedOrder = By.xpath(".//*[@class ='Order_ModalHeader__3FFaJ']");//Проверка текста оформленного заказа
    public RentaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    };


    public void rentaInfo (String dateNumer, String filleDate) {
        WebElement dateInput = webDriver.findElement(dateInputLocator);
        dateInput.sendKeys(dateNumer, Keys.ENTER);

        WebElement rentPeriodInput = webDriver.findElement(rentPeriodInputLocator);
        rentPeriodInput.click();
        webDriver.findElement(By.xpath(".//div[text()='" + filleDate  + "']")).click();
    }
    //кнопка заказать
    public void clicOrderButton(){
        WebElement orderButton = webDriver.findElement(orderButtonLocator);
        orderButton.click();
    }
    public void clickYesButton(){ //Уточняющее окно
        WebElement yesButton = webDriver.findElement(yesButtonLocator);
        yesButton.click();
    }
    public boolean issuedOrderText() {
        return webDriver.findElement(issuedOrder).isDisplayed();
    }

}
