package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver webDriver;
    private final By orderButtonLocator = By.xpath(".//div[contains(@class,'Header')]/button[text()='Заказать']");// верхняя кнопка заказть
    private final By lowerOrderButtonLocator = By.xpath(".//div[contains(@class,'Home')]/button[text()='Заказать']");// нижняя кнопка заказть
    private final By cookiesButtonLocator = By.xpath(".//button[text()='да все привыкли']");// Кнопка куки
    private final String questionLocator = "accordion__heading-%s"; // Вопрос на главной странице
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";//Ответ на главной странице
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clicOrderButton1() { // клик по верхней кнопке Заказать
        WebElement orderStatusButton = webDriver.findElement(orderButtonLocator);
        orderStatusButton.click();
    }

    public void clicOrderButton2() { // клик по нижней кнопке Заказать
        WebElement orderStatusButton2 = webDriver.findElement(lowerOrderButtonLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", orderStatusButton2); // скрол до нижней кнопки Заказать
        orderStatusButton2.click();
    }
    public void closeCookiesWindow() { // клик по кнопке Да все привыкли
        webDriver.findElement(cookiesButtonLocator).click();
    }
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);// скрипт передает значение первого аргумента для сролла
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public boolean checkAnswer(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }
}