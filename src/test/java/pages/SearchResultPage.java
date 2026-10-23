package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    private final String FIRST_FEN = "(//a[contains(@class, 'product-card__title') and contains(., 'Фен')])[1]";
    private final String AIRPODS = "(//a[contains(@class, 'product-card__title') and contains(., 'AirPods 3')])[1]";
    private final String PRODUCT_TITLE = "//h1[@class='p-view__header-title']";
    private final String DELIVERY_AND_PAYMENT = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String PROCEED_TO_CHECKOUT = "//button[@id='defaultOpenDesc' and contains(@onclick, 'Buy')]";
    private final String VIEW_MODEL_BUTTON = "//li[@title='Увеличить товары']";
    private final String NAME_SEARCHED_PRODUCT = "//div[@class='product-card__content']/a[@class='product-card__title' and contains(., 'Телевизор Samsung')]";
    private final String SCORE_COMMENTS_PRODUCT = "//span[@class='product-rating__count']";
    private final String VIEW_COMMENTS_BUTTON = "//span[@class='product-rating__text']";


    public WebElement firstFen() {
        return visibilityOfElementByXpath(FIRST_FEN);
    }

    public WebElement airPods() {
        return visibilityOfElementByXpath(AIRPODS);
    }

    public WebElement productTitle(){
        return visibilityOfElementByXpath(PRODUCT_TITLE);
    }

    public List<WebElement> names_searchedProduct(){
       return visibilityElementsByXpath1(NAME_SEARCHED_PRODUCT);
    }

    public List<WebElement> score_Comments_Product(){
        return visibilityElementsByXpath1(SCORE_COMMENTS_PRODUCT);
    }

    public WebElement titleDeliveryAndPayment(){return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT); }

    public WebElement proceedToCheckout() {return visibilityOfElementByXpath(PROCEED_TO_CHECKOUT);}

    public WebElement viewModelButton() {return visibilityOfElementByXpath(VIEW_MODEL_BUTTON);}

    public WebElement viewCommentsButton() {return visibilityOfElementByXpath(VIEW_COMMENTS_BUTTON);}
}
