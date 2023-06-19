package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentFormPage {
    WebDriver driver;
    private String paymentAmountInHeaderLocatorByXpath = "//p[@class='header__payment-amount']";
    private String phoneNumberInfoLocatorByXpath = "//p[@class='header__payment-info']";
    private String paymentAmountOnButtonLocatorByXpath = "//*[@class='colored disabled ng-star-inserted']";

    public PaymentFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextOfPaymentAmountInHeader() {
        String messageOfPaymentAmountInHeader =
                driver.findElement(By.xpath(paymentAmountInHeaderLocatorByXpath))
                        .getText();
       return messageOfPaymentAmountInHeader;
    }

    public String getTextOfPaymentAmountOnButton() {
        String messageOfPaymentAmountOnButton =
                driver.findElement(By.xpath(paymentAmountOnButtonLocatorByXpath))
                        .getAttribute("innerText");
        return messageOfPaymentAmountOnButton;
    }

    public String getTextPhoneNumber() {
        String messageOfPhoneNumber =
                driver.findElement(By.xpath(phoneNumberInfoLocatorByXpath))
                        .getText();
        return messageOfPhoneNumber;
    }
}