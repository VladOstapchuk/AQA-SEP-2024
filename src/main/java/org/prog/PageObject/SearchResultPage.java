package org.prog.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.BasePage;
import org.prog.dto.AlloDto.AlloProduct;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private AlloProduct product;
    private List<AlloProduct> alloProductList = new ArrayList<>();

    private final By FitstProductCard = By.xpath("(//div[@class=\"product-card__content\"])[1]/a");
    private final By FitstProductActualPrice = By.xpath("(//div[@class=\"product-card__content\"])[1]//div[@class=\"product-card__buy-box\"]/div/div[2]");
    private final By FirsProductSku = By.xpath("(//div[@class=\"product-card\"])[1]//span[@class=\"product-sku__value\"]");


    //__________________________________________________________________________________________________

    //search results
    public List<AlloProduct> FirstResult(){
        product = new AlloProduct();

        WebElement productName = driver.findElement(FitstProductCard);
        WebElement actualPrice = driver.findElement(FitstProductActualPrice);
        WebElement sku = driver.findElement(FirsProductSku);

        product.setProductName(productName.getText());
        product.setActualPrice(actualPrice.getText().replace("₴", "").replace(" ", ""));
        product.setSku(sku.getAttribute("innerHTML"));
        alloProductList.add(product);
        return alloProductList;
    }

    //results output
    public void PrintResult(){
        System.out.println(product);
    }

}
