package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ALLO_LOGO = "//a[@class='v-logo']";
    private final String SEARCH_FIELD = "//input[@id='search-form__input']";
    private final String SEARCH_BUTTON = "//button[@class='search-form__submit-button']";
    private final String BUYERS_BUTTON = "//a[contains(@class, 'mh-button--open')]";
    private final String DROP_DOWN_MENU = "//div[@class='mh-button__dropdown']";
    private final String DELIVERY_AND_PAYMENT = "//a[.//span[normalize-space()='Доставка и оплата']]";
    public WebElement alooLogo() {
        return visibilityOfElementByXpath(ALLO_LOGO);
    }
    public WebElement searchField() {
        return visibilityOfElementByXpath(SEARCH_FIELD);
    }
    public WebElement searchButton() {
        return visibilityOfElementByXpath(SEARCH_BUTTON);
    }
    public WebElement buyersButton() {
        return visibilityOfElementByXpath(BUYERS_BUTTON);
    }
    public WebElement dropDownMenu() {
        return visibilityOfElementByXpath(DROP_DOWN_MENU);
    }
    public WebElement deliveryAndPayment(){
        return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT);
    }
}