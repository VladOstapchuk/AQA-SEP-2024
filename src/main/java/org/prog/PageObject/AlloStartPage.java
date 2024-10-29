package org.prog.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.BasePage;

public class AlloStartPage extends BasePage {

    public AlloStartPage(WebDriver driver) {
        super(driver);
    }
    private final By CloseAdv = By.xpath("//button[@class=\"close\"]");
    private final By SearchForm = By.xpath("//input[@id = \"search-form__input\"]");
    private final By SubmitButton = By.xpath("//button[@type=\"submit\" and @class=\"search-form__submit-button\"]");

    //__________________________________________________________________________________________________


    public AlloStartPage CloseAdv(){
        driver.findElement(CloseAdv).click();
        return this;
    }

    public AlloStartPage SearchForm(String searchphrase){
        WebElement element = driver.findElement(SearchForm);
        element.click();
        element.sendKeys(searchphrase);
        return this;
    }

    public SearchResultPage ClickSubmitButton(){
        driver.findElement(SubmitButton).click();
        return new SearchResultPage(driver);
    }

}
