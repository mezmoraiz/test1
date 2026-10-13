package tests;

import bassesClass.Testinit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeliveryAndPaymentPage;
import pages.GoodsPage;
import pages.HomePage;
import pages.SearchResultsPage;

import static java.lang.Thread.sleep;

public class HomePageTest extends Testinit {

    public String alloUrl = "https://allo.ua/ru/";

    @Test
    public void checkAlloLogo() {
        HomePage homePage = new HomePage(driver);
        homePage.alloLogoDisplayed();
    }


    @Test
    public void checkAlloSearch()  {
        HomePage homePage = new HomePage(driver);
        String fen = "Фен";
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        homePage.searchFieldDisplayed();
        homePage.enterValuesInSearchField(fen);
        homePage.clickSearchButton();
        Assert.assertTrue(searchResultsPage.getNameFen().contains("Фен"));
    }

    @Test
    public void checkAlloSearchAirpod3()  {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        GoodsPage goodsPage = new GoodsPage(driver);
        homePage.alloLogoDisplayed();
        homePage.enterValuesInSearchField("AirPods 3");
        homePage.clickSearchButton();
        String productName = searchResultsPage.getNameAirPods();
        Assert.assertTrue(productName.contains("AirPods 3"));
        searchResultsPage.clickAirpods();
        Assert.assertEquals(goodsPage.getNameproductTitle(), productName);
    }
    @Test
    public void checkZamovlennia()  {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        DeliveryAndPaymentPage deliveryAndPaymentPage = new DeliveryAndPaymentPage(driver);
        homePage.buyersButtonDisplayed();
        homePage.clickBuyersButton();
        homePage.dropDownMenuDisplayed();
        homePage.deliveryAndPaymentDisplayed();
        homePage.clickDeliveryAndPayment();
        Assert.assertTrue(searchResultsPage.getTitleDeliveryAndPayment().contains("Доставка и оплата"));
        deliveryAndPaymentPage.proceedToCheckoutDisplayed();
        Assert.assertEquals(deliveryAndPaymentPage.getProceedToCheckout(), "Как оформить заказ?");
    }
}


