package com.weelo.millionandup.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.weelo.millionandup.userinterfaces.VideocallScheduleUserInterfaces.LABEL_VALIDATION_MESSAGE;

public class VerifyMessageSuccess implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_VALIDATION_MESSAGE, isVisible()).forNoMoreThan(10).seconds());

        return LABEL_VALIDATION_MESSAGE.resolveFor(actor).getText();
    }

    public static VerifyMessageSuccess is() {
        return new VerifyMessageSuccess();
    }
}
