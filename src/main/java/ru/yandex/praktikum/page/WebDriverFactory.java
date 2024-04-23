package ru.yandex.praktikum.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver(String browserType){
        if (browserType.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else {
            return new ChromeDriver();
        }
    }
}
