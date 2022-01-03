package com.weelo.millionandup.util;

public class SelectMonth {

    public static String need(String month){
        switch (month){
            case "01":
                month = "JANUARY";
                break;

            case "02":
                month = "FEBRUARY";
                break;

            case "03":
                month = "MARCH";
                break;

            case "04":
                month = "APRIL";
                break;

            case "05":
                month = "MAY";
                break;

            case "06":
                month = "JUNE";
                break;

            case "07":
                month = "JULY";
                break;

            case "08":
                month = "AUGUST";
                break;

            case "09":
                month = "SEPTEMBER";
                break;

            case "10":
                month = "OCTOBER";
                break;

            case "11":
                month = "NOVEMBER";
                break;

            case "12":
                month = "DECEMBER";
                break;
        }
        return month;
    }

}