package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAndPaymentPage extends BasePage {
    public DeliveryAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final String PROCEED_TO_CHECKOUT = "//button[@id='defaultOpenDesc' and contains(@onclick, 'Buy')]";

    //WebElements
    public WebElement proceedToCheckout() {
        return visibilityOfElementByXpath(PROCEED_TO_CHECKOUT);
    }

    //ActiontsWithElements
    public void proceedToCheckoutDisplayed(){
        proceedToCheckout().isDisplayed();
    }
    public String getProceedToCheckout() {
        return proceedToCheckout().getText();
    }

}
