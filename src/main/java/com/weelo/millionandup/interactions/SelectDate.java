package com.weelo.millionandup.interactions;

import com.weelo.millionandup.util.SelectMonth;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SelectDate implements Interaction {

    private final String dateVideoCall;

    public SelectDate(String dateVideoCall) {
        this.dateVideoCall = dateVideoCall;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean flag = false;

        String[] splitDate = dateVideoCall.split("-");
        String day = splitDate[0];
        int value = Integer.parseInt(day);
        day = String.valueOf(value);
        String month = SelectMonth.need(splitDate[1]);
        String year = splitDate[2];

        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(dateVideoCall);
            date2 = format.parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(date1.before(date2)){
            String[] splitDate1 = dateVideoCall.split("-");
            String[] splitDate2 = timeStamp.split("-");
            if(!splitDate1[2].equals(splitDate2[2])){
                flag = true;
            }
        }

        String dateSelected = month+" "+year;

        while(!dateSelected.equals(BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText())){

            if(flag){
                BrowseTheWeb.as(actor).getDriver().findElement(
                        By
                                .xpath("//button[@class='fc-prev-button fc-button fc-button-primary']"))
                        .click();
            }else{
                BrowseTheWeb.as(actor).getDriver().findElement(
                        By
                                .xpath("//button[@class='fc-next-button fc-button fc-button-primary']"))
                        .click();
            }
            actor.attemptsTo(Wait.theNext(1));
        }

        List<WebElement> horizontalDay = BrowseTheWeb.as(actor).getDriver().findElements(By.xpath("//table[@class='fc-scrollgrid-sync-table']//td"));
        for(int horizontal=0; horizontal<horizontalDay.size(); horizontal++){
            if(horizontal < 11 && horizontalDay.get(horizontal).getText().equals(day) && Integer.parseInt(day) > 10){
                continue;
            }else{
                if(horizontalDay.get(horizontal).getText().equals(day)){
                    horizontalDay.get(horizontal).click();
                    break;
                }
            }
        }
    }

    public static SelectDate required(String dateVideoCall) {
        return new SelectDate(dateVideoCall);
    }
}
