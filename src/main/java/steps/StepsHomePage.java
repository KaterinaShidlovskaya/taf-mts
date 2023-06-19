package steps;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PaymentFormPage;
import utils.Util;


public class StepsHomePage {
    HomePage homePage;
    PaymentFormPage paymentFormPage;
    private String userAmountOfPayment = "10.00";
    private String userPhoneNumber = Util.generatePhoneNumber();
    private String userEmail = Util.generateEmail();

    public StepsHomePage(WebDriver driver) {
        homePage = new HomePage(driver);
        paymentFormPage = new PaymentFormPage(driver);
    }

    public void openHomePageFillPaymentFormAndClickSubmit() {
        homePage.getHomePage()
                .clickButtonCookieClose()
                .inputPhoneNumber(userPhoneNumber)
                .inputSumOfPayment(userAmountOfPayment)
                .inputEmailAddress(userEmail)
                .clickButtonSubmit();
    }

    public void assertEqualsTextsAmountOfPaymentInHeader() {
        String expectedAmountOfPaymentInHeader = userAmountOfPayment + " BYN";
        Assertions.assertEquals
                (expectedAmountOfPaymentInHeader, paymentFormPage.getTextOfPaymentAmountInHeader());
    }

    public void assertEqualsTextsPhoneNumber() {
        String expectedTextOfPhoneNumber = "Оплата: Услуги связи Номер:375" + userPhoneNumber;
        Assertions.assertEquals
                (expectedTextOfPhoneNumber, paymentFormPage.getTextPhoneNumber());
    }

    public void assertEqualsTextsAmountOfPaymentOnButton() {
        String expectedMessageOnButton = "Оплатить " + userAmountOfPayment + " BYN";
        Assertions.assertEquals
                (expectedMessageOnButton, paymentFormPage.getTextOfPaymentAmountOnButton());
    }
}