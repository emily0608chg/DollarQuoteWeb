package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DateOptionPage extends AbstractPage {

    public static final Logger LOG = new Logger(DateOptionPage.class.getName());

    @FindBy(xpath = "//option[@class='fecha-historico']")
    private List<ExtendedWebElement> optionDate;

    @FindBy(xpath = "//input[@id='button-historico'] ")
    private ExtendedWebElement buttonQuote;

    public DateOptionPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonQuote() {
        buttonQuote.click();
    }

    public DateOptionPage validateDate(String date) {
        new WebDriverWait(driver, 4);
        for (ExtendedWebElement element : optionDate) {
            String dateOption = element.getText();
            LOG.info(dateOption);
            if (date.equalsIgnoreCase(dateOption)) {
                buttonQuote.click();
                return new DateOptionPage(getDriver());
            }
        }
        throw new RuntimeException("Unable to open date: " + date);
    }
}
