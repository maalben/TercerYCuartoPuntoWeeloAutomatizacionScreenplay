package com.weelo.millionandup.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SelectTime implements Interaction {

    private final String timeVideoCall;

    public SelectTime(String timeVideoCall) {
        this.timeVideoCall = timeVideoCall;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String xpathBase = "//ul[@class='schedule-time-ul']/li";
        List<WebElement> horizontalTime =
                BrowseTheWeb.as(actor).getDriver().findElements(By.xpath(xpathBase));
        for(int horizontal=0; horizontal<horizontalTime.size(); horizontal++){
            if(BrowseTheWeb.as(actor).getDriver().findElement(By.xpath(xpathBase+"["+(horizontal+1)+"]/span[1]")).getText().equals(timeVideoCall)){
                BrowseTheWeb.as(actor).getDriver().findElement(By.xpath(xpathBase+"["+(horizontal+1)+"]/span[1]")).click();
            }
        }
    }

    public static SelectTime required(String timeVideoCall) {
        return new SelectTime(timeVideoCall);
    }
}
