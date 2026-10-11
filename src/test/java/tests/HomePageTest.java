package tests;

import bassesClass.Testinit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import static java.lang.Thread.sleep;

public class HomePageTest extends Testinit {

    public String alloUrl = "https://allo.ua/ru/";

    @Test
    public void checkAlloLogo() {

        HomePage homePage = new HomePage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alooLogo().isDisplayed());

    }


    @Test
    public void checkAlloSearch()  {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys("Фен");
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstFen().getText().contains("Фен"));

    }

    @Test
    public void checkAlloSearchAirpod3()  {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);
        Assert.assertTrue(homePage.alooLogo().isDisplayed());

        homePage.searchField().sendKeys("AirPods 3");
        homePage.searchButton().click();


        WebElement airPods = searchResultPage.airPods();
        String productName = airPods.getText();

        Assert.assertTrue(productName.contains("AirPods 3"));
        airPods.click();

        Assert.assertEquals(searchResultPage.productTitle().getText(), productName);

    }
    @Test
    public void checkZamovlennia()  {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.buyersButton().click();

        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());
        Assert.assertTrue(homePage.deliveryAndPayment().isDisplayed());
        homePage.deliveryAndPayment().click();


        WebElement titleDeliveryAndPayment = searchResultPage.titleDeliveryAndPayment();
        String Deliverytext = titleDeliveryAndPayment.getText();
        Assert.assertTrue(Deliverytext.contains("Доставка и оплата"));



        WebElement proceedToCheckout = searchResultPage.proceedToCheckout();
        Assert.assertTrue(proceedToCheckout.isDisplayed());
        Assert.assertEquals(proceedToCheckout.getText().trim(), "Как оформить заказ?");

    }
}


