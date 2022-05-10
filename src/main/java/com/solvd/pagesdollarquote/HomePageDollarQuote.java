package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageDollarQuote extends AbstractPage {

    public HomePageDollarQuote(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='inner relative']/a[2]")
    private ExtendedWebElement buttonMenu;

    @FindBy(xpath = "//a[text()='Cotización Hoy']")
    private ExtendedWebElement validateTextQuote;

    @FindBy(xpath = "//a[text()='Dólar Histórico']")
    private ExtendedWebElement dollarButton;

    @FindBy (css= "#dismiss-button")
    private ExtendedWebElement closeWindowAlert;

    @FindBy(id = "ad_iframe")
    private ExtendedWebElement adFrame;


    public void clickMenuButton() {
        buttonMenu.click();
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inner relative']/a[2]"))));
    }

    public String validateTextQuote() {
        String text = validateTextQuote.getText();
        return text;
    }

    public void clickDollarButton() {
        dollarButton.click();
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Dólar Histórico']"))));
    }

    public void closeWindowIfPresent() {
        driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
        closeWindowAlert.click();

    }


}
