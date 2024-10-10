package org.prog.testng.homeworks.session5;

import org.openqa.selenium.*;
import org.prog.testng.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlloTestWeb extends BaseTest {

    private final By CloseAdv = By.xpath("//button[@class=\"close\"]");
    private final By SearchForm = By.xpath("//input[@id = \"search-form__input\"]");
    private final By SubmitButton = By.xpath("//button[@type=\"submit\" and @class=\"search-form__submit-button\"]");
    private final By FitstProductCard = By.xpath("(//div[@class=\"product-card__content\"])[1]/a");
    private final By FitstProductActualPrice = By.xpath("(//div[@class=\"product-card__content\"])[1]//div[@class=\"product-card__buy-box\"]/div/div[2]");
    private final By FirsProductSku = By.xpath("(//div[@class=\"product-card\"])[1]//span[@class=\"product-sku__value\"]");

    private String expectedName = "Apple iPhone 16 Pro Max 256GB Black Titanium (MYWV3)";
    private String expectedPrice = "70 999 ₴";
    private String expectedSKU = "1095973";

    @Test
    public void alloFirstTest() throws InterruptedException {

        //open browser, go to test page
        String mainURL = "https://allo.ua/";
        driver.get(mainURL);

        //close advertising window
        driver.findElement(CloseAdv).click();

        //search form input
        WebElement element = driver.findElement(SearchForm);
        element.click();
        element.sendKeys("Iphone 16");

        driver.findElement(SubmitButton).click();

        //search results
        WebElement firstProduct = driver.findElement(FitstProductCard);
        WebElement actualPrice = driver.findElement(FitstProductActualPrice);
        WebElement sku = driver.findElement(FirsProductSku);

        //results output
        System.out.println(firstProduct.getText());
        System.out.println(actualPrice.getText());
        System.out.println(sku.getAttribute("innerHTML"));

        //results asserts
        Assert.assertEquals(firstProduct.getText(), expectedName);
        Assert.assertEquals(actualPrice.getText(), expectedPrice);
        Assert.assertEquals(sku.getAttribute("innerHTML"), expectedSKU);
    }
}