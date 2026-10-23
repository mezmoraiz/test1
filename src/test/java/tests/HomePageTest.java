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
    public void checkAlloSearch() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys("Фен");
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstFen().getText().contains("Фен"));
    }

    @Test
    public void checkAlloSearchAirpod3() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);
        Assert.assertTrue(homePage.alooLogo().isDisplayed());

        homePage.searchField().sendKeys("AirPods 3");
        homePage.searchButton().click();

        String productName = searchResultPage.airPods().getText();

        Assert.assertTrue(productName.contains("AirPods 3"));
        searchResultPage.airPods().click();

        Assert.assertEquals(searchResultPage.productTitle().getText(), productName);
    }

    @Test
    public void checkZamovlennia() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.buyersButton().click();

        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());
        Assert.assertTrue(homePage.deliveryAndPayment().isDisplayed());
        homePage.deliveryAndPayment().click();

        String Deliverytext = searchResultPage.titleDeliveryAndPayment().getText();
        Assert.assertTrue(Deliverytext.contains("Доставка и оплата"));

        Assert.assertTrue(searchResultPage.proceedToCheckout().isDisplayed());
        Assert.assertEquals(searchResultPage.proceedToCheckout().getText().trim(), "Как оформить заказ?");
    }

    @Test
    public void resultSearchField() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        int expectedSizeProducts = 45;
        String expectedNameTV = "Телевизор Samsung";

        openUrl(alloUrl);
        homePage.searchField().sendKeys("Телевізор Samsung");
        homePage.searchButton().click();
        Assert.assertTrue(searchResultPage.viewModelButton().isDisplayed());
        int size_Products = searchResultPage.names_searchedProduct().size();

        Assert.assertEquals(size_Products, expectedSizeProducts);

        for (WebElement element : searchResultPage.names_searchedProduct()) {
            Assert.assertTrue(element.getText().contains(expectedNameTV));
        }

    }

    @Test
    public void resultSearchField1() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        int expectedScoreComments = 60;

        openUrl(alloUrl);
        homePage.searchField().sendKeys("Телевізор Samsung");
        homePage.searchButton().click();
        Assert.assertTrue(searchResultPage.viewModelButton().isDisplayed());

        int size_Comments = searchResultPage.score_Comments_Product().size();
        Assert.assertEquals(size_Comments, expectedScoreComments);

        for (WebElement element : searchResultPage.score_Comments_Product()) {
            String numbersComments = element.getText();

            String onlyDigits = numbersComments.replaceAll("[^0-9]", "");

            if (!onlyDigits.isEmpty()) {
                int number = Integer.parseInt(onlyDigits);
                if (number > 27) {
                    System.out.println("Товар має коментарів: " + number);
                }
            }
        }
    }
}






