package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    private final String FIRST_FEN = "(//a[contains(@class, 'product-card__title') and contains(., 'Фен')])[1]";
    private final String AIRPODS = "(//a[contains(@class, 'product-card__title') and contains(., 'AirPods 3')])[1]";
    private final String DELIVERY_AND_PAYMENT = "//h2[@class='sp-page-title sp-h2 page-header']";
    //Web Elements
    public WebElement firstFen() {
        return visibilityOfElementByXpath(FIRST_FEN);
    }
    public WebElement airPods() {
        return visibilityOfElementByXpath(AIRPODS);
    }
    public WebElement titleDeliveryAndPayment(){
        return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT);
    }
    //Actions with WebElements
    public String getNameFen() {
        return firstFen().getText();
    }
    public String getNameAirPods() {
        return airPods().getText();
    }
    public String getTitleDeliveryAndPayment(){
      return titleDeliveryAndPayment().getText();
    }
    public void clickAirpods(){
        airPods().click();
    }
}