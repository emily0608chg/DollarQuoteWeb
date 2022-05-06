package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.solvd.pagesdollarquote.DollarYear;
import com.solvd.utils.DateWeb;
import com.solvd.pagesdollarquote.HomePageDollarQuote;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;

import static com.mongodb.util.MyAsserts.assertTrue;

public class QuoteWebTest implements IAbstractTest {

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/randomDates.xlsx", sheet = "Sheet1", dsUid = "Date", dsArgs = "Date, Average")
    public void quoteWebTest(String date, String average) throws ParseException {

        DateWeb dateWeb = new DateWeb();
        System.out.println(dateWeb.getTransformDate(date) + " " + average);

    }

    @Test
    public void yearTest(){
        HomePageDollarQuote homePageDollarQuote = new HomePageDollarQuote(getDriver());
        homePageDollarQuote.open();
        Assert.assertTrue(homePageDollarQuote.isPageOpened(), "Home page is not open");
        homePageDollarQuote.clickMenuButton();
        assertTrue(homePageDollarQuote.validateTextQuote().contains("Cotización Hoy"), "This page is not display");
        //homePageDollarQuote.clickDollarButton();
        //DollarYear dollarYear = new DollarYear(getDriver());
        //dollarYear.clickYear("2018");
    }











}
