package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    private final String FIRST_FEN = "(//a[contains(@class, 'product-card__title') and contains(., 'Фен')])[1]";
    private final String AIRPODS = "(//a[contains(@class, 'product-card__title') and contains(., 'AirPods 3')])[1]";
    private final String PRODUCT_TITLE = "//h1[@class='p-view__header-title']";
    private final String DELIVERY_AND_PAYMENT = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String PROCEED_TO_CHECKOUT = "//button[@id='defaultOpenDesc' and contains(@onclick, 'Buy')]";

    public WebElement firstFen() {
        return visibilityOfElementByXpath(FIRST_FEN);
    }

    public WebElement airPods() {
        return visibilityOfElementByXpath(AIRPODS);
    }

    public WebElement productTitle(){
        return visibilityOfElementByXpath(PRODUCT_TITLE);
    }

    public WebElement titleDeliveryAndPayment(){
        return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT);
    }

    public WebElement proceedToCheckout() {
        return visibilityOfElementByXpath(PROCEED_TO_CHECKOUT);
    }
}