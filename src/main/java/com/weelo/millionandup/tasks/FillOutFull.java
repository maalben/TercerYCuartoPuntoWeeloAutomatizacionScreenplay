package com.weelo.millionandup.tasks;

import com.weelo.millionandup.interactions.DisplaceScreen;
import com.weelo.millionandup.interactions.SelectDate;
import com.weelo.millionandup.interactions.SelectTime;
import com.weelo.millionandup.interactions.Wait;
import com.weelo.millionandup.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.weelo.millionandup.userinterfaces.VideocallScheduleUserInterfaces.*;
import static com.weelo.millionandup.util.Constants.UP;

public class FillOutFull implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DisplaceScreen.withDirection(UP));
        actor.attemptsTo(Wait.theNext(2));
        actor.attemptsTo(DisplaceScreen.withDirection(UP));
        actor.attemptsTo(Wait.theNext(1));
        actor.attemptsTo(Click.on(ARROW_BUTTON_SCHEDULE_VIDEOCALL));
        actor.attemptsTo(Click.on(ARROW_BUTTON_CALENDAR));
        actor.attemptsTo(SelectDate.required(TestData.getData().get("dateVideocall").toString()));
        actor.attemptsTo(SelectTime.required(TestData.getData().get("timeVideocall").toString()));
        actor.attemptsTo(Click.on(BUTTON_OPTION_ZOOM));
        actor.attemptsTo(Enter.keyValues(TestData.getData().get("email").toString()).into(TEXTFIELD_EMAIL));
        actor.attemptsTo(Click.on(BUTTON_ACCEPT_SCHEDULE));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("name").toString()).into(TEXTFIELD_NAME));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("mobilePhone").toString()).into(TEXTFIELD_MOBILE_PHONE));
        actor.attemptsTo(Click.on(BUTTON_ACCEPT_SCHEDULE));
    }

    public static FillOutFull formVideocall() {
        return Tasks.instrumented(FillOutFull.class);
    }
}
