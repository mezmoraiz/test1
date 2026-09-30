package homePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class HomePageTest {

    @Test
    public void checkAlloLogo() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/ru/");

        sleep(5000);

        WebElement alloLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(alloLogo.isDisplayed());

        driver.quit();
    }


    @Test
    public void checkAlloSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/ru/");

        sleep(5000);

        WebElement alloSearch = driver.findElement(By.id("search-form__input"));

        Assert.assertTrue(alloSearch.isDisplayed());

        alloSearch.sendKeys("Фен");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));

        buttonSearch.click();

        sleep(5000);

        WebElement firstFen = driver.findElement(By.xpath("(//a[contains(@class, 'product-card__title') and contains(., 'Фен')])[1]"));

        Assert.assertTrue(firstFen.getText().contains("Фен"));

        driver.quit();
    }

    @Test
    public void checkAlloSearchAirpod3() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/ru/");

        sleep(5000);

        WebElement alloLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(alloLogo.isDisplayed());

        WebElement alloSearch = driver.findElement(By.id("search-form__input"));

        alloSearch.sendKeys("AirPods 3");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));

        buttonSearch.click();

        sleep(5000);

        WebElement firstAirPods3 = driver.findElement(By.xpath("(//a[contains(@class, 'product-card__title') and contains(., 'AirPods 3')])[1]"));

        String productName = firstAirPods3.getText();

        Assert.assertTrue(productName.contains("AirPods 3"));

        firstAirPods3.click();

        sleep(5000);

        WebElement productTitle = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));

        Assert.assertEquals(productTitle.getText(), productName);

        driver.quit();
    }
    @Test
    public void checkZamovlennia() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/ru/");

        sleep(5000);

        WebElement buyersButton = driver.findElement(By.xpath("//a[contains(@class, 'mh-button--open')]"));

        Assert.assertTrue(buyersButton.isDisplayed());

        buyersButton.click();

        sleep(1000);

        WebElement buyersDropDownMenu = driver.findElement(By.xpath("//div[@class='mh-button__dropdown']"));

        Assert.assertTrue(buyersDropDownMenu.isDisplayed());

        WebElement delyveryAndPayment = driver.findElement(By.xpath("//a[.//span[normalize-space()='Доставка и оплата']]"));

        Assert.assertTrue(delyveryAndPayment.isDisplayed());

        delyveryAndPayment.click();

        sleep(3000);

        WebElement titleShipmentAndDelyvery = driver.findElement(By.xpath("//h2[@class='sp-page-title sp-h2 page-header']"));

        String titleShipmentAndDelyveryText = titleShipmentAndDelyvery.getText();

        Assert.assertTrue(titleShipmentAndDelyveryText.contains("Доставка и оплата"));

        WebElement proceedToCheckout = driver.findElement(By.xpath("//button[@id='defaultOpenDesc' and contains(@onclick, 'Buy')]"));

        Assert.assertTrue(proceedToCheckout.isDisplayed());

        Assert.assertEquals(proceedToCheckout.getText().trim(), "Как оформить заказ?");

        driver.quit();
    }
}


