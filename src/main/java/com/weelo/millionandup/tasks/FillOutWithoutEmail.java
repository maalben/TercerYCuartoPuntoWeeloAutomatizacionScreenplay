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
import static com.weelo.millionandup.userinterfaces.VideocallScheduleUserInterfaces.*;
import static com.weelo.millionandup.util.Constants.UP;

public class FillOutWithoutEmail implements Task {

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
        actor.attemptsTo(Click.on(BUTTON_ACCEPT_SCHEDULE));
    }

    public static FillOutWithoutEmail formVideocall() {
        return Tasks.instrumented(FillOutWithoutEmail.class);
    }
}
