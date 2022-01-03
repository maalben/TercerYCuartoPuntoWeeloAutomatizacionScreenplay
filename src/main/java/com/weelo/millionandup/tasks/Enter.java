package com.weelo.millionandup.tasks;

import com.weelo.millionandup.userinterfaces.VideocallScheduleUserInterfaces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Enter implements Task {

    private VideocallScheduleUserInterfaces videocallScheduleUserInterfaces;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(videocallScheduleUserInterfaces));
    }

    public static Enter toThePageMillionandup() {
        return instrumented(Enter.class);
    }
}
