package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.solvd.pagesdollarquote.*;
import com.solvd.utils.DateWeb;
import com.solvd.utils.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Collections;

public class QuoteWebTest implements IAbstractTest {

    public static final Logger LOG = new Logger(QuoteWebTest.class.getName());

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/RandomDates.xlsx", sheet = "Sheet1", dsUid = "Date", dsArgs = "Date, Buyer, Average")
    public void quoteWebTest(String date, String buyer, String average) throws ParseException {

        DateWeb dateWeb = new DateWeb();

        // Day First value
        String dayFirst = dateWeb.getTransformDate(date);
        // Extract Year
        String year = (dateWeb.extractYear(dateWeb.getTransformDate(date)));
        // Date for Web
        String completeDateWeb = dateWeb.getCompleteDate(date);

        HomePageDollarQuote homePageDollarQuote = new HomePageDollarQuote(getDriver());
        homePageDollarQuote.open();
        Assert.assertTrue(homePageDollarQuote.isPageOpened(), "Home page is not open");
        homePageDollarQuote.clickMenuButton();
        Assert.assertEquals(homePageDollarQuote.validateTextQuote(), "Cotización Hoy", "This page is not display");
        homePageDollarQuote.clickDollarButton();
        homePageDollarQuote.closeWindowIfPresent();

        HistoricDollarPage dollarYear = new HistoricDollarPage(getDriver());
        dollarYear.clickYear(year);

        DateOptionPage validateDateWeb = new DateOptionPage(getDriver());
        validateDateWeb.validateDate(completeDateWeb);


        SellerAndBuyerPage optionValue = new SellerAndBuyerPage(getDriver());
        optionValue.buyerOption(buyer);

    }

    @Test
    public void yearTest() {
        HomePageDollarQuote homePageDollarQuote = new HomePageDollarQuote(getDriver());
        homePageDollarQuote.open();
        Assert.assertTrue(homePageDollarQuote.isPageOpened(), "Home page is not open");
        homePageDollarQuote.clickMenuButton();
        Assert.assertEquals(homePageDollarQuote.validateTextQuote(), "Cotización Hoy", "This page is not display");
        homePageDollarQuote.clickDollarButton();
        WindowsAlertPage alert = new WindowsAlertPage(getDriver());
        alert.closeWindowIfPresent();

        HistoricDollarPage dollarYear = new HistoricDollarPage(getDriver());
        dollarYear.clickYear("2008");

        DateOptionPage validateDate = new DateOptionPage(getDriver());
        validateDate.validateDate("04-04-08");

        SellerAndBuyerPage optionValue = new SellerAndBuyerPage(getDriver());
        optionValue.buyerOption("3.15");

    }


}
