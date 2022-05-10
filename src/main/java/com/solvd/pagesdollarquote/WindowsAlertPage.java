package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsAlertPage extends AbstractUIObject {

    @FindBy(css = "#dismiss-button")
    private ExtendedWebElement closeWindowAlert;

    @FindBy(id = "ad_iframe")
    private ExtendedWebElement adFrame;

    public WindowsAlertPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WindowsAlertPage(WebDriver driver) {
        super(driver);
    }

    public void closeWindowIfPresent() {
        driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
        closeWindowAlert.click();
        driver.switchTo().defaultContent();
    }

}
