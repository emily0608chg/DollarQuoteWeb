package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WindowsAlertPage extends AbstractUIObject {

    @FindBy (xpath= "//div[contains(@id, 'dismiss-button')]")
    private ExtendedWebElement closeWindowAlert;

    public WindowsAlertPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WindowsAlertPage(WebDriver driver) {
        super(driver);
    }

    public void closeWindowIfPresent(){
        closeWindowAlert.clickIfPresent();
    }

}
