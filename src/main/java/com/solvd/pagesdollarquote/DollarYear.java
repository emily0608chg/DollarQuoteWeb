package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.utils.DateWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DollarYear extends AbstractPage {

    @FindBy(xpath="//div[@class='cotizacion-enlaces div-compra2']/a")
    private List<ExtendedWebElement> blockYear;

    public DollarYear(WebDriver driver) {
        super(driver);
    }

    public DateWeb clickYear(String year){
        new WebDriverWait(driver, 4);
        DateWeb dateWeb = new DateWeb();
        for (ExtendedWebElement e: blockYear) {
            dateWeb.setExtractYear("2018");
        }

        return dateWeb;
    }

}
