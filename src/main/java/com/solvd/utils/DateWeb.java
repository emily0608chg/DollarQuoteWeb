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
        for(i=0;i<formatDate.length();i++){
            if(formatDate.charAt(i) == '/'){
                formatDate.setCharAt(i, '-');
            }
        }
        String dateConverted = DateConvert(String.valueOf(formatDate));
        setWebDate(dateConverted);
        return dateConverted;
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

    public String DateConvert(String date) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("MM-dd-yyyy");
        Date inDate = in.parse(date); // 05-19-1990
        SimpleDateFormat out = new SimpleDateFormat("dd-MM-yyyy");
        String newDate = out.format(inDate);
        return newDate;
    }
}
