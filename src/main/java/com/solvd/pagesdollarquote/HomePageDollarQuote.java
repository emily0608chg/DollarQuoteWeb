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

    @FindBy(xpath = "//div[@class='inner relative']/a[2]")
    private ExtendedWebElement buttonMenu;

    @FindBy(xpath = "//a[text()='Cotización Hoy']")
    private ExtendedWebElement validateTextQuote;

    @FindBy(xpath = "//a[text()='Dólar Histórico']")
    private ExtendedWebElement dollarButton;


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

    public WindowsAlertPage closeWindowsAlert() {
        return new WindowsAlertPage(driver);
    }


}
