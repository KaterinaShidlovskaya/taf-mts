package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    private String baseUrl = "https://www.mts.by/";
    private String buttonCookieCloseByXpath = "//button[@class='cookie__close']";
    private String inputPhoneNumberLocatorByID = "connection-phone";
    private String inputSumOfPaymentLocatorByID = "connection-sum";
    private String inputEmailLocatorByID = "connection-email";
    private String buttonContinueLocatorByXpath = "//*[@id='pay-connection']/button";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        driver.get(baseUrl);
        return this;
    }

    public HomePage clickButtonCookieClose() {
        WebElement buttonCookieCloseElement = driver
                .findElement(By.xpath(buttonCookieCloseByXpath));
        buttonCookieCloseElement.click();
        return this;
    }

    public HomePage inputPhoneNumber(String phoneNumber) {
        WebElement phoneNumberElement = driver
                .findElement(By.id(inputPhoneNumberLocatorByID));
        phoneNumberElement.sendKeys(phoneNumber);
        return this;
    }

    public HomePage inputSumOfPayment(String sumOfPayment) {
        WebElement sumOfPaymentElement = driver
                .findElement(By.id(inputSumOfPaymentLocatorByID));
        sumOfPaymentElement.sendKeys(sumOfPayment);
        return this;
    }

    public HomePage inputEmailAddress(String email) {
        WebElement emailAddressElement = driver
                .findElement(By.id(inputEmailLocatorByID));
        emailAddressElement.sendKeys(email);
        return this;
    }

    public void clickButtonSubmit() {
        WebElement buttonSubmit = driver
                .findElement(By.xpath(buttonContinueLocatorByXpath));
        buttonSubmit.click();
    }
}