import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.StepsHomePage;

import java.time.Duration;

public class MtsTests extends BaseTests {
    StepsHomePage stepsHomePage;

    String iframeBePaidXpath = "//iframe[@class='bepaid-iframe']";

    @Test    //иногда тест падает, т.к. сгенерированный номер телефона не принадлежит МТС
    public void testVerifyInputDataOnlineToppingUpForm() {
        stepsHomePage = new StepsHomePage(driver);
        stepsHomePage.openHomePageFillPaymentFormAndClickSubmit();

        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement iframeBePaidElement = webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated
                        (By.xpath(iframeBePaidXpath)));

        driver.switchTo().frame(iframeBePaidElement);

        stepsHomePage.assertEqualsTextsAmountOfPaymentInHeader();
        stepsHomePage.assertEqualsTextsPhoneNumber();
        stepsHomePage.assertEqualsTextsAmountOfPaymentOnButton();
    }
}
