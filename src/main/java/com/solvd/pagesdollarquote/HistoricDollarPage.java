package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HistoricDollarPage extends AbstractPage {

    public static final Logger LOG = new Logger(HistoricDollarPage.class.getName());

    @FindBy(xpath = "//div[@class='cotizacion-enlaces div-compra2']/a")
    private List<ExtendedWebElement> blockYear;

    public HistoricDollarPage(WebDriver driver) {
        super(driver);
    }

    public HistoricDollarPage clickYear(String date) {
        new WebDriverWait(driver, 4);
        for (ExtendedWebElement e : blockYear) {
            String nameYear = e.getText();
            LOG.info(nameYear);
            if (date.equalsIgnoreCase(nameYear)) {
                e.click();
                return new HistoricDollarPage(driver);
            }

        }
        throw new RuntimeException("Unable to open date: " + date);

    }

}
