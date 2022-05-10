package com.solvd.pagesdollarquote;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SellerAndBuyerPage extends AbstractPage {

    public static final Logger LOG = new Logger(SellerAndBuyerPage.class.getName());

    @FindBy(xpath = "//tbody[1]/tr/td/span")
    private List<ExtendedWebElement> optionValue;

    @FindBy(css = "body > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > article:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1)")
    private ExtendedWebElement optionBuyer;

    public SellerAndBuyerPage(WebDriver driver) {
        super(driver);
    }

    public SellerAndBuyerPage validateValue(String value) {
        new WebDriverWait(driver, 4);
        for(ExtendedWebElement e : optionValue){
            String valueOption = e.getText();
            LOG.info(valueOption);
            if(value.equalsIgnoreCase(valueOption)){
                LOG.info(value);
                return new SellerAndBuyerPage(getDriver());
            }
        }
        throw new RuntimeException("Unable to open date: " + value);
    }

    public String buyerOption(String option){
        String opt = optionBuyer.getText();
        if(opt.equalsIgnoreCase(option)){
           LOG.info(option);
        } return opt;
    }
}
