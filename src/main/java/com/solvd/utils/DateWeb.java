package com.solvd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateWeb {

    private String webDate;
    private String extractYear;

    public String getTransformDate(String date) throws ParseException {
        StringBuilder formatDate = new StringBuilder(date);
        int i = 0;
        for (i = 0; i < formatDate.length(); i++) {
            if (formatDate.charAt(i) == '/') {
                formatDate.setCharAt(i, '-');
            }
        }
        String dateConverted = DateConvert(String.valueOf(formatDate));
        return dateConverted;
    }

    public String DateConvert(String date) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("MM-dd-yyyy");
        Date inDate = in.parse(date); // 05-19-1990
        SimpleDateFormat out = new SimpleDateFormat("dd-MM-yyyy");
        String newDate = out.format(inDate);
        return newDate;
    }

    //04-04-2018 to 2018
    public String extractYear(String date) {
        StringBuilder year = new StringBuilder(date);

        StringBuilder finalYear = new StringBuilder("");
        for (int i = 6; i < year.length(); i++) {
            String newYear = String.valueOf(year.charAt(i));
            finalYear.append(year.charAt(i));
        }
        String year2 = String.valueOf(finalYear);
        return year2;
    }

    //04-04-18
    public String getCompleteDate(String date) throws ParseException {
        StringBuilder formatDate = new StringBuilder(date);
        int i = 0;
        for (i = 0; i < formatDate.length(); i++) {
            if (formatDate.charAt(i) == '/') {
                formatDate.setCharAt(i, '-');
            }
        }
        String dateConverted2 = DateConvert2(String.valueOf(formatDate));
        return dateConverted2;
    }

    public String DateConvert2(String date) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("MM-dd-yyyy");
        Date inDate = in.parse(date); // 05-19-1990
        SimpleDateFormat out = new SimpleDateFormat("dd-MM-yy");
        String newDate = out.format(inDate);
        return newDate;
    }

    public String getWebDate() {
        return webDate;
    }

    public void setWebDate(String webDate) {
        this.webDate = webDate;
    }

    public String getExtractYear() {

        return extractYear;
    }

    public void setExtractYear(String extractYear) {
        this.extractYear = extractYear;
    }
}
