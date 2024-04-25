package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver webDriver;
    private final By nameInputLocator = By.xpath(".//*[@placeholder='* Имя']");//Кнопка для введения имени
    private final By lastnameInputLocator = By.xpath(".//*[@placeholder='* Фамилия']");//Кнопка для введения фамилии
    private final By addressInputLocator = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");//Кнопка для введения адреса
    private final By subwayInputLocator = By.xpath(".//*[@placeholder='* Станция метро']");//Кнопка для введения станции метро
    private final By phoneInputLocator = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");//Кнопка для введения телефона
    private final By orderButtonLocator = By.xpath (".//div[contains(@class,'Header')]/button[text()='Заказать']");//Кнопка Заказать
    private final By nextButtonLocator = By.xpath(".//button[text()='Далее']"); //Кнопка Далее

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // Заполняем пользовательскую информацию
    public void fillCusomerInfo(String name,String lastname, String address,String subwayTitle,String phone) {
        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);

        WebElement lastnameInput = webDriver.findElement(lastnameInputLocator);
        lastnameInput.sendKeys(lastname);

        WebElement addressInput = webDriver.findElement(addressInputLocator);
        addressInput.sendKeys(address);

        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.sendKeys(subwayTitle, Keys.DOWN, Keys.ENTER);

        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phone);
    }
    // кнопка Заказать
    public void clicOrderButton(){
        WebElement orderStatusButton = webDriver.findElement(orderButtonLocator);
        orderStatusButton.click();
    }
    // кнопка Далее
    public void clickNextButton(){
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();
    }
}


