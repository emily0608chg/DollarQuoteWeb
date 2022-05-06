package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageDollarQuote extends AbstractPage {

    public HomePageDollarQuote(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath= "//div[@class='inner relative']/a[2]")
    private ExtendedWebElement buttonMenu;

    @FindBy (xpath = "//ul[@id='main-menu']//*[text()='Cotización Hoy']")
    private ExtendedWebElement validateTextQuote;

    @FindBy (xpath= "//ul[@class='sub-menu']/li[5]//*[text()='Dólar Histórico']")
    private ExtendedWebElement dollarButton;


    public void clickMenuButton(){
        buttonMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inner relative']/a[2]"))));
    }

    public void validateTextQuote(){
        System.out.println(validateTextQuote.getText());

    }

    public void clickDollarButton(){
        dollarButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='sub-menu']/li[5]//*[text()='Dólar Histórico']"))));

    }


}
