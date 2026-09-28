package homePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}

